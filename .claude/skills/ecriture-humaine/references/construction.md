# Étape 4 : Grammaire de construction calibrée

À lire avant toute rédaction. Les chiffres viennent du corpus de calibration (voir `donnees-calibration.md`). « Zone » = percentiles 10 à 90 des extraits humains de ~900 mots. « IA » = médiane des textes générés par Claude dans le même genre. On écrit **dans** la zone, sans viser un chiffre précis.

## Tableau de bord

| Mesure | Fiction (zone · IA) | Pratique | Explicatif | Essai/article |
|---|---|---|---|---|
| Virgules / 1000 mots | **37-58** · 86 | **33-52** · 70 | **47-70** · 78 | **37-69** · 74 |
| « , et » / 1000 mots | **0-2** · 7 | **0-2** · 5 | 1-7 · 6 | 0-6 · 6 |
| Deux-points / 1000 | **0-2** · 4 | 1-12 · 9 | **2-11** · 12 | 1-12 · 10 |
| Longueur moyenne de phrase | **11-16,5** · 11 | 12-18 · 13 | **14-22** · 15 | 12,5-21 · 14 |
| % phrases ≥ 30 mots | 0-8 | **1-14** · 3 | **5-21** · 6 | 3-20 · 5 |
| % phrases ≤ 5 mots | **4-25** · 29 | 4-26 | 2-27 | 4-27 |
| « on » / 1000 | **0-4,5** · 6 | **0-4,5** · 8 | **0-4** · 7 | **0-4,5** · 8 |
| « nous » / 1000 | 0-7 | 0-27 | **3-21** · 0 | **0-22** · 1 |
| Adjectifs par nom | **0,23-0,35** · 0,20 | 0,3-0,5 · 0,33 | 0,3-0,4 · 0,27 | 0,3-0,5 · 0,28 |
| Adverbes en -ment / 1000 | **3-12** · 4 | 8-24 · 10 | 5-15 | 7-18 |
| Participes présents / 1000 | **2-9** · 2 | **2-8** · 2 | 1-6 | 1-7 |
| Points de suspension / 1000 | **1-10** · 0 | 0-3 | 0-2 | 0-2 |
| Exclamations / 1000 | 0-13 · 0 | 0-3 | 0-4,5 | 0-4,5 |
| Liaisons « humaines » / 1000 | **3-12** · 0 | **8-16** · 2 | **4-15** · 1 | 5-15 · 1 |
| Accessoires / 1000 | **1-6** · 17 | 0-4 | **1-7** · 10 | 0-5,5 · 9 |
| Incises de dialogue neutres (« dit-il ») | **0-25 %** · 83 % | - | - | - |

En gras : les écarts les plus discriminants pour le genre.

## A. Ponctuation

