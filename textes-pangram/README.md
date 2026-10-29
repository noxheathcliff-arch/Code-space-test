# Textes à passer dans Pangram

## Version 2 du skill (9 livres, points de décision, émotion) : dossier `v2/`

| Fichier | Consigne | Mots | Indice d'humanité (modèle v2) | Porte 6 |
|---|---|---|---|---|
| `v2/scene-port-avec-skill.md` | Scène, 3e personne, passé : une jeune femme réclame à un vieux capitaine l'argent prêté par son père | 979 | **97** | franchie |
| `v2/scene-port-sans-skill.md` | même consigne, Claude Opus sans skill (témoin) | 1 078 | 17 | non franchie |
| `v2/procrastination-avec-skill.md` | Développement personnel : pourquoi nous remettons à plus tard ce qui compte | 801 | **97** | franchie |
| `v2/procrastination-sans-skill.md` | même consigne, sans skill (témoin) | 837 | 27 | non franchie |

Sources citées dans `procrastination-avec-skill.md`, de mémoire, **à vérifier avant toute publication** :
- Sirois et Pychyl (2013), *Social and Personality Psychology Compass* ;
- Wohl, Pychyl et Bennett (2010), *Personality and Individual Differences* ;
- Pychyl, *Solving the Procrastination Puzzle* (2013).

Le personnage d'Agnès est un cas illustratif annoncé comme tel.

**Ce qui serait le plus utile en retour** : le pourcentage global de chaque fichier, et les passages surlignés « IA » par Pangram s'il y en a. Ces passages permettent de réentraîner le modèle de points sur ce que Pangram voit réellement.

---

## Version 1 (historique)

## Texte principal (pipeline complet, sélection par points comprise)

| Fichier | Consigne | Mots | Indice d'humanité (points du skill) | Porte 6 |
|---|---|---|---|---|
| `scene-avec-skill.md` | Scène de roman, 1re personne : une femme revient vider la maison de sa grand-mère dans le Jura et y trouve quelqu'un qu'elle n'attendait pas | 1 068 | **97** | franchie |
| `scene-avec-skill-typographie-edition.md` | même texte, typographie d'édition (’ « » …, espaces insécables) | 1 051 | 97 | franchie |
| `scene-sans-skill.md` | **même consigne**, Claude Opus sans skill (témoin) | 1 191 | **1** | non franchie |

L'indice d'humanité est celui du modèle de points du skill, **pas un score Pangram**. Repères : extraits humains tenus à l'écart, médiane 91 ; Claude brut, médiane 10.

## Tests précédents (`tests-precedents/`)

Paires de textes sur les mêmes consignes, sans skill et avec la **v1** du skill. La v1 n'avait pas encore la sélection par points, d'où des indices plus bas, surtout en non-fiction.

| Consigne | Sans skill (Opus / Sonnet) | Avec skill v1 (Opus / Sonnet) |
|---|---|---|
| F1 : attente dans une gare (fiction) | 10 / 7 | 85 / 72 |
| F2 : mensonge d'une amie dans le bus (fiction) | 9 / 16 | 86 / 84 |
| P1 : arrêter de se comparer (développement personnel) | 9 / 10 | 69 / 72 |
| E2 : les « pourquoi » des enfants (vulgarisation) | 12 / 7 | 32 / 43 |

## Comment tester (pour que le résultat veuille dire quelque chose)

1. Coller **chaque fichier en entier**, sans le titre Markdown `#`.
2. Noter pour chacun le verdict (IA / mixte / humain), le pourcentage ou score affiché, et le surlignage éventuel des passages.
3. Tester **aussi le témoin** `scene-sans-skill.md`. Si Pangram ne le classe pas IA, le test ne discrimine rien.
4. Tester les deux typographies de la même scène : une différence de score dirait que Pangram est sensible à la typographie.
5. Noter la date : les détecteurs sont mis à jour régulièrement.

| Fichier | Verdict Pangram | Score / % IA | Passages surlignés | Date |
|---|---|---|---|---|
| scene-avec-skill.md | | | | |
| scene-avec-skill-typographie-edition.md | | | | |
| scene-sans-skill.md | | | | |
| tests-precedents/F1-opus-avec-skill-v1.md | | | | |
| tests-precedents/F1-opus-sans-skill.md | | | | |

Un seul texte classé humain ne prouve pas qu'un texte est indétectable. Un texte classé IA ne prouve pas que le skill est inutile. Ce qui compte, c'est la tendance sur l'ensemble des fichiers (voir `.claude/skills/ecriture-humaine/eval/protocole.md`). Si Pangram surligne des passages précis, ce sont les informations les plus précieuses à me renvoyer : elles permettront de recalibrer le skill.
