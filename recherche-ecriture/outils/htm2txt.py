import sys, glob, re, os, warnings
from bs4 import BeautifulSoup
warnings.filterwarnings('ignore')
src, out = sys.argv[1], sys.argv[2]
fs = sorted(glob.glob(os.path.join(src, '*.htm')), key=lambda f: int(re.search(r'_(\d+)\.htm$', f).group(1)))
paras = []
for f in fs:
    s = BeautifulSoup(open(f, 'rb').read(), 'lxml')
    for el in s.find_all(['p', 'h1', 'h2', 'h3']):
        t = re.sub(r'\s+', ' ', el.get_text(' ')).strip()
        if t: paras.append(('#' if el.name.startswith('h') else '') + t)
open(out, 'w').write('\n'.join(paras)); print(len(fs), 'fichiers', len(paras), 'paras', sum(len(p.split()) for p in paras), 'mots')
