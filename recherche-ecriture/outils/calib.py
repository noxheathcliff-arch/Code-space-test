import sys, glob, json, statistics as st
sys.path.insert(0, sys.argv[1]); import stylo, diagnostic
P = json.load(open(stylo.REF + '/profils.json'))
nlp = stylo.charger_nlp(); mq = stylo.charger_marqueurs()
def run(files, genre):
    res = []
    for f in files:
        m, ph, pa, fl = diagnostic.analyser(f, genre, nlp, mq)
        _, prio = diagnostic.rapport(m, ph, fl, P[genre], genre, 0)
        narr = max(1, sum(1 for p in ph if not p.dialogue))
        res.append((sum(1 for x in prio if x[0]=='✗'), sum(1 for x in prio if x[0]=='⚠'), 100*len(set(i for i,_,_ in fl))/narr, m['mots']))
    return res
for g, hg, ig in [('fiction','roman','roman'),('pratique','devperso','devperso'),('explicatif','vulga','vulga'),('essai','divers','divers')]:
    H = run(sorted(glob.glob(f'corpus/h/{hg}_*.txt'))[::3], g) if hg!='divers' else []
    A = run(sorted(glob.glob(f'corpus/ia/*/{ig}_*.txt')), g)
    q = lambda v: (min(v), sorted(v)[len(v)//4], st.median(v), sorted(v)[3*len(v)//4], max(v)) if v else None
    for lab, R in (('humain', H), ('IA', A)):
        if R: print(g, lab, len(R), 'nb✗', q([r[0] for r in R]), 'nb⚠', q([r[1] for r in R]), '%signalées', tuple(round(x) for x in q([r[2] for r in R])))
