"""Lexique et expressions sur-représentés chez l'IA, robustes au sujet.
Un item n'est retenu que s'il est sur-représenté dans plusieurs genres IA à la fois
et présent dans des textes issus de briefs différents.
Usage : python lexique.py humain.jsonl ia.jsonl OUT.md OUT.json"""
import sys, json, math, collections, os

hum = [json.loads(l) for l in open(sys.argv[1])]
ia = [json.loads(l) for l in open(sys.argv[2])]


def genre(p): return os.path.basename(p['file']).split('_')[0]


def grams(seq, n): return [' '.join(seq[i:i + n]) for i in range(len(seq) - n + 1)]


STOP_TOPIC = set()
results = {}
md = []
for n in (1, 2, 3):
    # comptes par token
    H = collections.Counter(); A = collections.Counter()
    Ag = collections.defaultdict(collections.Counter)  # genre -> compte
    Adocs = collections.Counter()
    for r in hum: H.update(grams(r['lemmas'], n))
    for r in ia:
        g = grams(r['lemmas'], n)
        A.update(g); Ag[genre(r)].update(g); Adocs.update(set(g))
    Hg = collections.defaultdict(collections.Counter)
    for r in hum: Hg[genre(r)].update(grams(r['lemmas'], n))
    nH, nA = sum(H.values()), sum(A.values())
    rows = []
    for w, ca in A.items():
        if Adocs[w] < max(6, 0.08 * len(ia)):
            continue
        ch = H.get(w, 0)
        ra, rh = ca / nA * 1e5, (ch + 0.5) / nH * 1e5
        ratio = ra / rh
        # nombre de genres IA où le mot est sur-représenté par rapport à l'humain du même genre (ou global si pas d'humain)
        ok = 0
        for g, c in Ag.items():
            ng = sum(c.values())
            hc = Hg.get(g)
            if hc:
                rr = (c[w] / ng) / ((hc.get(w, 0) + 0.5) / sum(hc.values()))
            else:
                rr = (c[w] / ng) / ((ch + 0.5) / nH)
            if rr >= 2: ok += 1
        if ratio >= 2.5 and ok >= 3:
            rows.append((ratio, w, ca, ch, Adocs[w], ok))
    rows.sort(reverse=True)
    results[n] = rows[:120]
    md.append(f'\n## {n}-grammes de lemmes sur-représentés chez l\'IA (ratio de fréquence IA/humain ; occurrences IA/hum ; nb docs IA sur {len(ia)} ; nb genres où ratio≥2)\n')
    md.append(', '.join(f'{w} (×{r:.1f}; {a}/{h}; {d}d; {k}g)' for r, w, a, h, d, k in rows[:120]))
    # et l'inverse : sur-représentés chez l'humain (dans ≥2 genres humains)
    rows2 = []
    Hdocs = collections.Counter()
    for r in hum: Hdocs.update(set(grams(r['lemmas'], n)))
    for w, ch in H.items():
        if Hdocs[w] < 10: continue
        ca = A.get(w, 0)
        ratio = (ch / nH) / ((ca + 0.5) / nA)
        okg = sum(1 for g, c in Hg.items() if (c[w] / sum(c.values())) / ((Ag[g].get(w, 0) + 0.5) / max(1, sum(Ag[g].values()))) >= 2)
        if ratio >= 2.5 and okg >= 2:
            rows2.append((ratio, w, ch, ca, Hdocs[w], okg))
    rows2.sort(reverse=True)
    md.append(f'\n## {n}-grammes sur-représentés chez l\'HUMAIN (ratio hum/IA ; occ hum/IA ; docs hum ; nb genres)\n')
    md.append(', '.join(f'{w} (×{r:.1f}; {h}/{a}; {d}d; {k}g)' for r, w, h, a, d, k in rows2[:100]))
open(sys.argv[3], 'w').write('\n'.join(md))
json.dump({str(k): v for k, v in results.items()}, open(sys.argv[4], 'w'), ensure_ascii=False)
print('ok')
