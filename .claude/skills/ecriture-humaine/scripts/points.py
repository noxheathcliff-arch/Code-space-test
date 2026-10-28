"""Système de points : chaque mot, chaque construction et chaque ponctuation reçoit des points IA (+) ou humains (−).

Le modèle (references/modele_points.json) est une régression logistique entraînée sur des fenêtres d'environ 45 mots
(livres humains contre textes Claude des mêmes genres ; voir entrainer_modele.py et donnees-calibration.md).

Usage :
  python3 points.py texte.md                    carte du texte : indice d'humanité, passages et phrases les plus « IA », mots et constructions qui coûtent
  python3 points.py texte.md --phrases 15       nombre de phrases détaillées
  python3 points.py --variantes variantes.md    classe des variantes d'une même phrase ou d'un même passage (séparées par des lignes « --- »)
  python3 points.py --mot lemme [lemme…]        points d'un mot (lemme)
  options : --json

Lecture des points : +1,0 = ce choix rapproche nettement le passage d'un texte IA ; −1,0 = d'un texte humain.
Les points d'un mot dépendent de sa fréquence : un mot très courant pèse peu par occurrence."""
import argparse, json, math, os, re, sys
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import stylo

FONCTION = {'DET', 'ADP', 'PRON', 'CCONJ', 'SCONJ', 'AUX'}
OUTILS = {'que', 'qui', 'comme', 'si', 'ne', 'pas', 'mais', 'et', 'ou', 'en', 'de', 'à', 'pour', 'plus', 'tout', 'ce',
          "c'", 'est', 'se', 'on', 'nous', 'vous', 'je', 'il', 'elle', 'lorsque', 'quand', 'dont', 'où', 'car', 'donc',
          'puis', 'alors', 'ainsi', 'afin', 'tandis', 'bien', 'déjà', 'encore', 'jamais', 'rien', 'presque'}
PONCT_GARDEES = {',', '.', ':', ';', '!', '?', '…', '«', '»', '(', ')', '—', '-'}
ECHELLE = 50.0  # les comptes sont ramenés à 50 mots


def etiquette(t):
    texte, pos = t[0], t[1]
    bas = texte.lower()
    if pos == 'PUNCT' or pos == 'SYM':
        return texte if texte in PONCT_GARDEES else 'PUNCT'
    if bas in OUTILS:
        return bas
    return pos


def traits_phrase(p, mq):
    """Traits d'une phrase : dictionnaire trait → compte."""
    f = {}

    def add(k, v=1.0):
        f[k] = f.get(k, 0.0) + v
    toks = p.tokens or []
    tags = ['<s>'] + [etiquette(t) for t in toks] + ['</s>']
    for i in range(len(tags) - 2):
        add('G:' + ' '.join(tags[i:i + 3]))
    for t in toks:
        pos, lem = t[1], t[3] if len(t) > 3 else t[0].lower()
        if pos in ('PROPN', 'PUNCT', 'SPACE', 'NUM', 'X', 'SYM'):
            continue
        if not re.match(r"^[a-zàâçéèêëîïôûùüÿœæ'-]+$", lem):
            continue
        add(('F:' if pos in FONCTION else 'L:') + lem)
    if p.mots <= 5:
        add('S:courte')
    elif p.mots >= 30:
        add('S:longue')
    if p.dialogue:
        add('S:dialogue')
    bas = p.texte.lower()
    for cat in ('accessoires', 'formules', 'contrastes', 'ressources_humaines'):
        n = sum(len(r.findall(bas)) for r in mq[cat])
        if n:
            add('C:' + cat, n)
    return f


def fenetres(phrases, min_mots=45):
    """Regroupe les phrases consécutives en fenêtres d'au moins `min_mots` mots (≈ 3 phrases narratives)."""
    out, bloc, n = [], [], 0
    for i, p in enumerate(phrases):
        bloc.append(i); n += p.mots
        if n >= min_mots:
            out.append(bloc); bloc, n = [], 0
    if bloc:
        if out and n < min_mots / 2:
            out[-1] += bloc
        else:
            out.append(bloc)
    return out