**A1. Virgules : diviser par deux le réflexe.** La virgule est le premier marqueur IA (δ = +0,86 à +1,00 dans tous les genres). D'où viennent les virgules en trop, et ce qu'il faut faire à la place :
- **Énumérations de groupes nominaux** (« la tasse, le journal plié, les clés ») → un seul nom qui résume et un détail qui compte.
- **Appositions en cascade** (« Marc, son frère, l'aîné, celui qui… ») → une relative ou un complément du nom.
- **Incises de circonstance** (« Dans la cuisine, sur la table, il y avait… ») → les intégrer sans virgule (« Il y avait sur la table de la cuisine… »).
- **Participiales détachées** en fin de phrase (« …, les mains dans les poches, le regard ailleurs ») → au plus une par paragraphe.

**A2. Pas de virgule avant « et ».** Les humains coordonnent sans virgule (fiction : 1 pour 1000 mots contre 7 chez l'IA). La construction typiquement humaine est le **verbe coordonné à sujet partagé** :
> IA : « Il ouvre la porte, et il entre sans un bruit. »
> Humain : « Il ouvre la porte et entre sans un bruit. »

Si les sujets diffèrent et que la phrase est longue, préférer une subordination (« tandis que », « alors que », « lorsque ») à « , et ».

**A3. Deux-points : quasi interdits en narration.** Les deux-points de révélation (« Il n'y avait qu'une explication : quelqu'un était entré »), d'annonce (« Résultat : l'enfant se ferme ») et de liste mise en scène sont des marqueurs IA. En non-fiction, les garder pour une liste réellement annoncée ou une citation, sans dépasser la zone.

**A4. Guillemets hors dialogue.** L'IA cite à tout bout de champ des phrases-types (« Tu peux me dépanner ? »). En non-fiction pratique, la zone humaine est proche de **zéro**. Passer au discours indirect (« quand un collègue vous demande de le dépanner »).

**A5. Ponctuation expressive.** En fiction, la zone humaine *exige* des points de suspension (1 à 10 pour 1000 mots), et l'IA n'en met aucun. Les exclamations vont dans les répliques et la voix intérieure. Parenthèses et tirets d'incise servent en non-fiction aux apartés, aux exemples et à l'autodérision.

## B. Construction de la phrase

**B1. Longueur.** Plus long que le réflexe IA, sans tomber dans le pavé : fiction 13 à 16 mots en moyenne, non-fiction 15 à 20. En non-fiction, 8 à 20 % des phrases dépassent 30 mots. Elles se construisent par **expansion interne**, pas par empilement de virgules.

**B2. Les six procédés d'expansion humaine** (à préférer à la virgule) :
1. **Complément du nom** : « le grincement de la porte du garage », « la peur du rejet chez l'enfant ».
2. **Préposition plus groupe nominal** (les humains ont 2 points de prépositions de plus) : « à force de patience », « au bout du couloir », « sous l'effet de la fatigue ».
3. **Relative** : « la lettre qu'il n'avait jamais ouverte ».
4. **Subordonnée** : « lorsque », « tandis que », « dès que », « bien que », « afin que », « puisque », « alors que ». (Subordonnants par phrase : fiction 0,2 à 0,4 ; IA 0,19.)
5. **Participe présent et gérondif** (IA : 2 pour 1000 ; humain : 5) : « en refermant la porte », « ne sachant plus quoi répondre ».
6. **Verbes coordonnés à sujet partagé** : « Elle se lève, traverse la pièce et ouvre la fenêtre » (une virgule pour trois actions, pas trois phrases).

**B3. Adjectifs.** L'IA en met trop peu (fiction 0,20 par nom contre 0,29). Les évaluatifs se placent **avant** le nom (« un énorme malentendu », « une sale manie », « ce pauvre type »), les descriptifs après. Un adjectif vaut s'il porte un jugement ou une perception propre à la voix.

## C. Ouvertures de phrase

L'IA ouvre 41 % de ses phrases de fiction par un pronom sujet (humain : 29 %), et deux phrases de suite par le même mot trois fois plus souvent. Répertoire d'ouvertures humaines, à faire tourner :
- complément circonstanciel intégré : « Au bout du couloir », « Depuis la mort de sa mère » ;
- subordonnée : « Lorsque », « Dès que », « Bien que » ;
- gérondif ou participe : « En refermant la porte », « Agacé par ce silence » ;
- conjonction : « Et », « Mais », « Car » (assumés en début de phrase) ;
- adverbe de phrase : « Malheureusement », « Soudain », « Évidemment » ;
- groupe nominal possessif ou démonstratif : « Son manteau », « Ce genre d'homme » ;
- attribut ou objet antéposé quand la voix le permet : « Pathétique, ce numéro. »

Règles : jamais trois phrases de suite ouvertes par un pronom sujet ; jamais deux phrases consécutives avec le même premier mot, sauf anaphore voulue, une seule par texte.

## D. Rythme

- **Phrases très courtes** (5 mots ou moins) : en fiction, l'IA en fait 29 % contre 14 % chez l'humain. Elles sont autorisées dans les répliques, pour un vrai pic d'action, ou pour un verdict du narrateur. Hors dialogue : au plus une par paragraphe, jamais en ouverture de paragraphe, jamais deux de suite.
- **Fragments sans verbe** (« Rien. Le silence. ») : au plus une cascade par scène, et seulement si la voix est déjà installée.
- La variation naît de la *construction* (une longue phrase subordonnée suivie d'une moyenne), pas de l'alternance mécanique long/court.

## E. Paragraphes

- **Ouverture** : l'IA ouvre 2 à 3 fois plus souvent un paragraphe par une phrase-choc courte. L'humain ouvre par une phrase pleine qui reprend ce qui précède : « Encore une fois… », « Ce soir-là pourtant… », « Lorsque nous avons… ».
- **Fermeture** : jamais de maxime, d'antithèse (« Ce n'est pas X : c'est Y. »), de bilan ni de promesse (« Vous verrez que… »). On finit sur un fait, un geste en cours, une question, une annonce de la suite ou une phrase qui reste ouverte.
- **Longueur irrégulière** : un long paragraphe, puis deux courts, puis un moyen. Pas de blocs de taille égale, alors que l'IA découpe en blocs réguliers.
- **Pas de balisage IA** : pas de gras, pas d'intertitres en concepts parallèles, pas de listes à puces parfaitement symétriques (sauf genre qui l'exige, comme une fiche pratique). Une liste humaine est irrégulière : un élément plus long, un autre qui casse la série.

## F. Lexique

- **Liaisons** (« ressources humaines », sous-employées par l'IA d'un facteur 4 à 10) : « lorsque », « afin de », « ainsi », « alors que », « tandis que », « dès que », « bien que », « à nouveau », « à présent », « en même temps », « de plus en plus », « grâce à », « il s'agit de », « malheureusement », « constamment », « également ». Dose : la zone du genre (fiction 3 à 12 pour 1000 mots, non-fiction 5 à 15). Au-delà, c'est un nouveau tic (⚠).
- **Formules IA** à éviter (liste complète dans `marqueurs.json`) : « ce qui compte », « ce n'est pas grave », « quelque part », « quelque chose de… », « presque », « plutôt que », « peu à peu », « en permanence », « à voix basse », « sans un mot », « cette phrase », « un mot », « comme on + verbe », « il faut » répété, « En somme », « Autrement dit », « ni X ni Y ».
- **Contraste correctif** (« ce n'est pas X, c'est Y » ; « ne… pas X, mais Y ») : au plus un par texte, jamais en fin de paragraphe.
- **Accessoires** : voir `matiere.md` §2.
- **Mots-concepts répétés** : un terme abstrait (« bienveillance », « limite », « régulation ») ne revient pas à chaque paragraphe. On le varie, ou on le remplace par la chose concrète qu'il désigne.

## G. Voix

- **« on »** : en non-fiction, le remplacer par « nous » (les auteurs), « vous » (le lecteur), un sujet précis (« beaucoup de parents ») ou une tournure personnelle. En fiction, le garder dans les répliques familières (« on y va »).
- **L'auteur existe** : en non-fiction, « nous » ou « je » d'auteur, expérience propre (fournie par l'utilisateur), humour, autodérision, parenthèse qui digresse. En fiction : verdicts sur les personnes, registre propre au narrateur, mots familiers si le contrat de voix les autorise.
- **Affirmer sans tiédeur** : l'IA nuance par réflexe (« le message le plus honnête est nuancé »). L'humain tranche (« il est vital de… ») et nuance quand c'est nécessaire.

## H. Images et expressions

- **Filer** une image sur deux ou trois termes du même champ (marionnettiste → pantins → ficelles) au lieu d'enchaîner des comparaisons isolées.
- Les comparants humains du corpus viennent de l'animal, du jeu, de la mécanique, du métier et du corps. L'IA préfère l'abstraction (« un verdict moral ») et « comme on + verbe » (« comme on surveille une porte »).
- Les **expressions figées** (« gros comme une maison », « hisser le drapeau blanc ») sont humaines, surtout un peu détournées. Une à trois par 1000 mots dans une voix qui les accepte.
- **Moins de comparaisons**, mieux choisies : l'IA en met environ 5 pour 1000 mots en fiction, l'humain 3.

## I. Dialogue (fiction)

- **Incises** : l'IA utilise un verbe neutre dans 83 % des cas (« dit-il », « répondit-elle »), l'humain dans 0 à 25 %. Préférer :
  - pas d'incise quand on sait qui parle ;
  - un verbe d'attitude qui apporte une information (« lâche-t-il », « grogne », « tranche-t-elle », « se défend », « s'agace », « ironise », « rétorque ») ;
  - une incise d'action (« — Laisse. Il repose le verre. »).
- **Les répliques résistent** : un personnage esquive, ment, répond à côté, revient à la charge. L'IA règle une tension en deux répliques. On laisse un désaccord ouvert.
- **Registre parlé** : élisions et tournures orales dans les répliques si le personnage parle ainsi (« T'es sûr ? », « Pas la peine »), interjections et exclamations.
