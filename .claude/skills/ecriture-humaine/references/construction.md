# Étape 4 : Grammaire de construction calibrée

À lire avant toute rédaction. Les chiffres viennent du corpus de calibration (voir `donnees-calibration.md`). « Zone » = percentiles 10 à 90 des extraits humains de ~900 mots. « IA » = médiane des textes générés par Claude dans le même genre. On écrit **dans** la zone, sans viser un chiffre précis.

## Tableau de bord

| Mesure | Fiction (zone · IA) | Pratique | Explicatif | Essai/article |
|---|---|---|---|---|
| Virgules / 1000 mots | 47-105 · 85 | 37-79 · 72 | **51-72 · 75** | **41-77 · 74** |
| « , et » / 1000 mots | **0-6 · 7,8** | **0-4,3 · 5,4** | **1-6,4 · 6,4** | **0-5,4 · 6,2** |
| Deux-points / 1000 | 0-5,4 · 3,3 | 1,5-12,6 · 9,6 | 2,6-13,9 · 10,9 | 2,2-13,5 · 9,6 |
| Longueur moyenne de phrase (**plafond strict**) | 9,3-18 · 12 | **15-28 · 14** | 14-24 · 16 | **15-26 · 16** |
| % phrases ≥ 30 mots | 0-16 · 4,8 | **7-37 · 4,5** | 7,5-27 · 8,7 | **7-35 · 5,8** |
| % phrases ≤ 5 mots | 4-37 · 27 | 0-17,5 · 13 | 2,4-24 · 7,8 | 0-20 · 10 |
| Autocorrélation des longueurs (zones de rythme) | −0,18 à +0,30 · −0,14 | −0,20 à +0,25 · −0,08 | −0,13 à +0,38 · −0,12 | −0,16 à +0,32 · −0,10 |
| % phrases finies par ? ! … | 0-13,6 · 0 | 0-21 · 3 | **2,3-28 · 1,8** | **2,2-25 · 1,9** |
| « on » / 1000 | **0-5,6 · 6,1** | **0-7,3 · 8,1** | 0-10 · 8,8 | **0-9,2 · 9,1** |
| « nous » / 1000 | 0-7,8 · 0 | **1,1-43 · 4** | **1,2-18 · 1** | **1,2-37 · 1,3** |
| Adjectifs par nom | **0,21-0,33 · 0,20** | 0,23-0,45 · 0,33 | **0,28-0,45 · 0,27** | 0,24-0,45 · 0,29 |
| Adverbes en -ment / 1000 | **4,3-14 · 4,2** | 7,8-22 · 9,7 | 5,7-15 · 9 | 6,3-19,5 · 9 |
| Participes présents / 1000 | **2,2-14,5 · 2** | 1,4-7,9 · 2,2 | 1,1-6,5 · 2,4 | 1,2-7,4 · 2,4 |
| Points de suspension / 1000 | **1,1-11 · 0** | 0-4,2 · 0 | 0-8,3 · 0 | 0-6,5 · 0 |
| Exclamations / 1000 | **0-13 · 0** | 0-7 · 0 | 0-3,4 · 0 | 0-5,5 · 0 |
| Liaisons « humaines » / 1000 | **2,2-9,2 · 0** | **3,3-14,7 · 2,1** | **3,2-12 · 1,2** | **3,2-14,6 · 1,4** |
| Accessoires / 1000 | **1,1-11,6 · 16,7** | 0-7,5 · 3,9 | 1-9,6 · 9,3 | 0-8,8 · 8,8 |
| % phrases ouvertes par un pronom sujet | **7,5-35 · 40** | 7-37,5 · 24 | 5-22 · 18,5 | 5,6-33 · 22,5 |
| % phrases finies sur une négation | **0-4,8 · 5,4** | 0-7,1 · 2,4 | 0-3,6 · 0 | 0-5,3 · 2 |
| Noms propres / 1000 | 12-62 · 23,5 | 1,7-13 · 2,2 | 3,7-24 · 9 | 2,2-20 · 5,8 |
| Mots par phrase de réplique | **5,6-13,2 · 5,9** | 11-24 · 12,9 | 7,2-24 · 11,5 | 8,9-24 · 11,7 |
| Incises de dialogue neutres (« dit-il ») | **0-60 % · 80 %** | - | - | - |

