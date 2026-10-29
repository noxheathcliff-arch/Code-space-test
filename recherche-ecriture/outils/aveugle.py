"""Prépare un lot d'extraits anonymisés pour un test à l'aveugle."""
import glob, random, re, json, os, sys
S = sys.argv[1]; out = os.path.join(S, 'aveugle'); os.makedirs(out, exist_ok=True)
random.seed(7)
def norm(t):
    t = t.replace('’', "'").replace(' ', ' ').replace('\xa0', ' ').replace('…', '...')
    t = re.sub(r'^#.*$', '', t, flags=re.M)
    t = re.sub(r'\*\*?', '', t)
    paras = [p.strip() for p in re.split(r'\n+', t) if p.strip()]
    res, n = [], 0
    for p in paras:
        res.append(p); n += len(p.split())
        if n >= 380: break
    return '\n\n'.join(res)
items = []
gmap = {'F': 'roman', 'P': 'devperso', 'E': 'vulga'}
for cond in ['brut_sonnet', 'brut_opus', 'skill_sonnet', 'skill_opus']:
    for f in sorted(glob.glob(f'{S}/test/{cond}/*.txt')):
        items.append((cond, os.path.basename(f)[:-4], norm(open(f).read())))
# humains : extraits du jeu de test (non utilisés pour construire les profils de validation)
for g, n in [('roman', 8), ('devperso', 6), ('vulga', 6)]:
    fs = sorted(glob.glob(f'{S}/split/test_{g}/*.txt')); random.shuffle(fs)
    for f in fs[:n]:
        items.append(('humain', g, norm(open(f).read())))
random.shuffle(items)
cle = {}
with open(f'{out}/extraits.md', 'w') as fo:
    for i, (c, src, t) in enumerate(items, 1):
        fo.write(f'=== EXTRAIT {i:02d} ===\n{t}\n\n'); cle[i] = (c, src)
json.dump(cle, open(f'{out}/cle.json', 'w'))
print(len(items), 'extraits ;', {c: sum(1 for x in items if x[0] == c) for c in set(x[0] for x in items)})
