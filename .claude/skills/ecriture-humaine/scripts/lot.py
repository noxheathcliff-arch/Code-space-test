"""Évaluation par lots : compare plusieurs groupes de textes (ex. IA brute / IA + skill / humain).

Usage :
  python3 lot.py --genre fiction --groupe brut eval/sorties/brut/ --groupe skill eval/sorties/skill/ [--groupe humain refs/]

Affiche, par groupe : nombre de textes, médiane du nombre de mesures ✗ et ⚠, médiane du % de phrases
signalées, et la médiane des mesures les plus discriminantes du genre. Les fichiers .txt et .md sont lus."""
import argparse, glob, json, os, statistics as st, sys
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import stylo, diagnostic


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('--genre', required=True)
    ap.add_argument('--groupe', nargs=2, action='append', metavar=('NOM', 'DOSSIER'), required=True)
    a = ap.parse_args()
    profil = json.load(open(os.path.join(stylo.REF, 'profils.json')))[a.genre]
    nlp, mq = stylo.charger_nlp(), stylo.charger_marqueurs()
    cles = sorted((k for k, e in profil['mesures'].items() if abs(e.get('delta', 0)) >= 0.6),
                  key=lambda k: -abs(profil['mesures'][k]['delta']))[:10]
    print(f'Genre {a.genre} — mesures suivies : {", ".join(cles)}\n')
    entete = ['groupe', 'n', 'méd ✗', 'méd ⚠', 'méd % signalées'] + cles
    print(' | '.join(entete))
    print('|'.join(['---'] * len(entete)))
    for nom, dossier in a.groupe:
        fichiers = sorted(glob.glob(os.path.join(dossier, '*.txt')) + glob.glob(os.path.join(dossier, '*.md')))
        lignes = []
        for f in fichiers:
            m, ph, pa, fl = diagnostic.analyser(f, a.genre, nlp, mq)
            _, prio = diagnostic.rapport(m, ph, fl, profil, a.genre, 0, nlp_ok=nlp is not None)
            narr = max(1, sum(1 for p in ph if not p.dialogue))
            lignes.append((sum(1 for x in prio if x[0] == '✗'), sum(1 for x in prio if x[0] == '⚠'),
                           100 * len(set(i for i, _, _ in fl)) / narr, m))
        if not lignes:
            print(f'{nom} | 0 | (aucun fichier)')
            continue
        med = lambda v: st.median([x for x in v if x is not None]) if any(x is not None for x in v) else float('nan')
        vals = [nom, str(len(lignes)), f'{med([l[0] for l in lignes]):.1f}', f'{med([l[1] for l in lignes]):.1f}',
                f'{med([l[2] for l in lignes]):.0f}'] + [f'{med([l[3].get(k) for l in lignes]):.2f}' for k in cles]
        print(' | '.join(vals))
    print('\nZones humaines (p10–p90) : ' + ' ; '.join(
        f'{k} {profil["mesures"][k]["humain"]["p10"]:.2f}–{profil["mesures"][k]["humain"]["p90"]:.2f}' for k in cles))


if __name__ == '__main__':
    main()
