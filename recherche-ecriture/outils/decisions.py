"""Analyses des points de décision, du rythme, de l'émotion et de la structure narrative (humain vs IA).
Usage : python decisions.py humain.pkl ia1.pkl [ia2.pkl] > rapport.md ; écrit aussi ml/decisions.json"""
import sys, pickle, collections, json, math, re, statistics as st

docs = []
for f in sys.argv[1:]:
    docs += pickle.load(open(f, 'rb'))

PRON_SUJ = {'je', 'tu', 'il', 'elle', 'on', 'nous', 'vous', 'ils', 'elles'}
CONNECT = {'et', 'mais', 'car', 'donc', 'puis', 'alors', 'ainsi', 'pourtant', 'cependant', 'enfin', 'ensuite', 'or',
           'aussi', 'néanmoins', 'toutefois', 'd\'ailleurs', 'bref', 'du coup', 'sinon', 'certes', 'en effet'}
ANAPH = {'il', 'elle', 'ils', 'elles', 'ce', 'cela', 'ça', 'celui', 'celle', 'ceux', 'celles', 'c\''}
EMO = set('''peur crainte terreur effroi angoisse anxiété panique colère rage fureur irritation agacement tristesse chagrin peine
désespoir mélancolie joie bonheur allégresse plaisir honte culpabilité gêne embarras jalousie envie haine dégoût mépris surprise
étonnement soulagement espoir amour tendresse fierté solitude nostalgie regret émotion sentiment effrayé terrifié furieux triste
heureux joyeux honteux coupable jaloux soulagé ému anxieux nervosité nerveux inquiet inquiétude angoissé désespéré fier gêné
craindre redouter apeuré paniqué exaspéré bouleversé émouvoir effrayer terrifier'''.split())
CORPS = set('''cœur poitrine gorge souffle respiration respirer ventre estomac main doigt jambe genou peau frisson frissonner trembler
tremblement sueur transpirer larme pleurer joue rougir pâlir nausée vertige mâchoire poing serrer cogner nœud glacer brûler lèvre
paupière nuque épaule dos tempe pouls sang tripes haleter suffoquer'''.split())


def premier(tok):
    i = 0
    while i < len(tok) and tok[i][1] in ('PUNCT', 'SPACE', 'SYM'):
        i += 1
    return i


def ouverture(tok):
    i = premier(tok)
    if i >= len(tok):
        return 'vide'
    t, pos, dep, morph, lem = tok[i][:5]
    nxt = tok[i + 1] if i + 1 < len(tok) else ('', '', '', '', '')
    if lem == 'en' and nxt[1] in ('VERB', 'AUX') and 'Part' in nxt[3]:
        return 'gérondif'
    if pos == 'SCONJ' or lem in ('lorsque', 'quand', 'si', 'comme', 'puisque', 'tandis'):
        return 'subordonnée'
    if pos == 'CCONJ' or lem in CONNECT:
        return 'connecteur'
    if pos == 'ADV':
        return 'adverbe'
    if pos == 'ADP':
        return 'complément prépositionnel'
    if pos in ('VERB', 'AUX'):
        return 'participe' if 'Part' in morph else 'verbe (impératif/inversion)'
    if pos == 'PRON':
        return 'pronom sujet' if t.lower() in PRON_SUJ or dep.startswith('nsubj') else 'pronom autre'
    if pos == 'PROPN':
        return 'nom propre'
    if pos in ('DET', 'NOUN'):
        return 'groupe nominal'
    if pos == 'ADJ':
        return 'adjectif'
    if pos == 'NUM':
        return 'nombre'
    if pos == 'INTJ':
        return 'interjection'
    return 'autre'


def lien(prev, cur):
    i = premier(cur['tok'])
    if i >= len(cur['tok']):
        return 'vide'
    t = cur['tok'][i]
    if t[4] in CONNECT or t[1] == 'CCONJ':
        return 'connecteur'
    if t[0].lower() in ANAPH:
        return 'anaphore pronominale'
    lp = {x[4] for x in prev['tok'] if x[1] in ('NOUN', 'VERB', 'ADJ', 'PROPN')}
    if any(x[4] in lp for x in cur['tok'][:6] if x[1] in ('NOUN', 'VERB', 'ADJ', 'PROPN')):
        return 'reprise lexicale'
    if t[1] in ('PRON',) and t[0].lower() in PRON_SUJ:
        return 'pronom personnel (même sujet)'
    return 'juxtaposition'


def fin(tok):
    j = len(tok) - 1
    ponct = ''
    while j >= 0 and tok[j][1] in ('PUNCT', 'SPACE', 'SYM'):
        if tok[j][0] in '.!?…:;' or tok[j][0] == '...':
            ponct = ponct or tok[j][0]
        j -= 1
    if j < 0:
        return 'vide', ponct
    t = tok[j]
    if t[4] == 'pas' or t[4] == 'plus' or t[4] == 'jamais' or t[4] == 'rien':
        return 'négation', ponct
    return t[1], ponct


def nb_fin(tok):
    return sum(1 for t in tok if 'VerbForm=Fin' in t[3])


def classe(n):
    return 'C' if n <= 8 else ('M' if n <= 20 else 'L')


INCISE = re.compile(r"[,!?…]\s+(?:s'|se |l'|lui |me |m')?([a-zàâçéèêëîïôûùüÿœ]+?)(?:-t)?-(?:il|elle|je|ils|elles|on|nous|vous)\b")
NEUTRES = re.compile(r'^(?:di[st]|dit|répon\w*|demand\w*|ajout\w*|repri\w*|reprend\w*|fai[st]|fit)$')

