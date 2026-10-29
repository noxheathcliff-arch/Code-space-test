# Genre : non-fiction (essai, article, chronique, billet, développement personnel, vulgarisation)

Profils :
- `--genre pratique` (développement personnel, guide, conseil) : calibré sur un livre de développement personnel français de 2021 ;
- `--genre explicatif` (vulgarisation, pédagogie) : calibré sur un livre de psychologie de l'enfant traduit de l'anglais par une traductrice humaine ;
- `--genre essai` (essai, article, chronique, billet) : profil mixte des deux.

Les comparaisons portent sur 30 textes IA par genre, plus 8 textes « divers » (essai, article, chronique, lettre, billet).

## Ce qui sépare le plus la non-fiction humaine de la non-fiction IA

1. **Virgules** : 44 à 58 pour 1000 mots contre 70 à 78.
2. **« on » générique** : 1 à 2 contre 7 à 8.
3. **« nous » d'auteur** : 11 contre 0 en vulgarisation.
4. **Deux-points d'annonce** : « Résultat : », « Le piège : ».
5. **Guillemets** : citations de phrases-types (développement personnel : 0 chez l'humain contre 5 pour 1000 mots).
6. **Liaisons classiques** : 9 à 11 contre 1 à 2.
7. **Phrases longues (≥ 30 mots)** : 8 à 13 % contre 3 à 6 %.
8. **Prépositions et coordination** : nettement plus fréquentes chez l'humain.

À la lecture, on observe aussi :
- l'ancrage humain : auteurs nommés, expérience propre, renvois à d'autres chapitres ;
- l'humour et les apartés entre parenthèses ;
- les fins sur une scène ou une annonce plutôt que sur une maxime ;
- les listes irrégulières.

## Retour Pangram (texte « procrastination », v2) : 64 % IA

Le modèle de points du skill donnait 90 à 100 d'humanité à **tous** les passages. Pangram en a pourtant classé la majorité IA. Le partage est net :
- **classé humain** : le cas concret (Agnès, la lettre, les joints de la baignoire, la déclaration d'impôts) et la description factuelle d'une étude ;
- **classé IA** : tout le raisonnement général qui suit (« la plupart d'entre nous », « Nous voilà d'une efficacité redoutable… tandis que… »), l'analogie filée et ses chutes imagées (« Le buffet les protège de nos mains maladroites. », « Chaque reproche alourdit la lettre… et referme d'un cran la porte du buffet. »), et l'antithèse élégante (« Loin de la complaisance avec laquelle nous le confondons… »).

**Leçon.** La ponctuation, les mots-outils et la syntaxe peuvent être entièrement dans la zone humaine sans rien changer à ce que voit Pangram. Ce qui trahit la non-fiction, c'est le **mode de discours** : la généralisation éloquente, la métaphore qui conclut, la période équilibrée. Le skill ne mesure pas encore ces traits.

**Règles provisoires, jusqu'à une recalibration**
1. **Chaque paragraphe reste attaché à du concret** : le cas, une scène, un fait, une donnée, un exemple du lecteur. Pas de paragraphe entier de réflexion générale en « nous ».
2. **Pas de chute imagée en fin de paragraphe.** L'image s'emploie au milieu d'un raisonnement, sans l'achever.
3. **Pas de période balancée** (« Loin de X, Y », « Nous voilà… tandis que… », « non pas… mais… ») : dire la chose plus platement.
4. **Pas de sur-dosage de liaisons** : ce texte était à 13,4 pour 1000, en haut de la zone humaine. Viser la médiane (≈ 8).
5. **Préférer l'explication prosaïque**, voire un peu maladroite, d'un auteur qui explique, à l'éloquence d'un auteur qui « écrit bien ».

## Procédure spécifique

**Avant la rédaction (étape 2)**
- **Thèse** : l'écrire en une phrase dans la fiche… puis la mettre dans les non-dits si possible. Le lecteur doit la tirer du cas.
- **Ancrage** : lister ce qui est réel et disponible (sources connues avec certitude, expériences fournies par l'utilisateur). Le reste se marque `[À FOURNIR]`. Ne jamais compléter par de l'invention.
- **Cas d'entrée** : une situation reconnaissable par le lecteur. Pas datée à la minute, pas « Sacha, 7 ans » par défaut.
- **Image filée** : une image de travail pour tout le passage (choisie par échantillonnage de queue), reprise 2 à 4 fois.
- **Plan** : asymétrique. Si des intertitres sont nécessaires, à l'impératif, à l'infinitif ou en libellé concret (« Dire non au patron », « Quand la crise éclate au supermarché »), jamais en concepts parallèles.

**Pendant la rédaction (étape 4)**
- Voix d'auteur en « nous » ou « je », avec « vous » pour le lecteur. « on » réservé aux expressions figées.
- Phrases de raisonnement longues : cause, condition, concession, construites avec des liaisons (« lorsque », « afin de », « bien que », « ainsi », « il s'agit de »).
- Une parenthèse d'aparté ou d'exemple par section, une pointe d'humour si la fiche l'autorise.
- Conseils formulés directement (impératif, « vous pouvez ») plutôt que « il faut » répété.
- Listes seulement si le contenu est vraiment énumératif. Les rendre irrégulières (longueurs différentes, un élément commenté).
- Fin : une annonce de la suite, un cas qui reste ouvert, un conseil concret. Jamais de maxime, de bilan, d'injonction « essayez cette semaine » ni de promesse de résultat.

**Révision (étape 6) : priorités non-fiction**
1. L3 (« on »), P1 (deux-points), guillemets, S1 (contrastes « ce n'est pas X, c'est Y »).
2. V1 et V2 (virgules) ; fusion des phrases courtes en raisonnements longs.
3. Liaisons, prépositions, « nous ».
4. Macro-tics de `jugement.md` : ouverture par une idée reçue, analogie expliquée, chute aphoristique, sources vagues.

## Articles de presse et chroniques

Pas de profil de calibration propre (aucun corpus de presse fourni) : utiliser `--genre essai` et les mêmes principes.

Conventions humaines à respecter :
- **Article d'information** : attaque factuelle, citations réelles attribuées, pas de morale.
- **Chronique** : un « je » qui tranche, de la mauvaise foi assumée, une chute qui n'est pas une leçon.

Si l'utilisateur fournit des articles de référence, construire un profil dédié (`construire_profil.py --genre presse`).
