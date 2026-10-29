import sys, zipfile, re, posixpath
from bs4 import BeautifulSoup
def spine(z):
    c = BeautifulSoup(z.read('META-INF/container.xml'), 'xml')
    opf = c.find('rootfile')['full-path']
    o = BeautifulSoup(z.read(opf), 'xml')
    base = posixpath.dirname(opf)
    man = {i['id']: i['href'] for i in o.find_all('item')}
    return [posixpath.normpath(posixpath.join(base, man[r['idref']])) for r in o.find('spine').find_all('itemref') if r['idref'] in man]
src, out = sys.argv[1], sys.argv[2]
z = zipfile.ZipFile(src)
paras = []
for p in spine(z):
    try: h = z.read(p)
    except KeyError: continue
    s = BeautifulSoup(h, 'lxml')
    for t in s(['script','style']): t.decompose()
    for el in s.find_all(['p','h1','h2','h3','h4','li','blockquote']):
        if el.find(['p','li']): continue
        t = re.sub(r'\s+', ' ', el.get_text(' ')).strip()
        if t: paras.append(('#' if el.name.startswith('h') else '') + t)
open(out,'w').write('\n'.join(paras))
print(out, len(paras), 'paras', sum(len(x.split()) for x in paras), 'mots')
