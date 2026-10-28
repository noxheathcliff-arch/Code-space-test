"""Diagnostic stylométrique d'un texte français par rapport aux profils humains de référence.

Usage :
  python3 diagnostic.py texte.txt --genre fiction|pratique|explicatif|essai
  python3 diagnostic.py texte.txt --genre fiction --avant brouillon.txt     (compare deux versions)
  python3 diagnostic.py --dossier chapitres/ --genre fiction                (long format : par chapitre + tics transversaux)
  options : --json  --max 40 (nombre de phrases signalées affichées)

Le diagnostic SIGNALE ; il ne décide pas. Une mesure hors zone est un indice à examiner,
pas un objectif à atteindre mécaniquement (voir references/revision.md)."""
import argparse, collections, glob, json, os, re, sys
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import stylo

LIB = {
    'virgules_1000': ('Virgules / 1000 mots', 'R-PONCT'),
    'virgules_phrase': ('Virgules par phrase', 'R-PONCT'),
    'virgule_et_1000': ('« , et » / 1000 mots', 'R-PONCT'),
    'deux_points_1000': ('Deux-points / 1000 mots', 'R-PONCT'),
    'guillemets_1000': ('Guillemets hors dialogue / 1000', 'R-PONCT'),
    'suspension_1000': ('Points de suspension / 1000', 'R-EXPR'),
    'exclamation_1000': ('Exclamations / 1000', 'R-EXPR'),
    'parentheses_1000': ('Parenthèses / 1000', 'R-EXPR'),
    'on_1000': ('« on » / 1000 mots', 'R-VOIX'),
    'nous_1000': ('« nous » / 1000 mots', 'R-VOIX'),
    'phr_moy': ('Longueur moyenne des phrases (mots)', 'R-SYNT'),
    'phr_ecart': ('Écart-type des longueurs', 'R-SYNT'),
    'phr_longues_pct': ('% phrases ≥ 30 mots', 'R-SYNT'),
    'phr_courtes_pct': ('% phrases ≤ 5 mots', 'R-RYTH'),
    'ouv_diversite': ('Diversité des débuts de phrase', 'R-OUV'),
    'ouv_repetee_pct': ('% débuts identiques consécutifs', 'R-OUV'),
    'ouv_pronom_pct': ('% phrases ouvertes par un pronom sujet', 'R-OUV'),
    'para_ouvre_courte_pct': ('% paragraphes ouverts par une phrase courte', 'R-ARCH'),
    'para_chute_courte_pct': ('% paragraphes finis par une chute courte', 'R-ARCH'),
    'accessoires_1000': ('Accessoires de fausse concrétude / 1000', 'R-LEX'),
    'formules_1000': ('Formules typiques IA / 1000', 'R-LEX'),
    'contrastes_1000': ('Contrastes correctifs / 1000', 'R-LEX'),
    'ressources_humaines_1000': ('Liaisons « humaines » / 1000', 'R-LIAIS'),
    'adj_par_nom': ('Adjectifs par nom', 'R-LEX'),
    'prepositions_pct': ('% prépositions', 'R-SYNT'),
    'coordination_pct': ('% conjonctions de coordination', 'R-SYNT'),
    'subordination_phrase': ('Subordonnants par phrase', 'R-SYNT'),
    'part_present_1000': ('Participes présents / 1000', 'R-SYNT'),
    'adv_ment_1000': ('Adverbes en -ment / 1000', 'R-LEX'),
    'fragments_1000': ('Fragments sans verbe / 1000', 'R-RYTH'),
}
SEUIL_DELTA = 0.35
# Mesures « défauts » : en avoir zéro n'est jamais une sur-correction.
SANS_PLANCHER = {'accessoires_1000', 'formules_1000', 'contrastes_1000', 'on_1000', 'deux_points_1000',
                 'guillemets_1000', 'virgule_et_1000', 'ouv_repetee_pct', 'incises_neutres_pct',
                 'fragments_1000', 'para_ouvre_courte_pct'}


