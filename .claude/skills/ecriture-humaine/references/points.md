# Barème de points : choisir chaque mot et chaque construction

Chaque choix d'écriture coûte ou rapporte des points :
- **+ = points IA** : le choix rapproche le passage d'un texte généré par Claude ;
- **− = points humains** : il le rapproche des livres humains.

Les points sont les poids d'un modèle entraîné à distinguer des passages d'environ 45 mots, issus de livres humains et de textes Claude des mêmes genres (`references/modele_points.json`). En validation croisée groupée, il les sépare avec une AUC de 0,976. Sur des textes jamais vus :

| Indice d'humanité | médiane | plage |
|---|---|---|
| Humains | 91 | 66-100 |
| Claude brut | 10 | 7-13 |
| Claude avec la première version du skill | 72 | 30-84 |

**Mode d'emploi**
- Pendant la rédaction, on consulte ce barème pour **choisir entre deux tournures qu'on hésite à écrire**.
- Pendant la révision, `points.py` calcule les points réels du texte et classe les variantes.
- Les points mesurent la ressemblance avec ce corpus, pas la qualité. Entre deux variantes qui disent la même chose aussi bien, on prend celle qui a le moins de points IA. **Une variante plus humaine mais moins juste, moins claire ou hors voix est rejetée.**

Les valeurs sont des poids par occurrence, pour un passage ramené à 50 mots. Un poids de +1 sur un passage de 50 mots fait passer la probabilité IA d'environ 50 % à 73 %.

---

## 1. Constructions qui coûtent le plus (à éviter en priorité)

| Points | Construction | Exemple IA | Alternative humaine |
|---|---|---|---|
| +1,16 / +0,99 / +0,94 | **virgule + « et »** après un nom, un verbe ou avant un pronom | « Il ferma la porte, et il s'assit. » | « Il ferma la porte et s'assit. » |
| +0,77 | **deux-points + groupe nominal** (révélation, étiquette) | « Une seule certitude : la peur. » | « Il n'était sûr que d'une chose, il avait peur. » / « Seule la peur demeurait. » |
| +0,67 / +0,60 / +0,47 | **phrase qui finit sur « pas. »**, négation en chute | « Elle ne répondit pas. » | « Elle laissa la question sans réponse. » ou intégrer : « Elle ne répondit pas à sa question, trop occupée à… » |
| +0,66 / +0,57 / +0,56 | **adverbes en grappe ou détachés** (« lentement, presque doucement, ») | « Il avançait lentement, prudemment, » | « Il avançait avec la prudence d'un chat » / un seul adverbe intégré |
| +0,64 | **phrase qui finit sur un nom nu** (« …la porte. » après une construction plate) | « Il regarda la porte. » | « Il regarda la porte du garage, toujours entrouverte. » |
| +0,59 / +0,54 | **prénom en tête de phrase suivi du verbe ou d'un point** (« Léa. », « Marc regarde ») | « Clara se tut. » | « Clara, elle, se tut. » est pire ; préférer « Ma sœur se tut. » (possessif) |
| +0,57 / +0,53 / +0,51 | **phrase ouverte par « Elle + verbe », « Il + pronom », « Pronom + auxiliaire »** en série | « Elle sourit. Elle se lève. Il l'a vue. » | varier : complément en tête, possessif, subordonnée |
| +0,55 | **« ce n'est pas un… »** (« est pas DET ») | « Ce n'est pas un caprice. » | affirmer la chose : « Il s'agit d'une tempête. » |
| +0,54 | **« , ou »** après un nom | « un regard, ou une absence » | « un regard ou plutôt une absence » / choisir |
| +0,54 / +0,48 | **virgule + préposition** ou **virgule + subordonnant** en rajout | « …, dans la cuisine », « …, quand il rentre » | intégrer le complément sans virgule ou le déplacer en tête |

## 2. Constructions qui rapportent le plus (à privilégier quand elles sont justes)

| Points | Construction | Exemple |
|---|---|---|
| −0,75 / −0,73 / −0,67 | **phrase qui finit sur « ! » ou « … »** (voix vive, en fiction) | « Quelle idiote ! » ; « Si seulement il avait su… » |