Zones calculées sur 9 livres (≈ 820 000 mots, au plus 70 extraits de 900 mots par livre pour qu'aucun ne domine). Avec quatre romanciers très différents (une romance française, Martin et Sapkowski traduits, un roman jeunesse contemporain), les zones de fiction sont **larges** : la diversité est un trait humain. Ce qui reste étroit et discriminant malgré cette diversité est en gras.

En gras : les écarts les plus discriminants pour le genre.

**Mesures primaires et secondaires.** Les mesures de ponctuation, de « on », d'accessoires, de formules, de longueur et d'ouverture sont **primaires** : on les corrige. Les autres sont **secondaires** : adjectifs par nom, prépositions, coordination, subordination, participes, adverbes en -ment, liaisons. Elles sont le *résultat* d'une bonne construction et ne se visent pas en ajoutant des mots. On les améliore en appliquant §B2 à la place de la juxtaposition. Si la seule façon d'y arriver est d'ajouter un adjectif ou un connecteur décoratif, on accepte l'écart.

**Le piège n° 1 du pipeline.** Les tests le montrent : réduire les virgules et fusionner les phrases courtes **allonge les phrases au-delà de la zone humaine**. Les 4 scènes de test sont toutes passées au-dessus de 17 mots de moyenne. La longueur moyenne a un **plafond strict** : au-delà de la zone, le diagnostic signale ⚠. Une fusion ne se fait que si la phrase obtenue reste lisible d'une traite.

## A. Ponctuation

**A1. Virgules : viser les mauvaises, pas toutes.** Sur 3 livres, la densité de virgules séparait parfaitement l'humain de l'IA. Sur 9 livres, ce n'est plus vrai en fiction : Martin et Sapkowski traduits en mettent autant que Claude, dans des phrases longues. Ce qui reste discriminant partout, c'est **le type** de virgule : « , et » (le marqueur le plus stable du corpus), les énumérations de groupes nominaux, les appositions en cascade, la virgule de rajout (« …, dans la cuisine »). Dans la non-fiction, la densité reste trop élevée chez l'IA. Ce qu'il faut faire à la place :
- **Énumérations de groupes nominaux** (« la tasse, le journal plié, les clés ») → un seul nom qui résume et un détail qui compte.
- **Appositions en cascade** (« Marc, son frère, l'aîné, celui qui… ») → une relative ou un complément du nom.
- **Incises de circonstance** (« Dans la cuisine, sur la table, il y avait… ») → les intégrer sans virgule (« Il y avait sur la table de la cuisine… »).
- **Participiales détachées** en fin de phrase (« …, les mains dans les poches, le regard ailleurs ») → au plus une par paragraphe.

**On garde les virgules qui servent la lecture.** Celle qui suit un complément circonstanciel long placé en tête (« Au bout de trois jours sans nouvelles, elle… »), celles qui encadrent une vraie incise, celle qui précède « mais ». La chasse vise les énumérations, les appositions en série et « , et ». Dans le doute, lire la phrase sans la virgule : si on bute, on la remet.

**A2. Pas de virgule avant « et ».** Les humains coordonnent sans virgule (fiction : 1 pour 1000 mots contre 7 chez l'IA). La construction typiquement humaine est le **verbe coordonné à sujet partagé** :
> IA : « Il ouvre la porte, et il entre sans un bruit. »
> Humain : « Il ouvre la porte et entre sans un bruit. »

Si les sujets diffèrent et que la phrase est longue, préférer une subordination (« tandis que », « alors que », « lorsque ») à « , et ».

**A3. Deux-points.**
- **Fiction** : quasi interdits en narration. Les deux-points de révélation (« Il n'y avait qu'une explication : quelqu'un était entré ») sont un marqueur IA.
- **Non-fiction** : les humains en emploient aussi (zone de 1 à 12 pour 1000 mots), pour annoncer une liste, une explication ou une citation. Ce qui trahit l'IA, c'est le deux-points **d'étiquette** : un ou quelques mots puis deux-points (« Résultat : », « Le piège : », « La clé : »). Le script ne signale que ceux-là en non-fiction.

**A4. Guillemets hors dialogue.** L'IA cite à tout bout de champ des phrases-types (« Tu peux me dépanner ? »). En non-fiction pratique, la zone humaine est proche de **zéro**. Passer au discours indirect (« quand un collègue vous demande de le dépanner »).

**A5. Ponctuation expressive.** En fiction, la zone humaine *exige* des points de suspension (1 à 10 pour 1000 mots), et l'IA n'en met aucun. Les exclamations vont dans les répliques et la voix intérieure. Parenthèses et tirets d'incise servent en non-fiction aux apartés, aux exemples et à l'autodérision.

## B. Construction de la phrase

**B1. Longueur.** Plus long que le réflexe IA, sans tomber dans le pavé :
- fiction : 11 à 16 mots en moyenne, **jamais plus de 18** (zone humaine 9-18 ; l'IA est à 12, mais ses phrases sont hachées autrement) ;
- pratique : 16 à 24 (zone 15-28 ; l'IA est à 14 : **trop court**) ;
- explicatif et essai : 16 à 22 (zone 14-26).

En non-fiction, 5 à 20 % des phrases dépassent 30 mots. Elles se construisent par **expansion interne**, pas par empilement de virgules. La longueur vient de quelques phrases longues bien construites, à côté de phrases moyennes et de rares courtes, et non d'un allongement uniforme de toutes les phrases.

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
- **Zones de rythme, pas alternance** (`decisions.md` §5). L'IA alterne mécaniquement court et long : l'autocorrélation de ses longueurs successives est négative. Chez l'humain, elle est positive : des séries de phrases courtes quand ça presse, des séries de longues quand on pense. La transition courte→longue coûte +0,82 point ; courte→courte rapporte −0,50.
- La variation naît de la *construction* et du *moment de la scène*, pas d'une règle d'alternance.

## E. Paragraphes

- **Ouverture** : l'IA ouvre 2 à 3 fois plus souvent un paragraphe par une phrase-choc courte. L'humain ouvre par une phrase pleine qui reprend ce qui précède : « Encore une fois… », « Ce soir-là pourtant… », « Lorsque nous avons… ».
- **Fermeture** : jamais de maxime, d'antithèse (« Ce n'est pas X : c'est Y. »), de bilan ni de promesse (« Vous verrez que… »). On finit sur un fait, un geste en cours, une question, une annonce de la suite ou une phrase qui reste ouverte.
- **Longueur irrégulière** : un long paragraphe, puis deux courts, puis un moyen. Pas de blocs de taille égale, alors que l'IA découpe en blocs réguliers.
- **Pas de balisage IA** : pas de gras, pas d'intertitres en concepts parallèles, pas de listes à puces parfaitement symétriques (sauf genre qui l'exige, comme une fiche pratique). Une liste humaine est irrégulière : un élément plus long, un autre qui casse la série.

## F. Lexique

- **Liaisons** (« ressources humaines », sous-employées par l'IA d'un facteur 4 à 10) : « lorsque », « afin de », « ainsi », « alors que », « tandis que », « dès que », « bien que », « à nouveau », « à présent », « en même temps », « de plus en plus », « grâce à », « il s'agit de », « malheureusement », « constamment », « également ».
  - Elles naissent d'un **raisonnement** : une cause, une condition, une concession, un moment. Une liaison remplace une juxtaposition existante ; on ne l'ajoute jamais par-dessus.
  - Jamais la même liaison deux fois en 300 mots, jamais deux dans la même phrase.
  - Dose : la zone du genre (fiction 3 à 12 pour 1000 mots, non-fiction 5 à 15). Si elle n'est pas atteinte sans forcer, on accepte l'écart (mesure secondaire). Les tests ont montré qu'un connecteur plaqué (« puisque » cinq fois, « malheureusement » sans raison) devient aussitôt un nouveau tic.
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