# Mesures de construction : dépasser la zone humaine vers le haut est déjà une sur-correction.
PLAFOND_STRICT = {'phr_moy', 'phr_longues_pct', 'prepositions_pct', 'adj_par_nom', 'coordination_pct',
                  'subordination_phrase', 'phr_ecart'}
# Mesures secondaires : à corriger par la construction, jamais par ajout décoratif ; un écart résiduel est acceptable.
SECONDAIRES = {'adj_par_nom', 'prepositions_pct', 'coordination_pct', 'subordination_phrase', 'part_present_1000',
               'adv_ment_1000', 'ressources_humaines_1000', 'phr_ecart', 'virgules_phrase'}
# Sur-corrections typiques du pipeline (phrases allongées par les fusions, virgules trop rabotées, liaisons plaquées) :
# seules celles-ci comptent à la porte 6 ; les autres ⚠ relèvent de la variance humaine normale et sont indicatives.
SURCORR_PORTE = {'phr_moy', 'phr_longues_pct', 'virgules_1000', 'ressources_humaines_1000'}
PORTE = {'primaires_max': 2, 'total_max': 4, 'surcorrection_max': 1, 'signalees_max': 45, 'signalees_max_explicatif': 50}


def verdict(val, e, cle=None):
    """✓ zone humaine ; ~ limite ; ✗ côté IA ; ⚠ sur-correction (au-delà de l'humain, à l'opposé de l'IA)."""
    h, d = e['humain'], e.get('delta', 0)
    if val is None or h is None:
        return '·'
    if d > 0:  # l'IA est au-dessus
        if val > h['p90']: return '✗'
        if val > h['p75']: return '~'
        if val < h['p10'] and h['p10'] > 0 and cle not in SANS_PLANCHER: return '⚠'
        return '✓'
    else:
        if val < h['p10']: return '✗'
        if cle in PLAFOND_STRICT and val > h['p90']: return '⚠'
        if val > h['p90'] * 1.25 and h['p90'] > 0: return '⚠'
        if val < h['p25'] or val > h['p90']: return '~'
        return '✓'


def porte6(prio, flags, phrases, genre, mots, cible=None):
    """Évalue la porte 6. Renvoie (franchie, lignes de détail)."""
    prim = sum(1 for x in prio if x[0] == '✗' and x[-1] not in SECONDAIRES)
    tot = sum(1 for x in prio if x[0] == '✗')
    sur = sum(1 for x in prio if x[0] == '⚠' and x[-1] in SURCORR_PORTE)
    narr = max(1, sum(1 for p in phrases if not p.dialogue))
    sig = 100 * len(set(i for i, _, _ in flags)) / narr
    lim = PORTE['signalees_max_explicatif'] if genre == 'explicatif' else PORTE['signalees_max']
    conds = [(f'✗ primaires {prim} ≤ {PORTE["primaires_max"]}', prim <= PORTE['primaires_max']),
             (f'✗ au total {tot} ≤ {PORTE["total_max"]}', tot <= PORTE['total_max']),
             (f'⚠ sur-corrections de pipeline {sur} ≤ {PORTE["surcorrection_max"]}', sur <= PORTE['surcorrection_max']),
             (f'phrases signalées {sig:.0f} % ≤ {lim} %', sig <= lim)]
    if cible:
        ecart = 100 * (mots - cible) / cible
        conds.append((f'longueur {mots} mots, écart {ecart:+.0f} % (tolérance ±10 %)', abs(ecart) <= 10))
    return all(ok for _, ok in conds), conds


def analyser(chemin_ou_texte, genre, nlp, mq, est_texte=False):
    texte = chemin_ou_texte if est_texte else open(chemin_ou_texte, encoding='utf-8').read()
    m, phrases, paras = stylo.mesurer(texte, nlp, mq)
    flags = stylo.signaler(phrases, mq, nlp is not None, genre)
    return m, phrases, paras, flags


