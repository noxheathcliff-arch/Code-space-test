"""Analyse de la fabrication de l'émotion et des scènes (fiction) : humain vs IA, à partir des caches.
Usage : python emotion.py ml/humain.pkl ml/ia1.pkl ml/ia2.pkl"""
import sys, pickle, collections, statistics as st, re, json
import numpy as np
sys.path.insert(0, '/home/user/Code-space-test/.claude/skills/ecriture-humaine/scripts')
import points

docs = [d for f in sys.argv[1:] for d in pickle.load(open(f, 'rb')) if d['genre'] == 'fiction']
MENTAL = set('penser savoir croire demander comprendre imaginer souvenir rappeler ignorer deviner espérer vouloir sembler paraître oublier douter réaliser'.split())
SENS = {'vue': set('voir regarder lumière ombre couleur briller sombre rouge noir blanc gris éclat reflet'.split()),
        'ouïe': set('entendre bruit son silence voix cri murmure grincement craquement écho écouter résonner'.split()),
        'odorat': set('odeur parfum sentir puanteur relent effluve fumée'.split()),
        'toucher': set('froid chaud glacé brûlant rugueux doux humide sec toucher caresser frôler poids'.split()),
        'goût': set('goût saveur amer sucré salé fade bile'.split())}


def stats(d):
    ph = d['phrases']
    mots = sum(p['mots'] for p in ph) or 1
    narr = [p for p in ph if not p['dial']]
    r = {}
    q = sum(1 for p in narr if p['t'].rstrip().endswith('?'))
    e = sum(1 for p in narr if p['t'].rstrip().endswith('!'))
    s = sum(1 for p in narr if p['t'].rstrip().endswith('…') or p['t'].rstrip().endswith('...'))
    r['narr_questions_1000'] = 1000 * q / mots
    r['narr_exclam_1000'] = 1000 * e / mots
    r['narr_susp_1000'] = 1000 * s / mots
    lem = [(t[4], t[1]) for p in ph for t in p['tok']]
    r['verbes_mentaux_1000'] = 1000 * sum(1 for l, pos in lem if l in MENTAL and pos == 'VERB') / mots
    for k, v in SENS.items():
        r['sens_' + k + '_1000'] = 1000 * sum(1 for l, _ in lem if l in v) / mots
    r['sens_differents'] = sum(1 for k in SENS if r['sens_' + k + '_1000'] > 0.5)
    r['noms_propres_1000'] = 1000 * sum(1 for _, pos in lem if pos == 'PROPN') / mots
    # co-occurrence émotion nommée + corps dans la même phrase
    co = sum(1 for p in ph if any(t[4] in points.EMO for t in p['tok']) and any(t[4] in points.CORPS for t in p['tok']))
    nomme = sum(1 for p in ph if any(t[4] in points.EMO for t in p['tok']))
    r['emotion_nommee_1000'] = 1000 * nomme / mots
    r['emotion_avec_corps_pct'] = 100 * co / nomme if nomme else None
    corps = sum(1 for p in ph if any(t[4] in points.CORPS for t in p['tok']))
    r['phrases_corps_1000'] = 1000 * corps / mots
    return r


def trajectoires(d, avant=6, apres=3):
    """Intensité émotionnelle par fenêtre de 3 phrases ; moyenne des traits avant/après les pics."""
    ph = d['phrases']
    if len(ph) < 30:
        return []
    W = [ph[i:i + 3] for i in range(0, len(ph) - 2, 3)]

    def inten(w):
        m = sum(p['mots'] for p in w) or 1
        x = sum(1 for p in w for t in p['tok'] if t[4] in points.EMO or t[4] in points.CORPS)
        x += sum(1 for p in w if p['t'].rstrip()[-1:] in '!?…')
        return x / m * 50

    def traits(w):
        m = sum(p['mots'] for p in w) or 1
        return [st.mean(p['mots'] for p in w), sum(1 for p in w if p['dial']) / len(w), sum(1 for p in w if p['mots'] <= 8) / len(w)]
    I = [inten(w) for w in W]
    seuil = np.percentile(I, 95)
    out = []
    for k, v in enumerate(I):
        if v >= seuil and k >= avant and k + apres < len(W) and v > 0:
            out.append([traits(W[j]) for j in range(k - avant, k + apres + 1)])
    return out


agg = collections.defaultdict(lambda: collections.defaultdict(list))
traj = collections.defaultdict(list)
for d in docs:
    g = 'IA' if d['y'] else 'H:' + d['source']
    G = 'IA' if d['y'] else 'H'
    for k, v in stats(d).items():
        if v is not None:
            agg[g][k].append(v); agg['TOUS_' + G][k].append(v)
    traj[G] += trajectoires(d)

cles = list(agg['TOUS_H'].keys())
print('# Fabrication de l\'émotion et des scènes (fiction), médianes par extrait de ~900 mots\n')
grp = ['TOUS_H', 'TOUS_IA', 'H:guerrieri', 'H:tronedefer', 'H:witcher', 'H:fargetton']
print('| mesure | ' + ' | '.join(grp) + ' |'); print('|' + '---|' * (len(grp) + 1))
for k in cles:
    print(f'| {k} | ' + ' | '.join(f'{st.median(agg[g][k]):.2f}' if agg[g][k] else '-' for g in grp) + ' |')
print('\n## Trajectoire autour des pics émotionnels (fenêtres de 3 phrases ; 0 = pic)\n')
print('Colonnes : longueur moyenne des phrases / part de répliques / part de phrases ≤ 8 mots\n')
for G in ('H', 'IA'):
    if not traj[G]:
        continue
    a = np.array(traj[G])  # n × 10 × 3
    m = a.mean(axis=0)
    print(f'**{G}** (n = {len(a)} pics)\n')
    print('| position | ' + ' | '.join(str(i) for i in range(-6, 4)) + ' |'); print('|' + '---|' * 11)
    for j, nom in enumerate(['longueur', 'répliques', 'courtes']):
        print(f'| {nom} | ' + ' | '.join(f'{m[i, j]:.2f}' for i in range(10)) + ' |')
    print()
json.dump({g: {k: float(st.median(v)) for k, v in agg[g].items() if v} for g in agg}, open('ml/emotion.json', 'w'), ensure_ascii=False)
