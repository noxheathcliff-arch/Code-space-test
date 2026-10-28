# ecriture-humaine : skill Claude

Un pipeline strict d'écriture et de révision en français. Il produit une prose dont la fabrication (ponctuation, construction des phrases, ouvertures, lexique, voix, architecture) se rapproche de celle d'auteurs humains. Il est calibré sur trois livres humains et 114 textes générés par Claude dans les mêmes genres.

## Installation

**Claude Code** :
- *personnel* : copier le dossier `ecriture-humaine/` dans `~/.claude/skills/` ;
- *projet* : le laisser dans `.claude/skills/` du dépôt.

**Claude.ai / application** : zipper le dossier `ecriture-humaine/` et l'importer dans Réglages → Capacités → Skills (l'exécution de code doit être activée pour les scripts).

**Dépendances des scripts** (recommandé, sinon mode partiel) :
```
pip install spacy
python -m spacy download fr_core_news_md
```

## Utilisation

Le skill se déclenche quand on demande d'écrire, de réécrire ou d'« humaniser » un texte en français. On peut aussi l'appeler explicitement : « Utilise le skill ecriture-humaine pour écrire… ».

Scripts utilisables seuls :
```
python3 scripts/diagnostic.py mon_texte.md --genre fiction          # fiction | pratique | explicatif | essai
python3 scripts/diagnostic.py v2.md --genre essai --avant v1.md      # avant / après
python3 scripts/diagnostic.py --dossier chapitres/ --genre fiction   # livre : tics transversaux
python3 scripts/lot.py --genre fiction --groupe A dirA/ --groupe B dirB/
python3 scripts/construire_profil.py --genre ma_voix --humain mes_textes/ [--ia textes_ia/]
python3 scripts/typo_fr.py texte.md sortie.md                        # typographie d'édition
```

## Adapter à une voix ou à un genre

Fournir au moins 50 000 mots de textes humains du genre ou de l'auteur visé (fichiers .txt), puis lancer `construire_profil.py --genre <nom> --humain <dossier> --ia <textes IA du même genre>`. Le nouveau profil est utilisable avec `--genre <nom>`.

## Limites

Voir `references/donnees-calibration.md` et `eval/protocole.md`. Ce skill réduit les marqueurs mesurables d'écriture IA et impose une méthode. Il ne modifie pas le modèle et ne garantit pas qu'un détecteur ne reconnaîtra pas un texte.