def vecteur(idx, phrases, traits):
    mots = max(1, sum(phrases[i].mots for i in idx))
    v = {}
    for i in idx:
        for k, c in traits[i].items():
            v[k] = v.get(k, 0.0) + c
    return {k: c * ECHELLE / mots for k, c in v.items()}, mots


def charger_modele(chemin=None):
    return json.load(open(chemin or os.path.join(stylo.REF, 'modele_points.json')))


def solde(v, mod):
    """Solde de points (logit) : > 0 penche IA, < 0 penche humain."""
    return mod['intercept'] + sum(mod['poids'].get(k, 0.0) * c for k, c in v.items())


def proba(v, mod):
    z = max(-30.0, min(30.0, solde(v, mod)))
    return 1 / (1 + math.exp(-z))


def contributions(idx, phrases, traits, mod):
    """Points par trait pour un groupe de phrases (poids × compte ramené à 50 mots)."""
    v, mots = vecteur(idx, phrases, traits)
    return {k: mod['poids'][k] * c for k, c in v.items() if k in mod['poids']}


def analyser_texte(texte, nlp, mq, mod):
    phrases, paras = stylo.segmenter(texte, nlp)
    traits = [traits_phrase(p, mq) for p in phrases]
    fen = fenetres(phrases)
    res_fen = []
    for idx in fen:
        v, mots = vecteur(idx, phrases, traits)
        res_fen.append((idx, proba(v, mod), mots))
    # score par phrase : proba de la phrase seule (indicatif, bruité pour les phrases courtes)
    res_ph = []
    for i, p in enumerate(phrases):
        v, mots = vecteur([i], phrases, traits)
        res_ph.append((i, proba(v, mod), contributions([i], phrases, traits, mod)))
    total_mots = sum(m for _, _, m in res_fen) or 1
    p_moy = sum(pr * m for _, pr, m in res_fen) / total_mots
    return phrases, traits, res_fen, res_ph, p_moy


def libelle(k):
    t, _, x = k.partition(':')
    return {'G': 'construction', 'F': 'mot-outil', 'L': 'mot', 'S': 'forme', 'C': 'marqueur'}.get(t, t) + ' « ' + x + ' »'


def humanite(p):
    return round(100 * (1 - p))


def rapport(texte, nlp, mq, mod, nb_phrases=12):
    phrases, traits, res_fen, res_ph, p_moy = analyser_texte(texte, nlp, mq, mod)
    cal = mod.get('calibration', {})
    L = [f'# Points — indice d\'humanité : {humanite(p_moy)}/100']
    if cal:
        L.append(f'Repères (textes de ~900 mots) : humains tenus à l\'écart, médiane {cal["humain_p50"]} '
                 f'(p10 {cal["humain_p10"]}) ; Claude brut, médiane {cal["ia_p50"]} (p90 {cal["ia_p90"]}).')
    L.append('Indice = 100 × (1 − probabilité IA moyenne des fenêtres de 3 phrases), selon le modèle de points du skill. '
             'Ce n\'est PAS un score Pangram.')
    seuil = mod.get('seuil_fenetre', 0.5)
    chaudes = [r for r in res_fen if r[1] >= seuil]
    L.append(f'\n## Passages (fenêtres de 3 phrases) au-dessus du seuil IA ({seuil:.2f}) : {len(chaudes)}/{len(res_fen)}\n')
    for idx, pr, m in sorted(chaudes, key=lambda r: -r[1])[:8]:
        debut = phrases[idx[0]].texte[:110]
        L.append(f'- §{phrases[idx[0]].para + 1} (humanité {humanite(pr)}) « {debut}… »')
    # mots et constructions qui coûtent le plus sur l'ensemble du texte
    tout = list(range(len(phrases)))
    contrib = contributions(tout, phrases, traits, mod)
    pos = sorted(((c, k) for k, c in contrib.items() if c > 0), reverse=True)[:15]
    neg = sorted(((c, k) for k, c in contrib.items() if c < 0))[:10]
    L.append('\n## Choix qui coûtent le plus (points IA cumulés sur le texte)\n')
    L += [f'- +{c:.2f}  {libelle(k)}' for c, k in pos] or ['- aucun']
    L.append('\n## Choix qui rapportent le plus (points humains)\n')
    L += [f'- {c:.2f}  {libelle(k)}' for c, k in neg] or ['- aucun']
    L.append(f'\n## Les {nb_phrases} phrases les plus « IA » (hors répliques très courtes)\n')
    cand = [r for r in res_ph if phrases[r[0]].mots >= 6]
    for i, pr, ct in sorted(cand, key=lambda r: -r[1])[:nb_phrases]:
        top = sorted(ct.items(), key=lambda x: -x[1])[:3]
        det = ', '.join(f'{libelle(k)} +{c:.2f}' for k, c in top if c > 0)
        L.append(f'- [{humanite(pr)}] « {phrases[i].texte[:160]} »\n    ↳ {det}')
    return '\n'.join(L), p_moy