def rapport(m, phrases, flags, profil, genre, maxp, avant=None, nlp_ok=True, cible=None):
    L = []
    L.append(f'# Diagnostic — genre : {genre} — {m["mots"]} mots, {m["phrases"]} phrases'
             + ('' if nlp_ok else ' — MODE PARTIEL (spaCy absent : mesures syntaxiques omises)'))
    if m['mots'] < 300:
        L.append('Attention : texte court (< 300 mots), mesures globales peu fiables ; se fier surtout aux phrases signalées.')
    L.append('\n## 1. Profil global (zone humaine = p10–p90 du corpus humain du genre)\n')
    hdr = '| Mesure | Valeur | ' + ('Avant | ' if avant else '') + 'Zone humaine | Médiane IA | Verdict | Règle |'
    L.append(hdr)
    L.append('|---|---|' + ('---|' if avant else '') + '---|---|---|---|')
    prio = []
    for k, (lib, regle) in LIB.items():
        e = profil['mesures'].get(k)
        if not e or e.get('humain') is None or k not in m:
            continue
        if abs(e.get('delta', 0)) < SEUIL_DELTA:
            continue
        v = m[k]
        vd = verdict(v, e, k)
        h, ia = e['humain'], e.get('ia') or {}
        av = f'{avant[k]:.2f} | ' if avant and avant.get(k) is not None else ('— | ' if avant else '')
        sec = ' (2nd)' if k in SECONDAIRES else ''
        L.append(f'| {lib}{sec} | {v:.2f} | {av}{h["p10"]:.2f}–{h["p90"]:.2f} | {ia.get("p50", float("nan")):.2f} | {vd} | {regle} |')
        if vd in ('✗', '⚠'):
            prio.append((vd, abs(e['delta']), lib, regle, v, h, e['delta'], k))
    L.append('\nLégende : ✓ humain · ~ limite · ✗ côté IA · ⚠ sur-correction (au-delà des humains, dans l\'autre sens : à corriger aussi). '
             '(2nd) = mesure secondaire : corriger par la construction, jamais par ajout décoratif ; un écart résiduel est acceptable.')
    L.append('\n## 2. Priorités de révision (primaires d\'abord, puis par pouvoir discriminant)\n')
    if not prio:
        L.append('Aucune mesure globale hors zone. Passer à l\'examen des phrases signalées et à la lecture adverse.')
    for vd, dd, lib, regle, v, h, d, k in sorted(prio, key=lambda x: (x[-1] in SECONDAIRES, -x[1])):
        sens = ('trop élevé' if d > 0 else 'trop bas') if vd == '✗' else 'dépassé dans le sens opposé à l\'IA'
        vis = f'viser {h["p25"]:.2f}–{h["p75"]:.2f}'
        L.append(f'- {vd} **{lib}**{" (secondaire)" if k in SECONDAIRES else ""} = {v:.2f} ({sens}) → {vis} — voir revision.md §{regle}')
    ok, conds = porte6(prio, flags, phrases, genre, m['mots'], cible)
    L.append(f'\n**PORTE 6 : {"FRANCHIE" if ok else "NON FRANCHIE"}** — ' + ' · '.join(('✓ ' if c else '✗ ') + t for t, c in conds))
    L.append('\n## 3. Phrases signalées\n')
    par_phrase = collections.defaultdict(list)
    for i, code, det in flags:
        par_phrase[i].append((code, det))
    ordre = sorted(par_phrase, key=lambda i: (-len(par_phrase[i]), i))[:maxp]
    for i in sorted(ordre):
        p = phrases[i]
        codes = ' '.join(c for c, _ in par_phrase[i])
        dets = ' ; '.join(f'{c}: {d}' for c, d in par_phrase[i])
        extrait = p.texte if len(p.texte) <= 220 else p.texte[:217] + '…'
        L.append(f'- §{p.para + 1}.{p.rang + 1} [{codes}] « {extrait} »\n    ↳ {dets}')
    if len(par_phrase) > maxp:
        L.append(f'\n… {len(par_phrase) - maxp} autres phrases signalées (option --max).')
    cpt = collections.Counter(c for _, c, _ in flags)
    L.append('\n## 4. Comptage des signalements\n')
    L.append(', '.join(f'{c} {stylo.LIBELLES.get(c, c)} : {n}' for c, n in cpt.most_common()) or 'aucun')
    narr = max(1, sum(1 for p in phrases if not p.dialogue))
    L.append(f'\nTaux : {100 * len(par_phrase) / narr:.0f} % des phrases narratives signalées au moins une fois '
             '(repère : 20-50 % sur les extraits humains de calibration, 50-80 % sur les textes IA bruts).')
    return '\n'.join(L), prio


