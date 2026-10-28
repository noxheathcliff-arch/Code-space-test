"""Entraîne le modèle de points (régression logistique sur fenêtres de 3 phrases) et l'exporte en JSON.
Nécessite scikit-learn (uniquement pour l'entraînement ; points.py n'en a pas besoin).

Usage :
  python3 entrainer_modele.py --humain fiction:livre.txt --humain pratique:dossier/ \\
      --ia fiction:"ia/*/roman_*.txt" --ia pratique:"ia/*/devperso_*.txt" [--ia-extra "ia/*/divers_*.txt"] \\
      [--sortie ../references/modele_points.json]

- Les textes humains longs sont découpés en extraits de ~900 mots.
- Un mot de contenu n'entre dans le modèle que si son biais (IA ou humain) va dans le même sens dans tous les genres
  où il apparaît assez (au moins deux genres) : cela écarte les mots liés au sujet d'un livre.
- Validation croisée groupée : un même sujet de consigne (IA) ou des extraits voisins d'un même livre (humain)
  ne sont jamais à la fois dans l'entraînement et dans le test."""
import argparse, collections, glob, json, math, os, sys
import numpy as np
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import stylo, points


def lire_sources(specs, decoupe=900):
    out = []  # (genre, id_groupe, texte)
    for spec in specs:
        genre, _, motif = spec.partition(':')
        fichiers = []
        for m in motif.split(','):
            fichiers += sorted(glob.glob(os.path.join(m, '*.txt'))) if os.path.isdir(m) else sorted(glob.glob(m))
        for f in fichiers:
            t = open(f, encoding='utf-8').read()
            base = os.path.splitext(os.path.basename(f))[0]
            if len(t.split()) > 1.6 * decoupe:
                for k, e in enumerate(extraits(t, decoupe)):
                    out.append((genre, f'{genre}:{base}:{k // 8}', e))
            else:
                num = ''.join(ch for ch in base if ch.isdigit())
                grp = f'{genre}:{base.split("_")[0]}:{int(num) // 8 if num and len(num) >= 3 else base}'
                out.append((genre, grp, t))
    return out


def extraits(t, taille):
    paras = stylo.paragraphes(t)
    buf, n, out = [], 0, []
    for p in paras:
        buf.append(p); n += len(p.split())
        if n >= taille:
            out.append('\n'.join(buf)); buf, n = [], 0
    if n >= 0.6 * taille:
        out.append('\n'.join(buf))
    return out