> **Attention, biais connu du barème.** Les fins en « ! » et « … » sont si bien notées que la sélection par variantes les multiplie. Lors du test, les exclamations sont passées de 3 à 10 dans une scène de 1 000 mots. Plafonds, quel que soit le score : **en narration, au plus 1 exclamation pour 300 mots** (code E1 du diagnostic), et **au plus un « … » par paragraphe**. Au-delà, c'est un nouveau tic. On prend alors une autre construction humaine du tableau : possessif, verbes coordonnés, adjectif antéposé.
| −0,62 / −0,45 | **pronom + auxiliaire + adverbe** (« je n'ai jamais », « il a déjà ») | « Je n'ai jamais aimé ce quartier. » |
| −0,61 / −0,50 | **adjectif avant le nom** et **nom encadré d'adjectifs** | « une sale petite manie », « un énorme malentendu » |
| −0,57 / −0,52 / −0,49 | **verbes coordonnés par « et »** (sujet partagé) | « Il enjambe les débris et marche sur le verre. » |
| −0,57 / −0,52 | **nombre + nom en tête ou après « de »** (un fait chiffré utile, pas un accessoire) | « Deux semaines plus tard » ; « une perte de 100 euros » |
| −0,56 | **phrase ouverte par préposition + nom** | « Sans nouvelles depuis mardi, elle… » ; « À force de patience… » |
| −0,54 | **réplique ouverte par un adverbe** | « — Évidemment qu'il ment ! » |
| −0,54 / −0,53 / −0,45 | **nom + adjectif + « et »**, **déterminant + nom + « et »** (coordination nominale sans virgule) | « une voix rauque et lasse » ; « la peur et la honte » |
| −0,50 | **« Mais » + adverbe en tête** | « Mais jamais il ne l'avouerait. » |
| −0,48 / −0,46 | **nom + complément du nom** (« de », « du ») | « le grincement de la porte du garage » |
| −0,46 / −0,43 | **« si vous » + verbe**, **« vous » + deux verbes** (adresse directe concrète, non-fiction) | « Si vous sentez la colère monter, laissez-la… » |
| −0,44 | **nom + « qui » + pronom** (relative dense) | « l'homme qui lui avait menti » |
| −0,41 | **deux-points + guillemets + nom propre** (citation attribuée, non-fiction) | « Comme l'écrit Rosenberg : « … » » |

## 3. Mots-outils

| IA (+) | Humain (−) |
|---|---|
| **avant** +0,79 · **on** +0,77 · **certain(s)** +0,66 · **celui/celle** +0,60 · **lui / elle** (spaCy les ramène au même lemme ; surtout « Elle » en tête de phrase) +0,56 · **autre** +0,52 · **sans** +0,49 · **quand** +0,48 · **pendant** +0,44 · **lui-même** +0,41 · **dehors** +0,40 · **parce que** +0,40 · **ni** +0,38 · **quelque** +0,36 · **un/une** +0,36 · **chaque** +0,22 | **mon/ma/mes** −0,85 · **-t-** (inversion « dit-il », « répond-elle ») −0,49 · **son/sa/ses** −0,48 · **notre/nos** −0,47 · **leur(s)** −0,47 · **me** −0,46 · **et** −0,46 · **comme** −0,41 · **moi** −0,40 · **te** −0,35 · **mais** −0,31 · **aucun** −0,30 · **ton/ta/tes** −0,29 · **car** −0,24 · **lequel** −0,23 · **selon** −0,21 · **après** −0,21 · **si** −0,20 |

**Règles qui en découlent**
1. **Le possessif plutôt que l'article** quand le lien existe : « sa main » plutôt que « la main », « notre fils » plutôt que « l'enfant ». L'IA écrit au défini et à l'indéfini, l'humain rattache les choses aux gens.
2. **« Quand » → « lorsque »** ou une autre construction. **« Avant de » → « avant que » / « en attendant de » / reformulation.** **« Parce que » → « car »**, ou supprimer la causalité explicite.
3. **« Celui qui », « certains », « chaque »** (généralités) : préférer un sujet précis.
4. **« On »** : voir `revision.md` R-VOIX.
5. **« Sans »** en série (« sans un mot », « sans bruit », « sans le regarder ») : le remplacer par une construction positive.
6. Le **pronom personnel complément de 1re et 2e personne** (« me », « te », « moi ») est humain : le narrateur s'implique.

## 4. Mots de contenu (biais cohérent dans les trois genres)

| IA (+) | Humain (−) |
|---|---|
| adulte +0,80 · **poser** (une limite, une main, une question) +0,79 · **enfin** +0,76 · écran +0,70 · service +0,66 · changer +0,62 · **reconnaître** +0,60 · **phrase** +0,56 · an +0,56 · différence +0,56 · demander +0,52 · répondre +0,52 · dossier +0,51 · soir +0,47 · **regarder** +0,47 · ancien +0,46 · semaine +0,45 · **concret** +0,45 · porte +0,45 · **simplement** +0,44 · **exister** +0,44 · mois +0,44 · compter +0,40 · matin +0,39 · traverser +0,37 · zone +0,37 · **voir** +0,37 · utile +0,36 · se taire +0,35 · construire +0,34 | exemple −0,69 · **tel** −0,68 · conscience −0,56 · devoir −0,48 · mauvais −0,42 · considérer −0,40 · heureux −0,38 · manquer −0,38 · **voilà** −0,38 · adorer −0,36 · état −0,35 · pensée −0,34 · affecter −0,34 · **totalement** −0,33 · atteindre −0,32 · apprécier −0,31 · supérieur −0,30 · influencer −0,29 · **grâce à** −0,28 · créer −0,27 · responsabilité −0,27 · bonheur −0,27 · intérêt −0,26 |

**Lecture.** L'IA décrit des gestes neutres (regarder, poser, répondre, demander, traverser, se taire) dans un décor horodaté (matin, soir, semaine, mois, an). L'humain emploie des verbes de jugement et d'état (considérer, apprécier, adorer, manquer, devoir), des mots de valeur (mauvais, heureux, supérieur, bonheur) et des démonstratifs d'insistance (« tel », « voilà »).
- Remplacer un **geste neutre** par un geste qui juge : « il la regarde » → « il la toise », « il l'épie », « il la dévore des yeux ».
- Remplacer un **horodatage** par une durée vécue : « ce matin-là » → « au réveil », ou rien.

## 5. Marqueurs (par occurrence)

- **Accessoires** de fausse concrétude : **+1,15**
- **Formules IA** : **+1,01**
- **Contrastes correctifs** : **+0,38**
- **Liaisons humaines** (« lorsque », « afin de », « ainsi », « grâce à »…) : **−1,38**, le choix le plus rentable du barème, **à condition qu'elles portent un vrai lien logique** (sinon elles deviennent un tic, voir `construction.md` §F)

## 6. Forme des phrases

Phrase ≥ 30 mots : +0,39. Ce n'est pas la longueur qui coûte, c'est la phrase longue *empilée* (virgules, appositions). Une phrase longue construite par subordination et compléments du nom rapporte par ses constructions internes.

---

## Procédure de choix par points (étape 6, passe 5)

1. `python3 scripts/points.py atelier/v2.md` → indice d'humanité, passages (fenêtres) au-dessus du seuil, phrases les plus « IA », choix qui coûtent.
2. Pour **chaque passage** sous 50 d'humanité et chacune des **8 phrases** les plus « IA » : écrire **3 variantes** dans `atelier/variantes-N.md`, séparées par `---`. On garde la première version en tête pour comparer. Chaque variante change la *construction*, pas seulement un mot : ordre, possessif, coordination, subordination, ponctuation, ouverture, verbe qui juge.
3. `python3 scripts/points.py --variantes atelier/variantes-N.md` → classement.
4. **Règle de choix stricte** : retenir la variante la mieux notée **parmi celles qui** :
   - (a) gardent le sens exact ;
   - (b) restent dans la voix de la fiche ;
   - (c) se lisent d'une traite ;
   - (d) ne créent pas de nouveau signalement dans `diagnostic.py`.

   Si la mieux notée échoue à l'un des critères, prendre la suivante, et noter le motif en une ligne dans `atelier/choix.md`. Si aucune variante ne bat l'original de 10 points d'humanité au moins, garder l'original.
5. Relancer `points.py` sur le texte complet. **Cible : indice d'humanité ≥ 78** (atteint par 90 % des extraits humains) **et au plus 25 % des fenêtres au-dessus du seuil.** Au plus deux tours de variantes, sinon accepter.
