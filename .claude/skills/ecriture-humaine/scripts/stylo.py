"""Module d'analyse stylométrique du français, partagé par diagnostic.py et construire_profil.py.

Fonctionne avec spaCy (fr_core_news_md ou fr_core_news_sm) pour l'analyse complète ;
sans spaCy, seules les mesures de ponctuation, de phrase et de lexique sont calculées."""
import json, os, re, statistics as st

ICI = os.path.dirname(os.path.abspath(__file__))
REF = os.path.join(os.path.dirname(ICI), 'references')

DIAL = re.compile(r'^\s*(?:[—–]|-\s|«)')
MOT = re.compile(r"[A-Za-zÀ-ÖØ-öø-ÿœŒæÆ]+(?:[-'][A-Za-zÀ-ÖØ-öø-ÿœŒæÆ]+)*")
PRONOMS_SUJET = {'je', 'j', 'tu', 'il', 'elle', 'on', 'nous', 'vous', 'ils', 'elles'}
# incise de dialogue : « …, dit-il », « …, répond Marie », « … ! s'exclame-t-elle »
INCISE = re.compile(r"[,!?…]\s+(?:s'|se |l'|lui |me |m')?([a-zàâçéèêëîïôûùüÿœ]+?)(?:-t)?-(?:il|elle|je|ils|elles|on|nous|vous)\b"
                    r"|[,!?…]\s+([a-zàâçéèêëîïôûùüÿœ]+(?:a|it|ut|e|ent|ait|aient))\s+[A-ZÀ-Þ][a-zà-ÿ]+\b")
NEUTRES = re.compile(r"^(?:di[st]|dit|disai\w*|dis|répon\w*|demand\w*|ajout\w*|repri\w*|reprend\w*|fai[st]|fit)$")

_nlp = None


def charger_nlp():
    """Renvoie un pipeline spaCy français, ou None si spaCy n'est pas installé."""
    global _nlp
    if _nlp is not None:
        return _nlp or None
    try:
        import spacy
        for m in ('fr_core_news_md', 'fr_core_news_sm', 'fr_core_news_lg'):
            try:
                _nlp = spacy.load(m, disable=['ner'])
                _nlp.max_length = 3_000_000
                return _nlp
            except OSError:
                continue
    except ImportError:
        pass
    _nlp = False
    return None


def charger_marqueurs():
    m = json.load(open(os.path.join(REF, 'marqueurs.json')))
    comp = {}
    for cat in ('accessoires', 'formules', 'mots_surveilles', 'contrastes', 'ressources_humaines'):
        comp[cat] = [re.compile(p, re.I) for p in m[cat]['motifs']]
    return comp


def normaliser(t):
    t = t.replace('’', "'").replace(' ', ' ').replace('\xa0', ' ')
    t = re.sub(r'\.\.\.', '…', t)
    return t


def paragraphes(texte):
    lignes = [l.strip() for l in re.split(r'\n', normaliser(texte))]
    out = []
    for l in lignes:
        if not l or l.startswith('#') or re.fullmatch(r'[*\-_=~• ]{3,}', l):
            continue
        out.append(l)
    return out


def _decouper_regex(p):
    morceaux = re.split(r'(?<=[.!?…])\s+(?=[«—–\-"A-ZÀ-ÖØ-Þ0-9])', p)
    return [m.strip() for m in morceaux if MOT.search(m)]


class Phrase:
    __slots__ = ('texte', 'para', 'rang', 'dialogue', 'mots', 'tokens', 'premier')

    def __init__(self, texte, para, rang, dialogue, tokens=None):
        self.texte = texte
        self.para = para
        self.rang = rang
        self.dialogue = dialogue
        self.tokens = tokens  # liste de (texte, pos, morph, lemme) si spaCy
        mots = MOT.findall(texte)
        self.mots = len(mots)
        self.premier = mots[0].lower() if mots else ''
        if self.premier.startswith("j'") or self.premier == 'j':
            self.premier = 'je'


def segmenter(texte, nlp=None):
    """Découpe en phrases (par règles : ponctuation forte suivie d'une majuscule, d'un tiret ou d'un guillemet),
    en conservant les paragraphes ; spaCy ne sert qu'à l'étiquetage. Renvoie (phrases, paragraphes)."""
    paras = paragraphes(texte)
    brut = []
    for i, p in enumerate(paras):
        dial = bool(DIAL.match(p))
        for j, s in enumerate(_decouper_regex(p)):
            brut.append((s, i, j, dial))
    if nlp is None:
        return [Phrase(s, i, j, d) for s, i, j, d in brut], paras
    phrases = []
    for (s, i, j, d), doc in zip(brut, nlp.pipe([b[0] for b in brut], batch_size=128)):
        toks = [(t.text, t.pos_, str(t.morph), t.lemma_.lower()) for t in doc if not t.is_space]
        phrases.append(Phrase(s, i, j, d, toks))
    return phrases, paras


