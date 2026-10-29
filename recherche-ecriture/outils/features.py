"""Extraction de traits stylométriques (français) pour un ensemble de textes.
Usage : python features.py OUT.jsonl fichier1.txt fichier2.txt ...
Chaque ligne de sortie : {"file":..., "feats":{...}, "lemmas":[...], "posgrams":[...]}"""
import sys, json, re, statistics as st
import spacy

nlp = spacy.load('fr_core_news_md', disable=['ner'])
nlp.max_length = 2_000_000

CONNECTEURS = ['en effet', 'cependant', 'toutefois', 'néanmoins', 'pourtant', 'ainsi', 'de plus', 'en outre',
               'par ailleurs', "d'ailleurs", 'en somme', 'en fin de compte', 'finalement', 'bref', 'donc',
               'alors', 'puis', 'enfin', 'autrement dit', 'en réalité', 'au fond', 'parfois', 'soudain',
               'peu à peu', 'lentement', 'doucement']
NOMINAL_SUFF = re.compile(r'(tion|sion|ment|ité|ance|ence|isme|age|ure)s?$')
DIAL_START = re.compile(r'^\s*[—–-]\s|^\s*«')


def norm(t):
    return t.replace('’', "'").replace(' ', ' ').replace('\xa0', ' ')


def mattr(words, w=100):
    if len(words) < w:
        return len(set(words)) / max(1, len(words))
    vals = [len(set(words[i:i + w])) / w for i in range(0, len(words) - w + 1, 10)]
    return sum(vals) / len(vals)


def per_k(x, n):
    return 1000.0 * x / max(1, n)