def tics_transversaux(textes, n=4, min_fichiers=3):
    compte = collections.Counter()
    for t in textes:
        mots = [w.lower() for w in stylo.MOT.findall(stylo.normaliser(t))]
        compte.update(set(' '.join(mots[i:i + n]) for i in range(len(mots) - n + 1)))
    banals = re.compile(r"^(?:(?:de|la|le|les|des|du|un|une|et|à|il|elle|je|que|qui|ne|pas|en|dans|sur|se|son|sa|ses|mon|ma|mes|ce|c'est|a|au|aux|pour|par|plus|y|est|l|d|qu|n|s|j|m|t|me|te|lui|on|nous|vous)\s?)+$")
    return [(g, c) for g, c in compte.most_common(400) if c >= min_fichiers and not banals.match(g)][:40]


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('fichier', nargs='?')
    ap.add_argument('--genre', default='essai', choices=None)
    ap.add_argument('--avant')
    ap.add_argument('--dossier')
    ap.add_argument('--json', action='store_true')
    ap.add_argument('--max', type=int, default=40)
    ap.add_argument('--cible', type=int, help='longueur visée en mots (contrôle ±10 %% à la porte 6)')
    a = ap.parse_args()
    profils = json.load(open(os.path.join(stylo.REF, 'profils.json')))
    if a.genre not in profils:
        sys.exit(f'Genre inconnu « {a.genre} ». Disponibles : {", ".join(profils)}')
    profil = profils[a.genre]
    nlp = stylo.charger_nlp()
    mq = stylo.charger_marqueurs()
    if a.dossier:
        fichiers = sorted(glob.glob(os.path.join(a.dossier, '*.txt')) + glob.glob(os.path.join(a.dossier, '*.md')))
        textes = []
        L = [f'# Diagnostic long format — {len(fichiers)} fichiers — genre {a.genre}\n',
             '| Fichier | Mots | ✗ | ⚠ | Phrases signalées % |', '|---|---|---|---|---|']
        for f in fichiers:
            t = open(f, encoding='utf-8').read()
            textes.append(t)
            m, ph, pa, fl = analyser(t, a.genre, nlp, mq, est_texte=True)
            _, prio = rapport(m, ph, fl, profil, a.genre, 0, nlp_ok=nlp is not None)
            narr = max(1, sum(1 for p in ph if not p.dialogue))
            L.append(f'| {os.path.basename(f)} | {m["mots"]} | {sum(1 for x in prio if x[0] == "✗")} | '
                     f'{sum(1 for x in prio if x[0] == "⚠")} | {100 * len(set(i for i, _, _ in fl)) / narr:.0f} |')
        L.append('\n## Tics transversaux (4-grammes présents dans au moins 3 fichiers)\n')
        L += [f'- « {g} » : {c} fichiers' for g, c in tics_transversaux(textes)] or ['aucun']
        L.append('\nPour le détail d\'un chapitre : relancer sur le fichier seul.')
        print('\n'.join(L))
        return
    if not a.fichier:
        ap.error('fichier ou --dossier requis')
    m, ph, pa, fl = analyser(a.fichier, a.genre, nlp, mq)
    avant = analyser(a.avant, a.genre, nlp, mq)[0] if a.avant else None
    if a.json:
        print(json.dumps({'mesures': m, 'signalements': [(ph[i].texte, c, d) for i, c, d in fl]}, ensure_ascii=False, indent=1))
        return
    print(rapport(m, ph, fl, profil, a.genre, a.max, avant, nlp is not None, a.cible)[0])


if __name__ == '__main__':
    main()