VERBE_PRONOM = re.compile(r"\w+-(?:t-)?(?:la|le|les|lui|leur|y|en|moi|toi|nous|vous|il|elle|ils|elles|on|je|tu|ce)\b", re.I)


def est_fragment(p):
    """Phrase narrative très courte sans verbe (« Rien. », « Le silence. »)."""
    if p.mots > 5 or p.tokens is None:
        return False
    if VERBE_PRONOM.search(p.texte):
        return False
    if any(w.lower() in PRONOMS_SUJET for w in MOT.findall(p.texte)):
        return False
    return not any(t[1] in ('VERB', 'AUX') for t in p.tokens)


def _pk(x, n):
    return round(1000.0 * x / max(1, n), 3)


def _diversite_ouvertures(premiers, bloc=40):
    if len(premiers) < 8:
        return None
    vals = []
    for i in range(0, max(1, len(premiers) - bloc + 1), bloc):
        b = premiers[i:i + bloc]
        if len(b) >= 20:
            vals.append(len(set(b)) / len(b))
    if not vals:
        vals = [len(set(premiers)) / len(premiers)]
    return round(st.mean(vals), 4)


def mesurer(texte, nlp=None, marqueurs=None):
    """Calcule les mesures globales d'un texte. Renvoie (mesures, phrases, paragraphes)."""
    marqueurs = marqueurs or charger_marqueurs()
    phrases, paras = segmenter(texte, nlp)
    corps = '\n'.join(paras)
    bas = corps.lower()
    nmots = len(MOT.findall(corps))
    narr = [p for p in phrases if not p.dialogue]
    longueurs = [p.mots for p in narr] or [p.mots for p in phrases]
    m = {'mots': nmots, 'phrases': len(phrases)}
    m['virgules_1000'] = _pk(corps.count(','), nmots)
    m['virgules_phrase'] = round(corps.count(',') / max(1, len(phrases)), 3)
    m['virgule_et_1000'] = _pk(len(re.findall(r',\s+et\b', corps)), nmots)
    m['deux_points_1000'] = _pk(len(re.findall(r'\w\s?:\s', corps)), nmots)
    m['guillemets_1000'] = _pk(sum(1 for p in paras if not DIAL.match(p) for _ in re.finditer('«', p)), nmots)
    m['suspension_1000'] = _pk(corps.count('…'), nmots)
    m['exclamation_1000'] = _pk(corps.count('!'), nmots)
    m['parentheses_1000'] = _pk(corps.count('('), nmots)
    m['on_1000'] = _pk(len(re.findall(r"\bon\b", bas)), nmots)
    m['nous_1000'] = _pk(len(re.findall(r"\bnous\b", bas)), nmots)
    m['phr_moy'] = round(st.mean(longueurs), 3) if longueurs else 0
    m['phr_ecart'] = round(st.pstdev(longueurs), 3) if len(longueurs) > 1 else 0
    m['phr_longues_pct'] = round(100 * sum(1 for x in longueurs if x >= 30) / max(1, len(longueurs)), 2)
    m['phr_courtes_pct'] = round(100 * sum(1 for x in longueurs if x <= 5) / max(1, len(longueurs)), 2)
    premiers = [p.premier for p in narr]
    m['ouv_diversite'] = _diversite_ouvertures(premiers)
    m['ouv_repetee_pct'] = round(100 * sum(1 for a, b in zip(premiers, premiers[1:]) if a == b) / max(1, len(premiers) - 1), 2)
    m['ouv_pronom_pct'] = round(100 * sum(1 for x in premiers if x in PRONOMS_SUJET) / max(1, len(premiers)), 2)
    # paragraphes ouvrant sur une phrase courte (≤ 8 mots, la plus courte du paragraphe)
    par_para = {}
    for p in narr:
        par_para.setdefault(p.para, []).append(p.mots)
    elig = [v for v in par_para.values() if len(v) >= 3]
    m['para_ouvre_courte_pct'] = round(100 * sum(1 for v in elig if v[0] <= 8 and v[0] == min(v)) / max(1, len(elig)), 2)
    m['para_chute_courte_pct'] = round(100 * sum(1 for v in elig if v[-1] <= 8 and v[-1] == min(v)) / max(1, len(elig)), 2)
    for cat in ('accessoires', 'formules', 'contrastes', 'ressources_humaines'):
        n = sum(len(r.findall(bas)) for r in marqueurs[cat])
        if cat == 'formules':
            n += sum(len(r.findall(bas)) for r in marqueurs['mots_surveilles'])
        m[cat + '_1000'] = _pk(n, nmots)
    # incises de dialogue : part des verbes neutres (dire, répondre, demander)
    incises = [a or b for a, b in INCISE.findall(corps)]
    if len(incises) >= 3:
        neutres = sum(1 for v in incises if NEUTRES.match(v.lower()))
        m['incises_neutres_pct'] = round(100 * neutres / len(incises), 2)
    else:
        m['incises_neutres_pct'] = None
    if nlp is not None:
        toks = [t for p in phrases for t in p.tokens]
        pos = [t[1] for t in toks if t[1] not in ('PUNCT', 'SPACE')]
        npos = max(1, len(pos))
        m['adj_par_nom'] = round(pos.count('ADJ') / max(1, pos.count('NOUN')), 4)
        m['prepositions_pct'] = round(100 * pos.count('ADP') / npos, 3)
        m['coordination_pct'] = round(100 * pos.count('CCONJ') / npos, 3)
        m['subordination_phrase'] = round(pos.count('SCONJ') / max(1, len(phrases)), 4)
        m['part_present_1000'] = _pk(sum(1 for t in toks if 'VerbForm=Part' in t[2] and 'Tense=Pres' in t[2]), nmots)
        m['adv_ment_1000'] = _pk(sum(1 for t in toks if t[1] == 'ADV' and t[0].lower().endswith('ment')), nmots)
        m['fragments_1000'] = _pk(sum(1 for p in narr if est_fragment(p)), nmots)
    return m, phrases, paras


