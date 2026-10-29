"""Comparaison humain vs IA par genre.
Usage : python compare.py humain.jsonl ia.jsonl OUTDIR"""
import sys, json, os, math, re, collections, statistics as st

hum = [json.loads(l) for l in open(sys.argv[1])]
ia = [json.loads(l) for l in open(sys.argv[2])]
out = sys.argv[3]
os.makedirs(out, exist_ok=True)


def genre(path):
    return os.path.basename(path).split('_')[0]


def model(path):
    p = path.split('/')
    return p[-2] if 'ia' in p else 'humain'


def cliff(a, b):
    # P(a>b) - P(a<b) ; a = IA, b = humain
    gt = lt = 0
    for x in a:
        for y in b:
            if x > y: gt += 1
            elif x < y: lt += 1
    return (gt - lt) / max(1, len(a) * len(b))


def logodds(ca, cb, prior, top=60, minc=5):
    """Monroe et al. 2008, log-odds avec a priori de Dirichlet informatif. Positif = sur-représenté en A."""
    na, nb, a0 = sum(ca.values()), sum(cb.values()), sum(prior.values())
    res = []
    for w in set(ca) | set(cb):
        ya, yb = ca.get(w, 0), cb.get(w, 0)
        if ya + yb < minc:
            continue
        aw = prior.get(w, 0) + 0.01
        d = math.log((ya + aw) / (na + a0 - ya - aw)) - math.log((yb + aw) / (nb + a0 - yb - aw))
        var = 1 / (ya + aw) + 1 / (yb + aw)
        res.append((d / math.sqrt(var), w, ya, yb))
    res.sort(reverse=True)
    return res[:top], res[-top:][::-1]


def docfreq(rows, key, n=1):
    c = collections.Counter()
    for r in rows:
        seq = r[key]
        grams = set(' '.join(seq[i:i + n]) for i in range(len(seq) - n + 1))
        c.update(grams)
    return c


def counts(rows, key, n=1):
    c = collections.Counter()
    for r in rows:
        seq = r[key]
        c.update(' '.join(seq[i:i + n]) for i in range(len(seq) - n + 1))
    return c


report = []
genres = sorted(set(genre(r['file']) for r in hum))
feat_names = list(hum[0]['feats'].keys())
summary = {}
for g in genres:
    H = [r for r in hum if genre(r['file']) == g]
    A = [r for r in ia if genre(r['file']) == g]
    if not A:
        continue
    models = sorted(set(model(r['file']) for r in A))
    report.append(f'\n## Genre : {g}  (humain n={len(H)} extraits ; IA n={len(A)} : ' + ', '.join(f'{m}={sum(1 for r in A if model(r["file"])==m)}' for m in models) + ')\n')
    report.append('| trait | humain méd. | ' + ' | '.join(f'{m} méd.' for m in models) + ' | δ Cliff IA–hum |')
    report.append('|---|---|' + '---|' * len(models) + '---|')
    rows = []
    for fn in feat_names:
        hv = [r['feats'][fn] for r in H]
        av = [r['feats'][fn] for r in A]
        d = cliff(av, hv)
        meds = [st.median([r['feats'][fn] for r in A if model(r['file']) == m]) for m in models]
        rows.append((abs(d), fn, st.median(hv), meds, d))
    rows.sort(reverse=True)
    summary[g] = {fn: (d, mh, meds) for _, fn, mh, meds, d in rows}
    for _, fn, mh, meds, d in rows:
        report.append(f'| {fn} | {mh:.2f} | ' + ' | '.join(f'{m:.2f}' for m in meds) + f' | {d:+.2f} |')
    # lexique : fréquence documentaire pour éviter qu'un seul texte domine
    prior = counts(hum + ia, 'lemmas')
    for n, label in [(1, 'lemmes'), (2, 'bigrammes de lemmes'), (3, 'trigrammes de lemmes')]:
        ca, ch = docfreq(A, 'lemmas', n), docfreq(H, 'lemmas', n)
        pr = counts(hum + ia, 'lemmas', n) if n > 1 else prior
        # normalisation : comparer des proportions de documents → pondérer
        top_ia, top_h = logodds(ca, ch, pr, top=50, minc=6)
        report.append(f'\n### {g} — {label} sur-représentés chez l\'IA (z, docs IA/{len(A)}, extraits hum/{len(H)})\n')
        report.append(', '.join(f'{w} ({z:.1f}; {a}/{b})' for z, w, a, b in top_ia))
        report.append(f'\n### {g} — {label} sur-représentés chez l\'humain\n')
        report.append(', '.join(f'{w} ({z:.1f}; {a}/{b})' for z, w, a, b in top_h))
    ca, ch = counts(A, 'posgrams'), counts(H, 'posgrams')
    top_ia, top_h = logodds(ca, ch, counts(hum + ia, 'posgrams'), top=40, minc=10)
    report.append(f'\n### {g} — gabarits syntaxiques (4-grammes POS/mots-outils) sur-représentés chez l\'IA\n')
    report.append('\n'.join(f'- `{w}` z={z:.1f} ({a} vs {b})' for z, w, a, b in top_ia))
    report.append(f'\n### {g} — gabarits sur-représentés chez l\'humain\n')
    report.append('\n'.join(f'- `{w}` z={z:.1f} ({a} vs {b})' for z, w, a, b in top_h))
    # ouvertures de phrase
    oa, oh = collections.Counter(), collections.Counter()
    for r in A: oa.update(r['opens'])
    for r in H: oh.update(r['opens'])
    ta, th = sum(oa.values()), sum(oh.values())
    report.append(f'\n### {g} — mots d\'ouverture de phrase (% des phrases)\n')
    report.append('IA : ' + ', '.join(f'{w} {100*c/ta:.1f}' for w, c in oa.most_common(20)))
    report.append('\nHumain : ' + ', '.join(f'{w} {100*c/th:.1f}' for w, c in oh.most_common(20)))
    # homogénéité inter-textes : Jaccard moyen des trigrammes de lemmes
    def jac(rows):
        sets = [set(' '.join(r['lemmas'][i:i + 3]) for i in range(len(r['lemmas']) - 2)) for r in rows]
        vals = [len(a & b) / max(1, len(a | b)) for i, a in enumerate(sets) for b in sets[i + 1:]]
        return st.mean(vals) if vals else 0
    report.append(f'\n### {g} — homogénéité (Jaccard moyen trigrammes de lemmes entre textes)\n')
    for m in models:
        report.append(f'- {m} : {jac([r for r in A if model(r["file"]) == m]):.4f}')
    report.append(f'- humain (même livre, extraits espacés) : {jac(H[::max(1, len(H)//10)][:10]):.4f}')

open(f'{out}/comparaison.md', 'w').write('\n'.join(report))
json.dump(summary, open(f'{out}/summary.json', 'w'), ensure_ascii=False)
print('écrit', f'{out}/comparaison.md')
