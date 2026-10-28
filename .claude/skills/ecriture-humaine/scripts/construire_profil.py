"""Construit (ou met à jour) un profil de référence à partir de textes humains, et facultativement de textes IA.

Usage :
  python3 construire_profil.py --genre fiction --humain dossier_humain/ [--ia dossier_ia/] [--decouper 900]

Les textes humains longs (livres) sont découpés en extraits d'environ N mots pour que les mesures
soient comparables à celles d'un texte de longueur ordinaire. Le profil est écrit dans
references/profils.json sous la clé du genre (les autres genres sont conservés)."""
import argparse, glob, json, os, sys
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import stylo


def extraits(chemin, taille):
    paras = stylo.paragraphes(open(chemin, encoding='utf-8').read())
    buf, n, out = [], 0, []
    for p in paras:
        buf.append(p)
        n += len(p.split())
        if n >= taille:
            out.append('\n'.join(buf))
            buf, n = [], 0
    if n >= taille * 0.6:
        out.append('\n'.join(buf))
    return out


def quantiles(v):
    v = sorted(x for x in v if x is not None)
    if not v:
        return None
    q = lambda f: v[min(len(v) - 1, int(round(f * (len(v) - 1))))]
    return {'p10': q(.1), 'p25': q(.25), 'p50': q(.5), 'p75': q(.75), 'p90': q(.9)}


def cliff(a, b):
    a = [x for x in a if x is not None]
    b = [x for x in b if x is not None]
    if not a or not b:
        return 0.0
    gt = sum(1 for x in a for y in b if x > y)
    lt = sum(1 for x in a for y in b if x < y)
    return (gt - lt) / (len(a) * len(b))


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('--genre', required=True)
    ap.add_argument('--humain', required=True, nargs='+', help='dossiers ou fichiers .txt humains')
    ap.add_argument('--ia', nargs='*', default=[], help='dossiers ou fichiers .txt IA (facultatif)')
    ap.add_argument('--decouper', type=int, default=900)
    ap.add_argument('--sortie', default=os.path.join(stylo.REF, 'profils.json'))
    a = ap.parse_args()
    nlp = stylo.charger_nlp()
    if nlp is None:
        print('Attention : spaCy absent, profil partiel (mesures morphosyntaxiques omises).', file=sys.stderr)
    mq = stylo.charger_marqueurs()

    def fichiers(sources):
        out = []
        for s in sources:
            out += sorted(glob.glob(os.path.join(s, '*.txt'))) if os.path.isdir(s) else [s]
        return out

    H = []
    for f in fichiers(a.humain):
        for e in extraits(f, a.decouper):
            H.append(stylo.mesurer(e, nlp, mq)[0])
    A = [stylo.mesurer(open(f, encoding='utf-8').read(), nlp, mq)[0] for f in fichiers(a.ia)]
    profil = {'_n_humain': len(H), '_n_ia': len(A), 'mesures': {}}
    for k in H[0]:
        if k in ('mots', 'phrases'):
            continue
        hv = [h.get(k) for h in H]
        e = {'humain': quantiles(hv)}
        if A:
            av = [x.get(k) for x in A]
            e['ia'] = quantiles(av)
            e['delta'] = round(cliff(av, hv), 3)
        profil['mesures'][k] = e
    tout = json.load(open(a.sortie)) if os.path.exists(a.sortie) else {}
    tout[a.genre] = profil
    json.dump(tout, open(a.sortie, 'w'), ensure_ascii=False, indent=1)
    print(f'Profil « {a.genre} » écrit : {len(H)} extraits humains, {len(A)} textes IA → {a.sortie}')


if __name__ == '__main__':
    main()
