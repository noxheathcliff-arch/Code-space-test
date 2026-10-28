"""Typographie française d'édition (facultatif, étape 8).

Usage : python3 typo_fr.py entree.md [sortie.md]   (sans sortie : écrit sur la sortie standard)

- apostrophe droite → apostrophe typographique ’
- ... → …
- "texte" → « texte » (paires sur une même ligne)
- tiret de dialogue en début de ligne (- ou –) → —
- espace insécable fine avant ; ! ? et dans « », insécable avant :
Ne touche pas aux blocs de code délimités par ```."""
import re, sys

FINE, INSEC = ' ', ' '


def typo(ligne):
    l = ligne
    l = re.sub(r"(?<=\w)'(?=\w)", '’', l)
    l = l.replace('...', '…')
    l = re.sub(r'"([^"\n]+)"', lambda m: f'«{INSEC}{m.group(1).strip()}{INSEC}»', l)
    l = re.sub(r'«\s*', f'«{INSEC}', l)
    l = re.sub(r'\s*»', f'{INSEC}»', l)
    l = re.sub(r'^(\s*)[-–]\s+', r'\1— ', l)
    l = re.sub(r'\s*([;!?])', lambda m: FINE + m.group(1), l)
    l = re.sub(r'(?<=\S)\s*:(?=\s|$)', INSEC + ':', l)
    l = re.sub(r'([!?])' + FINE + r'([!?])', r'\1\2', l)  # « ?! »
    return l


def main():
    src = open(sys.argv[1], encoding='utf-8').read().split('\n')
    out, code = [], False
    for l in src:
        if l.strip().startswith('```'):
            code = not code
            out.append(l)
            continue
        out.append(l if code else typo(l))
    res = '\n'.join(out)
    if len(sys.argv) > 2:
        open(sys.argv[2], 'w', encoding='utf-8').write(res)
    else:
        sys.stdout.write(res)


if __name__ == '__main__':
    main()
