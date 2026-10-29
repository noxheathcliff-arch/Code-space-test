# Points de décision : ce que les humains choisissent, phrase après phrase

Chaque phrase oblige l'auteur à trancher : comment l'ouvrir, comment la relier à la précédente, combien de propositions y mettre, sur quoi la finir, quelle longueur après la précédente. Ces choix ont été mesurés par analyse syntaxique complète (spaCy) :
- **humains** : ≈ 820 000 mots de 9 livres (4 romans, 3 livres pratiques, 2 livres de vulgarisation) ;
- **IA** : 146 textes Claude dans les mêmes genres.

Les points de chaque choix viennent du modèle (`modele_points.json`, validé « livre tenu à l'écart », AUC 0,937). Lire ce fichier **avant de rédiger** : ce sont les réflexes à acquérir.

---

## 1. Ouvrir la phrase

Ouvertures des phrases de narration, en % :

| Ouverture | Fiction H | Fiction IA | Pratique H | Pratique IA | Explicatif H | Explicatif IA |
|---|---|---|---|---|---|---|
| **pronom sujet** (Il, Elle, Je…) | **24,8** | **43,9** | 26,2 | 31,4 | 17,9 | 23,0 |
| groupe nominal sujet | 30,1 | 29,9 | 24,4 | 30,4 | 29,1 | 35,7 |
| **complément prépositionnel** (« Au bout de… ») | **9,9** | 5,5 | 10,7 | 7,2 | 13,8 | 9,8 |
| nom propre | 12,0 | 8,1 | 2,6 | 2,6 | 4,2 | 4,5 |
| **adverbe** | **6,7** | 3,6 | 7,9 | 4,4 | 7,6 | 3,9 |
| connecteur (Et, Mais, Car…) | 6,2 | 4,2 | 7,7 | 6,4 | 9,2 | 7,5 |
| subordonnée (Lorsque, Si…) | 2,6 | 0,9 | 5,5 | 4,7 | 5,4 | 5,1 |
| adjectif / participe en tête | 3,1 | 0,4 | 2,6 | 0,8 | 3,1 | 1,1 |

**Règle.** En fiction, au plus **une phrase de narration sur quatre** commence par un pronom sujet. Les autres ouvertures tournent entre :
- un complément (« Au bout du couloir, », « Depuis l'enterrement, ») ;
- un adverbe (« Évidemment, », « Pourtant ») ;
- un nom propre plutôt que « il » ;
- un adjectif ou un participe détaché (« Furieuse, elle… », « Arrivé au col, il… ») ;
- une subordonnée.

## 2. Relier la phrase à la précédente

| Lien avec la phrase précédente | Fiction H | Fiction IA | Pratique H | Pratique IA | Explicatif H | Explicatif IA |
|---|---|---|---|---|---|---|
| **juxtaposition** (autre sujet, autre angle) | **66,1** | **49,0** | 55,0 | 54,8 | 61,8 | 59,7 |
| **« Je / Tu / On / Nous / Vous » en tête, d'une phrase à l'autre** (« Je… Je… ») | **6,3** | **17,4** | 9,8 | 10,0 | 5,8 | 4,0 |
| **anaphore** (Il, Elle, Ce, Cela, Ça en tête) | **17,5** | **24,5** | 13,8 | 23,3 | 11,3 | 20,4 |
| **reprise lexicale** (le nom est répété) | 3,8 | 4,8 | **13,6** | 5,4 | **11,7** | 8,2 |
| connecteur explicite | 6,3 | 4,3 | 7,8 | 6,5 | 9,4 | 7,6 |

**Règles**
- **Fiction : changer d'angle à chaque phrase.** L'IA suit un seul sujet (« Je me lève. J'ouvre. Il me regarde. Il sourit. »). L'humain passe de la personne à l'objet, du lieu à un tiers, puis revient. Points : même pronom en tête +0,30, anaphore (Il/Elle/Cela en tête) +0,26, juxtaposition −0,06.
- **Non-fiction : répéter le nom-clé plutôt que le pronom.** « L'estime de soi… Cette estime… » au lieu de « L'estime de soi… Elle… Cela… ». Les auteurs humains répètent leur objet 2 à 3 fois plus que l'IA (reprise lexicale −0,09).

## 3. Densité de la phrase (verbes conjugués)

| Verbes conjugués par phrase | Pratique H | Pratique IA | Explicatif H | Explicatif IA |
|---|---|---|---|---|
| 1 | 29,7 | 39,1 | 31,4 | 38,5 |
| **4 et plus** | **16,6** | 8,9 | 13,1 | 13,1 |

**Règle (non-fiction).** Les humains bâtissent des phrases à plusieurs propositions, articulées par subordination et relatives (« Lorsque l'enfant comprend que ce qu'il ressent a un nom, il peut… »). L'IA aligne des phrases à un seul verbe. Une phrase sur six peut porter quatre verbes conjugués **si elle reste lisible d'une traite**.

## 4. Finir la phrase

| Fin de phrase | Fiction H | Fiction IA | Pratique H | Pratique IA | Explicatif H | Explicatif IA |
|---|---|---|---|---|---|---|
| **sur une négation** (« …pas. », « …rien. », « …jamais. ») | **1,9** | **6,2** | 1,2 | 1,9 | 1,1 | 1,4 |
| sur un verbe | 16,1 | 20,3 | 16,3 | 20,9 | 13,6 | 22,1 |
| sur un nom propre | 7,1 | 2,9 | 1,8 | 0,5 | 2,4 | 0,9 |
| sur un adjectif | 12,8 | 11,5 | 18,2 | 19,4 | 20,2 | 16,9 |

| Ponctuation finale | Fiction H | Fiction IA | Pratique H | Pratique IA | Explicatif H | Explicatif IA |
|---|---|---|---|---|---|---|
| point | 89,4 | **98,3** | 81,7 | 86,5 | 69,0 | **96,0** |
| ? | 4,5 | 1,2 | 6,6 | 5,1 | 7,9 | 2,3 |
| … | 2,5 | 0,1 | 1,4 | 0,0 | 4,1 | 0,1 |
| ! | 1,5 | 0,0 | 3,8 | 0,1 | 2,1 | 0,3 |

Points : « … » −0,93 ; « ! » −0,75 ; fin sur nom propre −0,23 ; fin sur adjectif −0,21 ; point final +0,63 ; fin sur verbe +0,17.

**Règles**
- **Ne pas finir sur « pas. »** : au plus une phrase sur cinquante. L'IA ferme ses phrases par la négation (« Elle ne répondit pas. »). On reformule en positif ou on déplace la négation (« Elle garda sa réponse pour elle. »).
- **Finir sur le nom ou l'adjectif qui porte le sens**, plutôt que sur un verbe nu.
- **Varier la ponctuation finale** : 5 à 15 % de phrases finissent par « ? », « … » ou « ! » chez l'humain, contre 1 à 2 % chez l'IA. En non-fiction, ce sont surtout des **questions** adressées au lecteur. Plafonds : `construction.md` §A5 et code E1.

## 5. Enchaîner les longueurs (rythme)

L'idée reçue veut qu'il faille « alterner phrases longues et courtes ». **C'est exactement ce que fait l'IA**, et c'est un marqueur.

| Mesure | Humain | IA |
|---|---|---|
| Autocorrélation des longueurs successives | **+0,05 à +0,11** (zones) | **−0,04 à −0,12** (alternance) |
| Transition courte → longue (points) | | **+0,82** |
| Transition moyenne → longue | | **+0,59** |
| Transition courte → courte | **−0,50** | |
| Transition moyenne → courte | **−0,31** | |
| Longue → longue (pratique) | **20,8 %** | 2,9 % |
| Moyenne → moyenne (pratique) | 16,8 % | **26,6 %** |

**Règles**
- Écrire par **zones de rythme**, pas par alternance. Une série de phrases courtes quand l'action presse, une série de longues quand on réfléchit ou décrit, puis on change de zone. On ne « casse » pas chaque phrase longue par une courte.
- **Jamais une phrase courte suivie immédiatement d'une longue** comme effet de contraste systématique.
- **Seule exception : l'entrée et la sortie d'un pic émotionnel** (`emotion-scene.md` §1). La contraction au pic, puis le retour à la longueur normale, créent deux transitions de longueur. Elles sont voulues, mais il n'y en a qu'une ou deux par scène. Ailleurs, on reste dans sa zone.
- En non-fiction, **enchaîner les phrases longues de raisonnement** (deux, trois d'affilée) est humain. La monotonie IA, c'est la longueur moyenne répétée.

Le diagnostic mesure l'autocorrélation (`Autocorrélation des longueurs`) : visée > 0 ; l'IA est en dessous de zéro.

## 6. Nommer

| Mesure (fiction, pour 1000 mots) | Humain | IA |
|---|---|---|
| **Noms propres** | **41,5** | 23,8 |

**Règle.** Nommer les personnes et les lieux. Au lieu de « il » pour la troisième fois, mettre le prénom ou un surnom ; au lieu de « la ville », son nom. L'IA se réfugie dans le pronom. Le 41,5 est une médiane tirée par Martin et Sapkowski. La zone humaine est de 12 à 62 pour 1000 mots, soit **un nom toutes les deux à quatre phrases**, pas un par phrase.

---

## Récapitulatif des réflexes (à copier dans la fiche, étape 3)

1. Une phrase de narration sur quatre au plus ouverte par un pronom sujet.
2. Fiction : changer d'angle d'une phrase à l'autre. Non-fiction : répéter le nom-clé.
3. Ne pas finir sur une négation ; finir sur le mot porteur.
4. 5 à 15 % de fins en « ? », « … » ou « ! », selon le genre et la voix.
5. Rythme par zones, pas par alternance ; jamais de contraste court→long par réflexe.
6. Nommer les gens et les lieux.
7. Non-fiction : oser la phrase à plusieurs propositions.
