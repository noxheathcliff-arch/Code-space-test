"""Entraînement et validation « livre tenu à l'écart » du modèle de points, à partir des caches spaCy.
Usage : python lobo.py ml/humain.pkl ml/ia1.pkl [ml/ia2.pkl] [--export chemin.json] [--sans-decisions]"""
import sys, pickle, collections, math, json, re, os
import numpy as np
sys.path.insert(0, '/home/user/Code-space-test/.claude/skills/ecriture-humaine/scripts')
import stylo, points
from sklearn.feature_extraction import DictVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import roc_auc_score

args = [a for a in sys.argv[1:] if not a.startswith('--')]
export = sys.argv[sys.argv.index('--export') + 1] if '--export' in sys.argv else None
if export in args:
    args.remove(export)
sans_dec = '--sans-decisions' in sys.argv
G4 = '--g4' in sys.argv
CVAL = float(sys.argv[sys.argv.index('--C') + 1]) if '--C' in sys.argv else 0.3
if '--C' in sys.argv:
    args.remove(sys.argv[sys.argv.index('--C') + 1])
docs = []
for f in args:
    docs += pickle.load(open(f, 'rb'))
mq = stylo.charger_marqueurs()

samples = []
for ti, d in enumerate(docs):
    ph = [stylo.Phrase(p['t'], p['para'], p['rang'], p['dial'], [(t[0], t[1], t[3], t[4]) for t in p['tok']]) for p in d['phrases']]
    if not ph:
        continue
    tr = points.traits_texte(ph, mq)
    if G4:
        for p_, f_ in zip(ph, tr):
            tags = ['<s>'] + [points.etiquette(t) for t in p_.tokens] + ['</s>']
            for i in range(len(tags) - 3):
                k = 'H:' + ' '.join(tags[i:i + 4]); f_[k] = f_.get(k, 0) + 1
    if sans_dec:
        tr = [{k: v for k, v in f.items() if k[0] not in 'DER'} for f in tr]
    base = os.path.splitext(os.path.basename(d['fichier']))[0]
    if d['y']:
        grp = 'ia:' + re.sub(r'^(roman|devperso|vulga|divers)_', r'\1', base)  # même consigne → même groupe
    else:
        grp = 'h:' + d['source']
    for idx in points.fenetres(ph):
        v, mots = points.vecteur(idx, ph, tr)
        brut = collections.Counter()
        for i in idx:
            brut.update(tr[i])
        samples.append({'v': v, 'y': d['y'], 'genre': d['genre'], 'src': d['source'], 'grp': grp, 'doc': ti, 'mots': mots, 'brut': brut})
y = np.array([s['y'] for s in samples])
print(f'fenêtres : {sum(y == 0)} humaines, {sum(y == 1)} IA', file=sys.stderr)

# poids : chaque livre humain pèse autant ; l'IA pèse autant que l'ensemble humain
livres = collections.Counter(s['src'] for s in samples if s['y'] == 0)
n_ia = sum(y == 1)
w = np.array([(1.0 / livres[s['src']]) * (n_ia / len(livres)) if s['y'] == 0 else 1.0 for s in samples])


def vocab(idx):
    df = collections.Counter()
    for i in idx:
        df.update(samples[i]['v'].keys())
    cpt = collections.defaultdict(lambda: collections.defaultdict(float)); mots = collections.defaultdict(float)
    for i in idx:
        s = samples[i]
        for k, c in s['brut'].items():
            cpt[(s['genre'], s['y'])][k] += c
        mots[(s['genre'], s['y'])] += s['mots']
    genres = sorted({g for g, yy in cpt if yy == 0})
    keep = set()
    for k, n in df.items():
        if n < 20:
            continue
        if not k.startswith('L:'):
            keep.add(k); continue
        r = []
        for g in genres:
            ch, ca = cpt[(g, 0)].get(k, 0), cpt[(g, 1)].get(k, 0)
            if ch + ca < 5 or not mots[(g, 1)]:
                continue
            r.append(math.log((ca + .5) / mots[(g, 1)]) - math.log((ch + .5) / mots[(g, 0)]))
        if len(r) >= 2 and (all(x > math.log(1.4) for x in r) or all(x < -math.log(1.4) for x in r)):
            keep.add(k)
    return keep


def fit(idx, C=None):
    C = C or CVAL
    keep = vocab(idx)
    dv = DictVectorizer()
    X = dv.fit_transform([{k: c for k, c in samples[i]['v'].items() if k in keep} for i in idx])
    m = LogisticRegression(C=C, max_iter=4000)
    m.fit(X, y[idx], sample_weight=w[idx])
    return dv, m


