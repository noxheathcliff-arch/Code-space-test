"""Analyse syntaxique complète (spaCy) de textes et mise en cache par phrase.
Usage : python cache.py SORTIE.pkl label source_pattern [label pattern ...]
label = 'h:<livre>:<genre>' ou 'ia:<modele>:<genre>' ; pattern = glob."""
import sys, glob, pickle, re, os
sys.path.insert(0, '/home/user/Code-space-test/.claude/skills/ecriture-humaine/scripts')
import stylo
import spacy
nlp = spacy.load('fr_core_news_md', disable=['ner'])

out = sys.argv[1]
docs = []
args = sys.argv[2:]
for lab, pat in zip(args[::2], args[1::2]):
    for f in sorted(glob.glob(pat)):
        texte = open(f, encoding='utf-8').read()
        paras = stylo.paragraphes(texte)
        brut = []
        for i, p in enumerate(paras):
            d = bool(stylo.DIAL.match(p))
            for j, s in enumerate(stylo._decouper_regex(p)):
                brut.append((s, i, j, d))
        phr = []
        for (s, i, j, d), doc in zip(brut, nlp.pipe([b[0] for b in brut], batch_size=256)):
            toks = [(t.text, t.pos_, t.dep_, str(t.morph), t.lemma_.lower(), t.head.i - doc[0].i if True else 0, t.i - doc[0].i)
                    for t in doc if not t.is_space]
            phr.append({'t': s, 'para': i, 'rang': j, 'dial': d, 'mots': len(stylo.MOT.findall(s)), 'tok': toks})
        y, src, genre = lab.split(':')
        docs.append({'fichier': f, 'y': 1 if y == 'ia' else 0, 'source': src, 'genre': genre, 'phrases': phr})
    print(lab, pat, len(docs), file=sys.stderr)
pickle.dump(docs, open(out, 'wb'))
print('ok', len(docs), 'textes')
