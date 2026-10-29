# Barème de points : choisir chaque mot et chaque construction

Chaque choix d'écriture coûte ou rapporte des points :
- **+ = points IA** : le choix rapproche le passage d'un texte généré par Claude ;
- **− = points humains** : il le rapproche des livres humains.

Les points sont les poids du modèle `references/modele_points.json`, version 2 :
- **entraînement** : régression logistique sur des passages d'environ 45 mots ;
- **corpus** : 9 livres humains (≈ 820 000 mots ; 4 romans, 3 livres pratiques, 2 de vulgarisation) et 146 textes Claude des mêmes genres ;
- **validation la plus dure** : on retire un livre entier, on entraîne sur les 8 autres, on teste sur le livre inconnu (et sur des consignes IA inconnues).

| Livre tenu à l'écart | AUC | Indice d'humanité médian du livre inconnu |
|---|---|---|
| Mercier, André et Lelord, Guerrieri, Trône de fer | 0,96 | 84-91 |
| Ansembourg, Siegel, Witcher, Giacomello | 0,93-0,95 | 82-88 |
| Fargetton (roman YA contemporain, phrases courtes au présent) | 0,84 | 56 |
| **Moyenne** | **0,937** | textes Claude inconnus : 13-21 |

Le modèle final est entraîné sur les 9 livres, ce qui inclut le style de type Fargetton.

**Mode d'emploi**
- Pendant la rédaction, consulter ce barème pour **choisir entre deux tournures** ; pendant la révision, `points.py` calcule les points réels et classe les variantes.
- Les points mesurent la ressemblance avec ces livres, pas la qualité. **Une variante plus « humaine » mais moins juste, moins claire ou hors voix est rejetée.**
- Valeurs : poids par occurrence, pour un passage ramené à 50 mots.

---

## 1. Constructions qui coûtent le plus

| Points | Construction | Exemple IA | Alternative humaine |
|---|---|---|---|
| **+1,07 / +0,81 / +0,81** | virgule + « et » (après verbe, adjectif, nom) | « Il ferma la porte, et s'assit. » | « Il ferma la porte et s'assit. » |
| **+0,89** | phrase réduite à un nom propre | « Léa. » | l'intégrer : « C'était Léa, évidemment. » |
| **+0,82 / +0,59** (rythme) | **phrase courte puis phrase longue** ; moyenne puis longue | « Il attendit. Puis, lorsque le train entra enfin en gare dans un grand fracas de freins, il… » | rester dans la zone : courte puis courte, ou longue puis longue (`decisions.md` §5) |
| **+0,63** (décision) | **phrase finie par un point**, toujours le même | 98 % de « . » | 5 à 15 % de « ? », « … », « ! » selon le genre |
| +0,62 | « nom, ou… » | « un regard, ou une absence » | « un regard ou plutôt une absence » |
| +0,61 / +0,55 / +0,50 | réplique ouverte par « — Vous », « — Alors », « — Le… » | « — Alors, vous restez ? » | ouvrir sur le cœur de la réplique : « — Vous restez, du coup ? » |
| +0,58 / +0,53 | **deux-points après un nom** (révélation, étiquette) | « Une certitude : la peur. » | « Il n'était sûr que de sa peur. » |
| +0,54 | « ce n'est pas un… » | « Ce n'est pas un caprice. » | affirmer la chose |
| +0,52 / +0,44 | « est + adverbe + déterminant », « est plus + adjectif » (comparaisons explicatives) | « C'est souvent le signe… » | « Le signe ne trompe pas : … » ou le fait lui-même |
| +0,49 | **« on » après un nom ou un pronom** | « Ce qu'on ressent… » | « Ce que nous ressentons » / sujet précis |
| +0,48 / +0,43 | virgule + préposition ou subordonnant en rajout | « …, dans la cuisine », « …, quand il rentre » | intégrer sans virgule |
| +0,30 / +0,26 (décision) | **même pronom en tête d'une phrase à l'autre** ; **Il/Elle/Cela** en tête | « Je… Je… », « Il… Il… » | changer d'angle (`decisions.md` §2) |
| +0,17 | finir sur un verbe | « …qu'il ne pouvait plus supporter. » | finir sur le mot porteur |