def predict(dv, m, idx):
    return m.predict_proba(dv.transform([samples[i]['v'] for i in idx]))[:, 1]


# validation « livre tenu à l'écart » : on retire un livre humain ET un cinquième des consignes IA
ia_grps = sorted({s['grp'] for s in samples if s['y'] == 1})
rng = np.random.RandomState(0); rng.shuffle(ia_grps)
res = []
coefs = []
for k, livre in enumerate(sorted(livres)):
    test_ia = set(ia_grps[k::len(livres)])
    te = [i for i, s in enumerate(samples) if (s['y'] == 0 and s['src'] == livre) or (s['y'] == 1 and s['grp'] in test_ia)]
    tr = [i for i, s in enumerate(samples) if not ((s['y'] == 0 and s['src'] == livre) or (s['y'] == 1 and s['grp'] in test_ia))]
    dv, m = fit(tr)
    p = predict(dv, m, te)
    auc = roc_auc_score(y[te], p)
    # niveau texte
    agg = collections.defaultdict(lambda: [0., 0., 0])
    for i, pp in zip(te, p):
        a = agg[samples[i]['doc']]; a[0] += pp * samples[i]['mots']; a[1] += samples[i]['mots']; a[2] = samples[i]['y']
    hum = [100 * (1 - a[0] / a[1]) for a in agg.values() if a[2] == 0]
    ia = [100 * (1 - a[0] / a[1]) for a in agg.values() if a[2] == 1]
    res.append((livre, auc, np.median(hum), np.percentile(hum, 10), np.median(ia), np.percentile(ia, 90)))
    coefs.append(dict(zip(dv.get_feature_names_out(), m.coef_[0])))
    print(f'{livre:12s} AUC fenêtres {auc:.3f} · humanité du livre inconnu : médiane {np.median(hum):.0f} (p10 {np.percentile(hum, 10):.0f}) · IA inconnue médiane {np.median(ia):.0f} (p90 {np.percentile(ia, 90):.0f})', file=sys.stderr)
print(f'MOYENNE AUC livre tenu à l\'écart : {np.mean([r[1] for r in res]):.3f}', file=sys.stderr)

# invariants : traits de même signe dans tous les modèles où ils existent (au moins 8 sur 9)
tous = collections.defaultdict(list)
for c in coefs:
    for k, v in c.items():
        tous[k].append(v)
inv = [(np.mean(v), k) for k, v in tous.items() if len(v) >= len(coefs) - 1 and (all(x > 0.05 for x in v) or all(x < -0.05 for x in v))]
inv.sort()
json.dump({'lobo': [list(map(lambda x: x if isinstance(x, str) else float(x), r)) for r in res],
           'invariants_humains': [(k, float(v)) for v, k in inv if v < 0][:150],
           'invariants_ia': [(k, float(v)) for v, k in inv[::-1] if v > 0][:150]},
          open('ml/lobo.json', 'w'), ensure_ascii=False, indent=0)
print(f'invariants : {sum(1 for v, k in inv if v < 0)} humains, {sum(1 for v, k in inv if v > 0)} IA', file=sys.stderr)

if export:
    tout = list(range(len(samples)))
    dv, m = fit(tout)
    poids = {n: round(float(c), 4) for n, c in zip(dv.get_feature_names_out(), m.coef_[0]) if abs(c) >= 0.005}
    hum_med = np.median([r[2] for r in res]); hum_p10 = np.median([r[3] for r in res])
    ia_med = np.median([r[4] for r in res]); ia_p90 = np.median([r[5] for r in res])
    json.dump({'intercept': round(float(m.intercept_[0]), 4), 'echelle_mots': points.ECHELLE, 'C': 0.3, 'poids': poids,
               'validation': {'methode': 'livre tenu à l\'écart (9 livres) + consignes IA tenues à l\'écart',
                              'auc_fenetres_moyenne': round(float(np.mean([r[1] for r in res])), 3),
                              'par_livre': {r[0]: round(float(r[1]), 3) for r in res}},
               'calibration': {'humain_p10': int(round(hum_p10)), 'humain_p50': int(round(hum_med)),
                               'ia_p50': int(round(ia_med)), 'ia_p90': int(round(ia_p90))},
               'livres': sorted(livres), 'seuil_fenetre': 0.5}, open(export, 'w'), ensure_ascii=False, indent=0)
    print('exporté', export, len(poids), 'poids', file=sys.stderr)