# ---------------------------------------------------------------- signalements par phrase

def signaler(phrases, marqueurs=None, nlp_dispo=False, genre='fiction'):
    """Renvoie une liste de (index_phrase, code, détail) pour les phrases à examiner."""
    marqueurs = marqueurs or charger_marqueurs()
    out = []
    narr_idx = [i for i, p in enumerate(phrases) if not p.dialogue]
    for k, i in enumerate(narr_idx):
        p = phrases[i]
        t = p.texte
        bas = t.lower()
        nv = t.count(',')
        if re.search(r',\s+et\b', t):
            out.append((i, 'V1', 'virgule avant « et »'))
        if nv >= 4 or (nv >= 3 and p.mots <= 22):
            out.append((i, 'V2', f'{nv} virgules : phrase hachée'))
        dp = re.search(r"^(.*?\w)\s?:\s+\S", t)
        if dp and not re.search(r':\s*$', t):
            avant = len(MOT.findall(dp.group(1)))
            if genre == 'fiction' or avant <= 4:
                out.append((i, 'P1', 'deux-points d\'étiquette (« Résultat : »)' if avant <= 4 else 'deux-points de révélation en narration'))
        if p.mots <= 5:
            prec = phrases[narr_idx[k - 1]] if k > 0 else None
            if p.rang == 0 and not prec is None:
                out.append((i, 'C1', 'paragraphe ouvert par une phrase très courte'))
            elif prec is not None and prec.mots <= 5 and prec.para == p.para:
                out.append((i, 'C2', 'deux phrases très courtes à la suite'))
        if k > 0:
            prec = phrases[narr_idx[k - 1]]
            if p.premier and p.premier == prec.premier:
                out.append((i, 'O1', f'même premier mot que la phrase précédente (« {p.premier} »)'))
        if k > 1:
            a, b = phrases[narr_idx[k - 2]], phrases[narr_idx[k - 1]]
            if all(x.premier in PRONOMS_SUJET for x in (a, b, p)):
                out.append((i, 'O2', 'troisième phrase de suite ouverte par un pronom sujet'))
        if genre != 'fiction' and re.search(r'\bon\b', bas):
            out.append((i, 'L3', '« on » générique'))
        for cat, code in (('accessoires', 'L2'), ('formules', 'L1'), ('contrastes', 'S1')):
            trouves = [r.search(bas).group(0) for r in marqueurs[cat] if r.search(bas)]
            if cat == 'accessoires':
                trouves = [x for x in trouves if x.strip() != 'deux']  # « deux » seul : trop courant pour un signalement
            if trouves:
                out.append((i, code, ', '.join(dict.fromkeys(trouves))))
        if nlp_dispo and est_fragment(p):
            out.append((i, 'S3', 'fragment sans verbe'))
        if genre == 'fiction' and t.rstrip().endswith('!'):
            out.append((i, 'E1', 'exclamation en narration : à justifier par la voix (au plus 1 pour 300 mots hors répliques)'))
    # monotonie : 5 phrases narratives de longueurs trop proches
    lg = [phrases[i].mots for i in narr_idx]
    for k in range(len(lg) - 4):
        f = lg[k:k + 5]
        mu = st.mean(f)
        if mu >= 6 and st.pstdev(f) / mu < 0.22:
            out.append((narr_idx[k + 4], 'R1', f'5 phrases de longueur voisine ({", ".join(map(str, f))} mots)'))
    return out


LIBELLES = {
    'V1': 'Virgule avant « et »', 'V2': 'Phrase hachée de virgules', 'P1': 'Deux-points d\'annonce',
    'C1': 'Ouverture courte', 'C2': 'Rafale de phrases courtes', 'O1': 'Ouverture répétée', 'O2': 'Série de pronoms sujets',
    'L1': 'Formule IA', 'L2': 'Accessoire de fausse concrétude', 'L3': '« On » générique', 'S1': 'Contraste correctif',
    'S3': 'Fragment sans verbe', 'R1': 'Monotonie de longueur', 'E1': 'Exclamation en narration',
}