## 2. Constructions qui rapportent le plus

| Points | Construction | Exemple |
|---|---|---|
| **−0,93 / −0,75** (décision) | phrase finie par « … » ou « ! » | « Si seulement il avait su… » ; « Quelle idiote ! » (plafonds §7) |
| −0,62 / −0,52 | ponctuation forte en fin de réplique, « … » après un nom | « — Et après ? », « Le silence… » |
| −0,58 | groupe nominal suivi d'un tiret (incise ou réplique coupée) | « la vieille – celle du fond – » |
| −0,53 / −0,40 | **nom propre en apposition ou en incise** | « …le chevalier, Ser Rodrik, … » |
| −0,50 / −0,31 (rythme) | **courte puis courte**, moyenne puis courte (zone de tension) | « Il se tait. Elle aussi. » |
| −0,48 | nom encadré d'adjectifs | « une petite ville morne » |
| −0,47 / −0,35 | virgule + pronom + verbe (proposition enchaînée) | « …, elle le savait » |
| −0,43 / −0,36 | complément du nom, relatives denses | « la fille du forgeron », « l'homme qui lui avait menti » |
| −0,40 / −0,34 | coordination nominale et verbale sans virgule | « la peur et la honte » ; « il se leva et sortit » |
| −0,31 (décision) | **phrase ouverte par un participe** | « Arrivé au col, il… » |
| −0,23 / −0,21 (décision) | finir sur un nom propre ou un adjectif | « …vers Winterfell. » ; « …encore tiède. » |

## 3. Mots-outils

| IA (+) | Humain (−) |
|---|---|
| **quand** +0,78 · **certain(s)** +0,60 · **on** +0,57 · **avant** +0,49 · **parce que** +0,42 · **dès** +0,42 · **celui/celle** +0,40 · **pendant** +0,39 · **quelque** +0,35 · **sans** +0,34 · **quoi** +0,33 · **un/une** +0,30 · **ni** +0,30 · **chacun** +0,28 · **dont** +0,28 · **même** +0,28 · **rien** +0,26 · **beaucoup** +0,22 | **inversion -t-** (« dit-il », « murmura-t-elle ») −0,81 · **leur** −0,45 · **ceci** −0,40 · **tout** −0,39 · **son/sa/ses** −0,37 · **mon/ma/mes** −0,36 · **cela** −0,35 · **lequel** −0,33 · **nous** −0,33 · **comme** −0,33 · **parmi** −0,32 · **moi** −0,28 · **mais** −0,27 · **aucun** −0,26 · **car** −0,23 · **selon** −0,22 · **me** −0,21 · **et** −0,20 |

**Règles**
1. **Possessif plutôt qu'article** : « sa main » plutôt que « la main », « notre fils » plutôt que « l'enfant ».
2. **« Quand » → « lorsque »**, « au moment où », « dès que », ou une proposition participiale. « Parce que » → « car », ou supprimer la causalité.
3. **« Celui qui », « certains », « chacun »** (généralités) : préférer un sujet précis.
4. **« Sans »** en série (« sans un mot », « sans bruit ») : construction positive.
5. **« -t- »** : les incises inversées (« répliqua-t-il ») sont humaines, à condition que le verbe soit d'attitude (`construction.md` §I).

## 4. Mots de contenu (biais cohérent dans tous les genres)