def classer_variantes(blocs, nlp, mq, mod):
    res = []
    for b in blocs:
        phrases, traits, res_fen, res_ph, p_moy = analyser_texte(b, nlp, mq, mod)
        idx = list(range(len(phrases)))
        v, mots = vecteur(idx, phrases, traits) if phrases else ({}, 1)
        z = solde(v, mod) if phrases else 99.0
        ct = contributions(idx, phrases, traits, mod) if phrases else {}
        res.append((z, b, ct))
    return res


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('fichier', nargs='?')
    ap.add_argument('--variantes')
    ap.add_argument('--mot', nargs='+')
    ap.add_argument('--phrases', type=int, default=12)
    ap.add_argument('--json', action='store_true')
    ap.add_argument('--modele', help='autre fichier de modèle (par défaut references/modele_points.json)')
    a = ap.parse_args()
    mod = charger_modele(a.modele)
    if a.mot:
        for m in a.mot:
            for pre in ('L:', 'F:'):
                if pre + m in mod['poids']:
                    print(f'{m} : {mod["poids"][pre + m]:+.2f} point(s) par occurrence ramenée à 50 mots '
                          f'({"IA" if mod["poids"][pre + m] > 0 else "humain"})')
                    break
            else:
                print(f'{m} : neutre (absent du modèle : trop rare, ou incohérent d\'un genre à l\'autre)')
        return
    nlp = stylo.charger_nlp()
    if nlp is None:
        sys.exit('points.py nécessite spaCy (pip install spacy ; python -m spacy download fr_core_news_md).')
    mq = stylo.charger_marqueurs()
    if a.variantes:
        blocs = [b.strip() for b in re.split(r'\n\s*---+\s*\n', open(a.variantes, encoding='utf-8').read()) if b.strip()]
        res = classer_variantes(blocs, nlp, mq, mod)
        print('# Classement des variantes (de la plus humaine à la plus IA)\n')
        for rang, (z, b, ct) in enumerate(sorted(res, key=lambda r: r[0]), 1):
            top = sorted(ct.items(), key=lambda x: -x[1])[:3]
            bas = sorted(ct.items(), key=lambda x: x[1])[:2]
            pr = 1 / (1 + math.exp(-max(-30, min(30, z))))
            print(f'{rang}. solde {z:+.1f} points (humanité {humanite(pr)}) — « {b[:200]}{"…" if len(b) > 200 else ""} »')
            print('   coûte : ' + (', '.join(f'{libelle(k)} +{c:.2f}' for k, c in top if c > 0) or '—')
                  + ' | rapporte : ' + (', '.join(f'{libelle(k)} {c:.2f}' for k, c in bas if c < 0) or '—'))
        print('\nSolde : somme des points ramenée à 50 mots (négatif = humain). Sur une phrase seule, l\'humanité sature vite ; comparer les soldes.')
        print('Rappel : la variante retenue est la mieux notée PARMI celles qui gardent le sens, la voix et la clarté.')
        return
    if not a.fichier:
        ap.error('fichier, --variantes ou --mot requis')
    texte = open(a.fichier, encoding='utf-8').read()
    out, p = rapport(texte, nlp, mq, mod, a.phrases)
    if a.json:
        print(json.dumps({'humanite': humanite(p), 'proba_ia': p}, ensure_ascii=False))
    else:
        print(out)


if __name__ == '__main__':
    main()