def echantillons(sources, label, nlp, mq):
    res = []
    for ti, (genre, grp, texte) in enumerate(sources):
        phrases, _ = stylo.segmenter(texte, nlp)
        traits = [points.traits_phrase(p, mq) for p in phrases]
        for idx in points.fenetres(phrases):
            v, mots = points.vecteur(idx, phrases, traits)
            res.append({'v': v, 'y': label, 'genre': genre, 'groupe': grp, 'texte': f'{label}:{ti}', 'mots': mots,
                        'brut': {k: c for i in idx for k, c in traits[i].items()}})
    return res


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('--humain', action='append', required=True)
    ap.add_argument('--ia', action='append', required=True)
    ap.add_argument('--ia-extra', default=None)
    ap.add_argument('--sortie', default=os.path.join(stylo.REF, 'modele_points.json'))
    ap.add_argument('--C', type=float, default=None)
    a = ap.parse_args()
    from sklearn.feature_extraction import DictVectorizer
    from sklearn.linear_model import LogisticRegression
    from sklearn.model_selection import GroupKFold
    from sklearn.metrics import roc_auc_score

    nlp, mq = stylo.charger_nlp(), stylo.charger_marqueurs()
    H = echantillons(lire_sources(a.humain), 0, nlp, mq)
    ia_specs = list(a.ia) + ([f'extra:{a.ia_extra}'] if a.ia_extra else [])
    A = echantillons(lire_sources(ia_specs), 1, nlp, mq)
    for s in A:  # le même sujet de consigne pour les trois modèles → même groupe
        s['groupe'] = 'ia:' + s['groupe'].split(':', 1)[1]
    data = H + A
    print(f'Fenêtres : {len(H)} humaines, {len(A)} IA', file=sys.stderr)

    # sélection du vocabulaire
    df = collections.Counter()
    for s in data:
        df.update(s['v'].keys())
    compte = collections.defaultdict(lambda: collections.defaultdict(float))  # (genre, y) → trait → compte brut
    mots_g = collections.defaultdict(float)
    for s in data:
        for k, c in s['brut'].items():
            compte[(s['genre'], s['y'])][k] += c
        mots_g[(s['genre'], s['y'])] += s['mots']
    genres = sorted({g for g, y in compte if y == 0})
    garde = set()
    for k, n in df.items():
        if n < 15:
            continue
        if not k.startswith('L:'):
            garde.add(k); continue
        signes = []
        for g in genres:
            ch, ca = compte[(g, 0)].get(k, 0), compte[(g, 1)].get(k, 0)
            if ch + ca < 4 or mots_g[(g, 1)] == 0:
                continue
            r = math.log((ca + .5) / mots_g[(g, 1)]) - math.log((ch + .5) / mots_g[(g, 0)])
            signes.append(r)
        if len(signes) >= 2 and (all(r > math.log(1.4) for r in signes) or all(r < -math.log(1.4) for r in signes)):
            garde.add(k)
    print(f'Traits retenus : {len(garde)} (dont mots de contenu cohérents : {sum(1 for k in garde if k.startswith("L:"))})', file=sys.stderr)

    dv = DictVectorizer()
    X = dv.fit_transform([{k: c for k, c in s['v'].items() if k in garde} for s in data])
    y = np.array([s['y'] for s in data])
    grp = np.array([s['groupe'] for s in data])
    gkf = GroupKFold(n_splits=5)

    def cv(C):
        oof = np.zeros(len(y))
        for tr, te in gkf.split(X, y, grp):
            m = LogisticRegression(C=C, class_weight='balanced', max_iter=3000)
            m.fit(X[tr], y[tr]); oof[te] = m.predict_proba(X[te])[:, 1]
        return oof

    best = None
    for C in ([a.C] if a.C else [0.02, 0.05, 0.1, 0.3]):
        oof = cv(C)
        auc = roc_auc_score(y, oof)
        print(f'C={C} : AUC fenêtres (validation croisée groupée) = {auc:.3f}', file=sys.stderr)
        if best is None or auc > best[0]:
            best = (auc, C, oof)
    auc, C, oof = best
    # niveau texte
    par_texte = collections.defaultdict(lambda: [0.0, 0.0, None])
    for s, p in zip(data, oof):
        t = par_texte[s['texte']]; t[0] += p * s['mots']; t[1] += s['mots']; t[2] = s['y']
    ty = np.array([v[2] for v in par_texte.values()]); tp = np.array([v[0] / v[1] for v in par_texte.values()])
    auc_t = roc_auc_score(ty, tp)
    hum = sorted(round(100 * (1 - p)) for p, yy in zip(tp, ty) if yy == 0)
    ia = sorted(round(100 * (1 - p)) for p, yy in zip(tp, ty) if yy == 1)
    q = lambda v, f: v[min(len(v) - 1, int(f * (len(v) - 1)))]
    print(f'AUC textes = {auc_t:.3f} ; humanité humains p10/p50 = {q(hum, .1)}/{q(hum, .5)} ; IA p50/p90 = {q(ia, .5)}/{q(ia, .9)}', file=sys.stderr)

    m = LogisticRegression(C=C, class_weight='balanced', max_iter=3000).fit(X, y)
    noms = dv.get_feature_names_out()
    poids = {n: round(float(w), 4) for n, w in zip(noms, m.coef_[0]) if abs(w) >= 0.005}
    out = {'intercept': round(float(m.intercept_[0]), 4), 'echelle_mots': points.ECHELLE, 'C': C, 'poids': poids,
           'validation': {'auc_fenetres': round(auc, 3), 'auc_textes': round(auc_t, 3),
                          'n_fenetres_humaines': len(H), 'n_fenetres_ia': len(A)},
           'calibration': {'humain_p10': q(hum, .1), 'humain_p25': q(hum, .25), 'humain_p50': q(hum, .5),
                           'ia_p50': q(ia, .5), 'ia_p90': q(ia, .9)},
           'seuil_fenetre': 0.5}
    json.dump(out, open(a.sortie, 'w'), ensure_ascii=False, indent=0)
    print(f'Modèle écrit : {a.sortie} ({len(poids)} poids)', file=sys.stderr)


if __name__ == '__main__':
    main()