agg = collections.defaultdict(lambda: collections.defaultdict(collections.Counter))
num = collections.defaultdict(lambda: collections.defaultdict(list))
for d in docs:
    grp = ('IA' if d['y'] else 'H') + ':' + d['genre']
    src = d['source']
    narr = [p for p in d['phrases'] if not p['dial']]
    mots = sum(p['mots'] for p in d['phrases']) or 1
    for k, p in enumerate(narr):
        agg[grp]['ouverture'][ouverture(p['tok'])] += 1
        if k:
            agg[grp]['lien'][lien(narr[k - 1], p)] += 1
        f, pc = fin(p['tok'])
        agg[grp]['fin_mot'][f] += 1
        agg[grp]['fin_ponct'][pc or 'aucune'] += 1
        nf = nb_fin(p['tok'])
        agg[grp]['verbes_finis'][str(min(nf, 4))] += 1
    # rythme : transitions de classes de longueur (narration)
    cl = [classe(p['mots']) for p in narr]
    for a, b in zip(cl, cl[1:]):
        agg[grp]['transition'][a + '→' + b] += 1
    L = [p['mots'] for p in narr]
    if len(L) > 5:
        mu = st.mean(L)
        num[grp]['autocorr'].append(sum((x - mu) * (y - mu) for x, y in zip(L, L[1:])) / max(1e-9, sum((x - mu) ** 2 for x in L)))
        num[grp]['cv'].append(st.pstdev(L) / mu)
        runs = [len(list(g)) for _, g in __import__('itertools').groupby(cl)]
        num[grp]['plus_longue_serie'].append(max(runs))
    # émotion
    lem = [t[4] for p in d['phrases'] for t in p['tok']]
    num[grp]['emo_nom_1000'].append(1000 * sum(1 for x in lem if x in EMO) / mots)
    num[grp]['corps_1000'].append(1000 * sum(1 for x in lem if x in CORPS) / mots)
    texte = ' '.join(p['t'] for p in d['phrases']).lower()
    num[grp]['se_sentir_1000'].append(1000 * len(re.findall(r"\b(?:me|te|se|nous|vous|s')\s?sen[st]\w*\b", texte)) / mots)
    num[grp]['comme_si_1000'].append(1000 * texte.count('comme si') / mots)
    num[grp]['vague_de_1000'].append(1000 * len(re.findall(r"\b(?:vague|bouffée|élan|pointe|onde) d[e']", texte)) / mots)
    # dialogue et alternance (fiction)
    paras = collections.OrderedDict()
    for p in d['phrases']:
        paras.setdefault(p['para'], p['dial'])
    seq = list(paras.values())
    if any(seq):
        alt = sum(1 for a, b in zip(seq, seq[1:]) if a != b)
        num[grp]['alternances_1000'].append(1000 * alt / mots)
        blocs_n = [len(list(g)) for v, g in __import__('itertools').groupby(seq) if not v]
        blocs_d = [len(list(g)) for v, g in __import__('itertools').groupby(seq) if v]
        num[grp]['bloc_narration_paras'].append(st.mean(blocs_n) if blocs_n else 0)
        num[grp]['bloc_dialogue_repliques'].append(st.mean(blocs_d))
        rep = [p['mots'] for p in d['phrases'] if p['dial']]
        num[grp]['mots_par_replique_phrase'].append(st.mean(rep))
        inc = [m.group(1) for p in d['phrases'] if p['dial'] for m in INCISE.finditer(p['t'])]
        if inc:
            num[grp]['incises_neutres_pct'].append(100 * sum(1 for v in inc if NEUTRES.match(v)) / len(inc))
        num[grp]['part_dialogue_pct'].append(100 * sum(1 for v in seq if v) / len(seq))

out = {'agg': {g: {k: dict(c) for k, c in v.items()} for g, v in agg.items()},
       'num': {g: {k: v for k, v in n.items()} for g, n in num.items()}}
json.dump(out, open('ml/decisions.json', 'w'), ensure_ascii=False)

genres = ['fiction', 'pratique', 'explicatif']
print('# Points de décision : humain (H) vs IA\n')
for cle, titre in [('ouverture', 'Comment la phrase commence (narration)'), ('lien', 'Comment la phrase se relie à la précédente'),
                   ('fin_mot', 'Sur quoi la phrase se termine (dernier mot)'), ('fin_ponct', 'Ponctuation finale'),
                   ('verbes_finis', 'Verbes conjugués par phrase (densité de propositions)'), ('transition', 'Transitions de longueur C≤8 / M 9-20 / L≥21')]:
    print(f'\n## {titre}\n')
    cats = collections.Counter()
    for g in agg:
        cats.update(agg[g][cle])
    hdr = '| catégorie | ' + ' | '.join(f'H {g} | IA {g}' for g in genres) + ' |'
    print(hdr); print('|' + '---|' * (1 + 2 * len(genres)))
    for c, _ in cats.most_common(14):
        row = []
        for g in genres:
            for y in ('H', 'IA'):
                tot = sum(agg[f'{y}:{g}'][cle].values()) or 1
                row.append(f'{100 * agg[f"{y}:{g}"][cle][c] / tot:.1f}')
        print(f'| {c} | ' + ' | '.join(row) + ' |')
print('\n## Mesures continues (médianes par texte)\n')
keys = sorted({k for g in num for k in num[g]})
print('| mesure | ' + ' | '.join(f'H {g} | IA {g}' for g in genres) + ' |'); print('|' + '---|' * (1 + 2 * len(genres)))
for k in keys:
    row = []
    for g in genres:
        for y in ('H', 'IA'):
            v = num[f'{y}:{g}'].get(k, [])
            row.append(f'{st.median(v):.2f}' if v else '-')
    print(f'| {k} | ' + ' | '.join(row) + ' |')