def analyse(text):
    text = norm(text)
    paras = [p.strip() for p in re.split(r'\n\s*\n|\n', text) if p.strip() and not p.strip().startswith('#')]
    body = '\n'.join(paras)
    doc = nlp(body)
    words = [t for t in doc if t.is_alpha]
    nw = len(words)
    lw = [t.text.lower() for t in words]
    sents = [s for s in doc.sents if any(t.is_alpha for t in s)]
    slen = [sum(1 for t in s if t.is_alpha) for s in sents]
    f = {}
    f['mots'] = nw
    f['phr_long_moy'] = st.mean(slen) if slen else 0
    f['phr_long_sd'] = st.pstdev(slen) if len(slen) > 1 else 0
    f['phr_cv'] = f['phr_long_sd'] / f['phr_long_moy'] if f['phr_long_moy'] else 0
    f['phr_pct_courtes_le5'] = 100 * sum(1 for x in slen if x <= 5) / max(1, len(slen))
    f['phr_pct_longues_ge30'] = 100 * sum(1 for x in slen if x >= 30) / max(1, len(slen))
    diffs = [abs(a - b) for a, b in zip(slen, slen[1:])]
    f['rythme_delta_rel'] = (st.mean(diffs) / f['phr_long_moy']) if diffs and f['phr_long_moy'] else 0
    # paragraphes
    plen = [len(p.split()) for p in paras]
    f['para_long_moy'] = st.mean(plen) if plen else 0
    f['para_cv'] = (st.pstdev(plen) / f['para_long_moy']) if len(plen) > 1 and f['para_long_moy'] else 0
    f['para_pct_dialogue'] = 100 * sum(1 for p in paras if DIAL_START.match(p)) / max(1, len(paras))
    # ponctuation
    for name, ch in [('virgule', ','), ('pointvirgule', ';'), ('deuxpoints', ':'), ('exclam', '!'), ('interro', '?'),
                     ('parenth', '('), ('guillemet', '«')]:
        f['p_' + name] = per_k(body.count(ch), nw)
    f['p_points_susp'] = per_k(body.count('…') + body.count('...'), nw)
    # tiret incident (pas en début de paragraphe)
    f['p_tiret_incise'] = per_k(len(re.findall(r'\S\s[—–]\s', body)), nw)
    f['virgules_par_phrase'] = body.count(',') / max(1, len(sents))
    # POS
    pos = [t.pos_ for t in doc if not t.is_space]
    npos = max(1, len([p for p in pos if p not in ('PUNCT',)]))
    for p in ['NOUN', 'VERB', 'ADJ', 'ADV', 'PRON', 'ADP', 'CCONJ', 'SCONJ', 'PROPN', 'DET', 'AUX']:
        f['pos_' + p] = 100 * pos.count(p) / npos
    f['adj_par_nom'] = pos.count('ADJ') / max(1, pos.count('NOUN'))
    f['nominalisations'] = per_k(sum(1 for t in doc if t.pos_ == 'NOUN' and NOMINAL_SUFF.search(t.text.lower())), nw)
    f['adv_ment'] = per_k(sum(1 for t in doc if t.pos_ == 'ADV' and t.text.lower().endswith('ment')), nw)
    # participes
    ppres = [t for t in doc if 'Part' in t.morph.get('VerbForm') and 'Pres' in t.morph.get('Tense')]
    f['part_present'] = per_k(len(ppres), nw)
    f['gerondif'] = per_k(sum(1 for t in ppres if t.i > 0 and doc[t.i - 1].lower_ == 'en'), nw)
    f['phr_ouvre_participe'] = 100 * sum(1 for s in sents if 'Part' in s[0].morph.get('VerbForm')) / max(1, len(sents))
    # temps verbaux (verbes finis)
    fin = [t for t in doc if 'Fin' in t.morph.get('VerbForm')]
    nf = max(1, len(fin))
    for tn in ['Pres', 'Imp', 'Past', 'Fut']:
        f['temps_' + tn] = 100 * sum(1 for t in fin if tn in t.morph.get('Tense')) / nf
    f['subjonctif'] = 100 * sum(1 for t in fin if 'Sub' in t.morph.get('Mood')) / nf
    # subordination
    f['sconj_par_phrase'] = pos.count('SCONJ') / max(1, len(sents))
    f['relatifs_par_phrase'] = sum(1 for t in doc if t.lower_ in ('qui', 'que', 'dont', 'où', 'lequel', 'laquelle') and 'Rel' in t.morph.get('PronType')) / max(1, len(sents))
    # personnes
    for p in ['je', 'nous', 'vous', 'on', 'il', 'elle', 'tu']:
        f['pron_' + p] = per_k(sum(1 for t in lw if t == p or t == p + "'"), nw)
    f['pron_je'] += per_k(sum(1 for t in doc if t.lower_ in ("j'", 'j')), nw)
    # motifs syntaxiques
    low = body.lower()
    f['m_pas_x_mais_y'] = per_k(len(re.findall(r"\b(?:ne|n')\s?\w+[^.!?;]{0,60}?\bpas\b[^.!?;]{0,80}?,?\s+mais\b", low)) + len(re.findall(r'\bnon pas\b', low)), nw)
    f['m_ce_nest_pas'] = per_k(len(re.findall(r"\bce n'est pas\b|\bce n'était pas\b|\bil ne s'agit pas\b", low)), nw)
    f['m_non_seulement'] = per_k(low.count('non seulement'), nw)
    f['m_comme_si'] = per_k(low.count('comme si'), nw)
    f['m_comparaison_comme'] = per_k(len(re.findall(r"\bcomme (?:un|une|des|le|la|les|si)\b", low)), nw)
    f['m_tel_que'] = per_k(len(re.findall(r'\btel(?:le)?s? (?:un|une|des)\b', low)), nw)
    f['m_triade'] = per_k(len(re.findall(r"\b[\w'-]+(?: [\w'-]+){0,2}, [\w'-]+(?: [\w'-]+){0,2},? et [\w'-]+", low)), nw)
    f['m_cest_que'] = per_k(len(re.findall(r"\bc'est (?:là |aussi |peut-être |précisément |exactement )?(?:ce qui|ce que|pour cela|pourquoi|que|qui)\b", low)), nw)
    f['m_question_rhet'] = per_k(sum(1 for s in sents if s.text.strip().endswith('?') and not DIAL_START.match(s.text)), nw)
    f['m_deux_points_revel'] = per_k(len(re.findall(r'\w : \w', body)), nw)
    conn_total = 0
    for c in CONNECTEURS:
        n = len(re.findall(r'(?:^|[\s,.;:!?«—])' + re.escape(c) + r'\b', low))
        conn_total += n
    f['connecteurs'] = per_k(conn_total, nw)
    # ouvertures de phrase
    opens = [next((t.lower_ for t in s if t.is_alpha), '') for s in sents]
    f['ouv_meme_que_prec'] = 100 * sum(1 for a, b in zip(opens, opens[1:]) if a == b) / max(1, len(opens) - 1)
    f['ouv_et_mais'] = 100 * sum(1 for o in opens if o in ('et', 'mais')) / max(1, len(opens))
    f['ouv_diversite'] = len(set(opens)) / max(1, len(opens))
    f['mattr100'] = mattr(lw)
    # architecture des paragraphes : chute courte finale
    chute = ouv = elig = 0
    for p in paras:
        if DIAL_START.match(p):
            continue
        ps = [s for s in nlp(p).sents if any(t.is_alpha for t in s)]
        if len(ps) < 3:
            continue
        elig += 1
        ls = [sum(1 for t in s if t.is_alpha) for s in ps]
        if ls[-1] <= 8 and ls[-1] == min(ls):
            chute += 1
        if ls[0] <= 8 and ls[0] == min(ls):
            ouv += 1
    f['para_chute_courte'] = 100 * chute / max(1, elig)
    f['para_ouvre_courte'] = 100 * ouv / max(1, elig)
    f['para_pct_1phrase'] = 100 * sum(1 for p in paras if len(re.findall(r'[.!?…]+(?:\s|$)', p)) <= 1) / max(1, len(paras))
    # fragments sans verbe
    frag = sum(1 for s in sents if sum(1 for t in s if t.is_alpha) <= 6 and not any(t.pos_ in ('VERB', 'AUX') for t in s))
    f['fragments_sans_verbe'] = per_k(frag, nw)
    f['m_a_la_fois'] = per_k(low.count('à la fois'), nw)
    f['m_quelque_chose_de'] = per_k(len(re.findall(r"quelque chose d[e']", low)), nw)
    f['m_chaque'] = per_k(len(re.findall(r'\bchaque\b', low)), nw)
    f['m_comme_pour'] = per_k(low.count('comme pour'), nw)
    f['m_presque'] = per_k(len(re.findall(r'\bpresque\b', low)), nw)
    f['m_dislocation_lui'] = per_k(len(re.findall(r"\w, (?:lui|elle|eux|elles), ", low)), nw)
    f['m_et_pourtant'] = per_k(low.count('et pourtant'), nw)
    f['m_label_deux_points'] = per_k(len(re.findall(r'(?:^|[.!?]\s)(?:Résultat|Conséquence|Autrement dit|Bref|Le problème|La raison|La vérité|Le paradoxe|La clé|Le piège|En clair)\s?:', body)), nw)
    qa = 0
    for s1, s2 in zip(sents, sents[1:]):
        if s1.text.strip().endswith('?') and not DIAL_START.match(s1.text) and not s2.text.strip().endswith('?'):
            qa += 1
    f['m_question_puis_reponse'] = per_k(qa, nw)
    # lexique et gabarits
    lemmas = [t.lemma_.lower() for t in doc if t.is_alpha]
    tags = []
    FUNC = {'que', 'qui', 'comme', 'si', 'ne', 'pas', 'mais', 'et', 'ou', 'en', 'de', 'à', 'pour', 'plus', 'tout', 'ce', 'c\'', 'est', 'se'}
    for t in doc:
        if t.is_space:
            continue
        if t.pos_ == 'PUNCT':
            tags.append(t.text)
        elif t.lower_ in FUNC:
            tags.append(t.lower_)
        else:
            tags.append(t.pos_)
    posgrams = [' '.join(tags[i:i + 4]) for i in range(len(tags) - 3)]
    return f, lemmas, posgrams, opens


def main():
    out = sys.argv[1]
    with open(out, 'w') as fo:
        for path in sys.argv[2:]:
            f, lem, pg, opens = analyse(open(path).read())
            fo.write(json.dumps({'file': path, 'feats': f, 'lemmas': lem, 'posgrams': pg, 'opens': opens}, ensure_ascii=False) + '\n')
    print('ok', len(sys.argv) - 2)


if __name__ == '__main__':
    main()