| IA (+) | Humain (−) |
|---|---|
| **poser** +1,04 · **regarder** +0,80 · **demander** +0,71 · **matin** +0,71 · **phrase** +0,69 · **tenir** +0,68 · place +0,57 · ancien +0,57 · retard +0,56 · **voix** +0,53 · **enfin** +0,53 · mentir +0,52 · apprendre +0,51 · an +0,51 · construire +0,51 · **simplement** +0,50 · écran +0,50 · se taire +0,49 · dire +0,49 · semaine +0,46 · réflexe +0,45 · garder +0,45 · rester +0,44 · changer +0,42 · repas +0,41 · café +0,39 · réparer +0,39 · raconter +0,37 · traverser +0,34 · effacer +0,34 · geste +0,29 | **exemple** −0,73 · nouveau −0,64 · devoir −0,56 · conscience −0,54 · état −0,46 · **tel** −0,45 · considérer −0,45 · tant −0,42 · **tellement** −0,41 · œil −0,39 · atteindre −0,39 · occasion −0,34 · pensée −0,34 · tenter −0,32 · rêve −0,32 · ombre −0,32 · **comment** −0,31 · amour −0,30 · **certainement** −0,29 · **bientôt** −0,28 · sentiment −0,27 · apprécier −0,27 · vie −0,26 · liberté −0,26 · bonheur −0,26 · **grâce à** −0,26 · **voilà** −0,24 · **cependant** −0,22 |

**Lecture.**
- **Le monde de l'IA** est fait de gestes neutres (poser, regarder, tenir, garder, traverser), de paroles (demander, dire, voix, phrase, se taire) et d'un décor horodaté (matin, semaine, an, retard, repas, café).
- **Le monde humain** est fait de jugements et d'états (considérer, devoir, apprécier, conscience, état, pensée), d'intensifs (tel, tant, tellement, certainement) et d'abstractions assumées (amour, liberté, bonheur, vie, rêve).
- **Pour passer de l'un à l'autre** :
  - remplacer un geste neutre par un geste qui juge ou ressent ;
  - remplacer un horodatage par une durée vécue ;
  - oser le mot abstrait juste.

## 5. Marqueurs

Par occurrence :
- **liaisons humaines** (« lorsque », « afin de », « ainsi », « grâce à »…) : **−1,05**, à condition de porter un vrai lien logique ;
- **formules IA** : +0,81 ;
- **accessoires** : +0,60 ;
- **contrastes correctifs** : +0,42.

## 6. Émotion

Points : mots du corps −0,11, émotions nommées +0,04. Le modèle les pénalise peu. Les écarts mesurés sont ailleurs : les romans humains **nomment** deux fois plus les émotions (4,3 contre 2,2 pour 1000 mots), et l'IA décrit plus le corps et multiplie les verbes mentaux (voir `emotion-scene.md`).

## 7. Biais connus du barème (plafonds, quel que soit le score)

- **« ! » et « … » en narration** : au plus 1 « ! » pour 300 mots hors répliques (code E1), au plus un « … » par paragraphe. Lors d'un test, la sélection par variantes a fait passer les exclamations de 3 à 10.
- **Noms propres** : nommer davantage, mais pas un nom par phrase.
- **Phrases courtes en série** : la transition courte→courte est bien notée, mais la part de phrases ≤ 5 mots reste plafonnée par `construction.md` §D.

---

## Procédure de choix par points (étape 6, passe 5)

1. `python3 scripts/points.py atelier/v2.md` → indice d'humanité, passages (fenêtres) au-dessus du seuil, phrases les plus « IA », choix qui coûtent.
2. Pour **chaque passage** sous 50 d'humanité et chacune des **8 phrases** les plus « IA » : écrire **3 variantes** dans `atelier/variantes-N.md`, séparées par `---`. On garde la première version en tête pour comparer. Chaque variante change la *construction*, pas seulement un mot : ouverture, angle, possessif, coordination, subordination, fin de phrase, ponctuation finale, verbe qui juge.
3. `python3 scripts/points.py --variantes atelier/variantes-N.md` → classement par solde de points.
4. **Règle de choix stricte** : retenir la variante la mieux notée **parmi celles qui** :
   - (a) gardent le sens exact ;
   - (b) restent dans la voix de la fiche ;
   - (c) se lisent d'une traite ;
   - (d) ne créent pas de nouveau signalement dans `diagnostic.py` ;
   - (e) respectent les plafonds du §7.

   Si la mieux notée échoue, prendre la suivante, et noter le motif en une ligne dans `atelier/choix.md`. Si aucune variante ne bat nettement l'original, garder l'original.
5. Relancer `points.py` sur le texte complet. **Cible : indice d'humanité ≥ 78 et au plus 25 % de fenêtres au-dessus du seuil.** Au plus deux tours de variantes, sinon accepter.
