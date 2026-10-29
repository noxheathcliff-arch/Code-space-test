---
name: ecriture-humaine
description: Pipeline strict d'écriture et de révision en français pour produire une prose dont la fabrication ressemble à celle d'auteurs humains (roman, nouvelle, scène, dialogue, essai, article, chronique, développement personnel, vulgarisation, livre entier). Cadrage, choix de matière, rédaction selon une grammaire calibrée sur des livres humains, système de points par mot et par construction, diagnostic chiffré, révision en passes ordonnées avec sélection de variantes notées, jugement adverse et portes de validation. À utiliser dès qu'il faut écrire ou réécrire un texte destiné à être lu comme humain, « humaniser » un texte généré par IA, ou réviser un manuscrit long.
---

# Écriture humaine : pipeline

Ce skill impose une **procédure**, pas une liste d'astuces. Chaque étape produit un livrable écrit et se termine par une **porte** : on ne passe pas à l'étape suivante tant que la porte n'est pas franchie.

Les règles chiffrées et les points viennent d'une calibration :
- **corpus** : 9 livres humains (≈ 820 000 mots : 4 romans, 3 livres pratiques, 2 de vulgarisation) et 146 textes générés par Claude dans les mêmes genres ;
- **validation** : livre entier tenu à l'écart et textes jamais vus (voir `references/donnees-calibration.md`).

## Ce qu'il faut savoir avant de commencer

1. **La signature IA en français n'est pas celle qu'on croit.** Les conseils habituels (« phrases courtes », « pas d'adverbes », « du concret », « montrer plutôt qu'expliquer ») poussent le texte *vers* le profil IA. Ce qui est mesuré chez l'IA :
   - 1,5 à 1,8 fois plus de virgules, avec une virgule avant « et » ;
   - 2 à 3 fois plus de deux-points ;
   - 3 à 6 fois plus de « on » ;
   - plus de phrases très courtes ;
   - moins d'adjectifs, de possessifs, de prépositions et de subordination ;
   - presque aucune liaison classique (« lorsque », « afin de », « ainsi ») ;
   - un concret simulé par des **accessoires** (nombres en lettres, jours, horaires, cuisine, café, téléphone) : ×3 à ×9 ;
   - un **rythme par alternance** court/long (autocorrélation négative), là où l'humain écrit par zones ;
   - 44 % de phrases de fiction ouvertes par un pronom sujet (humain 25 %), trois fois plus de fins sur une négation (« …ne répondit pas. »), 98 % de points finaux ;
   - moins d'émotions **nommées** que les romanciers (2,2 contre 4,3 pour 1000 mots) : l'IA sur-applique « montrer plutôt que dire ».
2. **Chaque choix a un prix.** `references/points.md` donne les points IA (+) ou humains (−) de chaque construction, mot-outil et mot. `scripts/points.py` calcule ceux du texte et classe les variantes d'une phrase.
3. **Humain ne veut pas dire négligé.** On ne fabrique jamais de fautes, de coquilles ni de désordre artificiel. On vise la *maîtrise* d'un auteur, avec ses choix assumés : phrases longues bien construites, ponctuation expressive, registre propre, jugements, images filées.
4. **Les outils signalent et classent, ils ne décident pas.** Entre deux variantes, on prend la moins « IA » **parmi celles qui gardent le sens, la voix et la clarté**. Viser 100 partout produit un autre automatisme.
5. **Aucune garantie face aux détecteurs externes.** Les points sont ceux du modèle du skill, pas de Pangram. L'évaluation se fait avec `eval/protocole.md`, jamais sur un texte isolé.

## Outils (depuis le dossier du skill ; Python 3 + spaCy : `pip install spacy` puis `python -m spacy download fr_core_news_md`)

| Commande | Rôle |
|---|---|
| `python3 scripts/diagnostic.py T.md --genre G --cible N [--avant T0.md]` | profil stylométrique contre la zone humaine du genre, phrases signalées (codes V1 à R1), **PORTE 6 calculée** |
| `python3 scripts/points.py T.md` | indice d'humanité (0-100), passages et phrases les plus « IA », mots et constructions qui coûtent ou rapportent |
| `python3 scripts/points.py --variantes V.md` | classe des variantes (séparées par `---`) par solde de points |
| `python3 scripts/points.py --mot lemme…` | points d'un mot |
| `python3 scripts/diagnostic.py --dossier chapitres/ --genre G` | long format : tableau par chapitre et tics transversaux |
| `scripts/construire_profil.py`, `scripts/entrainer_modele.py` | recalibrer sur d'autres textes humains (voir README) |
| `python3 scripts/typo_fr.py T.md S.md` | typographie française d'édition (étape 8) |

**Genres de profil** :
- `fiction` : roman, nouvelle, scène, récit ;
- `pratique` : développement personnel, guide ;
- `explicatif` : vulgarisation, pédagogie ;
- `essai` : essai, article, chronique, billet.

Sans exécution de code possible : grilles manuelles de `references/revision.md` (« Mode sans script ») et barème de `references/points.md` appliqué à vue.

## Le pipeline

Travailler dans `atelier/` (fiche, matière, brouillon, rapports, variantes). Seul le texte final est livré.

### Étape 0 : Triage
Déterminer :
- le **mode** : texte neuf, révision ou humanisation, long format (plus de 4 000 mots) ;
- le **genre de profil** et la **longueur cible** ;
- les références à charger :
  - `genres/fiction.md` (contient le dialogue) et `emotion-scene.md` ;
  - ou `genres/non-fiction.md` ;
  - ou `genres/conversation.md` pour un message, une réponse courte, une explication rapide (mode conversation : pas de pipeline lourd) ;
  - plus `genres/long-format.md` si le texte est long.

**Porte 0** : ces décisions sont écrites en tête de `atelier/fiche.md`.

### Étape 1 : Cadrage → `atelier/fiche.md`
Fiche de `references/cadrage.md` :
- le lecteur et ce qu'il sait ;
- l'intention ;
- le **contrat de voix** : personne, temps, registre, ponctuation expressive, expressions figées, longueur de phrase, jugement, humour ;
- trois non-dits ;
- les fins interdites ;
- le plan : ordre de révélation, plan asymétrique, ouverture et fermeture de chaque paragraphe.

**Porte 1** : chaque champ est une décision concrète.

### Étape 2 : Matière → `atelier/matiere.md`
`references/matiere.md` :
- **3 à 5 choix clés**, chacun avec 4 options classées du plus au moins attendu, et le choix d'une option non attendue mais juste ;
- **tri anti-accessoires** ;
- **fiction** : verdicts du narrateur sur les personnes ;
- **non-fiction** : ancrage réel.

**Ne jamais inventer** de source, de chiffre ni d'anecdote présentée comme réelle. Ce qui manque est marqué `[À FOURNIR : …]`.

**Porte 2** : chaque élément retenu répond à « pourquoi celui-ci et pas le plus probable ? ».

### Étape 3 : Lecture de la grille de choix
Lire `references/decisions.md`, `references/construction.md` et `references/points.md` **avant d'écrire la première phrase**. En fiction, planifier aussi l'arc émotionnel de la scène selon `emotion-scene.md` (montée calme, pic contracté, retour au calme). Les retenir sous forme de réflexes :
- possessif plutôt qu'article ;
- verbes coordonnés par « et » sans virgule ;
- pas de deux-points de révélation ;
- liaison logique réelle plutôt que juxtaposition ;
- adjectif évaluatif avant le nom ;
- ouverture de phrase par un complément ou une subordonnée ;
- verbe qui juge plutôt que geste neutre ;
- aucune phrase qui finit sur « pas. » ;
- pas de « on » générique ;
- une phrase de narration sur quatre au plus ouverte par un pronom sujet ; changer d'angle d'une phrase à l'autre ;
- rythme par zones, jamais d'alternance court→long par réflexe ;
- nommer les gens et les lieux ; en non-fiction, répéter le nom-clé plutôt que « cela ».

**Porte 3** : écrire dans la fiche les 5 réflexes du barème les plus pertinents pour ce texte.

### Étape 4 : Rédaction → `atelier/brouillon.md`
Rédiger d'un seul tenant en appliquant la grammaire et le barème. **À chaque hésitation entre deux tournures, prendre celle qui a le moins de points IA dans `points.md`.**
- **Longueur** : viser la cible + 10 % (la révision coupe). Il manque presque toujours de la *matière*, pas des mots.
- **Long format** : par scène ou par chapitre (`long-format.md`).

**Porte 4** : brouillon complet, longueur entre la cible et la cible + 15 % (`wc -w`). Pas de révision du style pendant la rédaction.

### Étape 5 : Double diagnostic → `atelier/rapport-1.md`
Lancer :
```
diagnostic.py atelier/brouillon.md --genre G --cible N
points.py atelier/brouillon.md
```
Lire :
- les ✗ et ⚠ (primaires d'abord) ;
- les phrases signalées ;
- les passages et phrases les plus « IA » selon les points ;
- les choix qui coûtent le plus.

Un signalement n'est pas une interdiction : un nombre ou une formule **nécessaire** se garde.

**Porte 5** : les deux rapports sont enregistrés.

### Étape 6 : Révision en cinq passes ordonnées → `atelier/v2.md`
Règles de chaque passe dans `references/revision.md` :
1. **Architecture** (R-ARCH) : ouvertures et fermetures de paragraphes, gloses, maximes, symétries.
2. **Syntaxe et ponctuation** (R-PONCT, R-SYNT, R-RYTH, R-OUV) : codes V1, V2, P1, C1, C2, O1, O2, S3, R1.
3. **Lexique et voix** (R-LEX, R-VOIX, R-LIAIS) : codes L1, L2, L3, S1 ; possessifs, adjectifs, liaisons réelles.
4. **Expressivité** (R-EXPR) : ponctuation expressive, incises d'attitude.
5. **Sélection par points** (`points.md`, dernière section) :
   - pour chaque passage sous 50 d'humanité et pour les 8 phrases les plus « IA », écrire **3 variantes de construction** dans `atelier/variantes-N.md` ;
   - les classer avec `points.py --variantes` ;
   - **règle de choix stricte** : la mieux notée parmi celles qui gardent le sens, la voix, la lisibilité, sans créer de nouveau signalement. Sinon la suivante, avec le motif noté dans `atelier/choix.md`. On garde l'original si aucune variante ne le bat nettement ;
   - au plus deux tours.

Règles transversales :
- modifications **locales** ;
- sens et faits intacts ;
- toute modification moins claire ou moins juste est annulée ;
- **piège n° 1** : les fusions allongent les phrases au-delà de la zone humaine, d'où le plafond ⚠ de longueur ;
- les mesures **secondaires** (adjectifs, prépositions, coordination, subordination, participes, adverbes, liaisons) se corrigent par la construction, jamais par ajout décoratif.

**Porte 6** : `diagnostic.py atelier/v2.md --genre G --avant atelier/brouillon.md --cible N` affiche **PORTE 6 : FRANCHIE / NON FRANCHIE**. Conditions :
- au plus 3 ✗ primaires et 5 ✗ au total ;
- au plus 1 ⚠ de sur-correction de pipeline ;
- **indice d'humanité (points) ≥ 78** et **au plus 25 % de fenêtres IA** ;
- longueur à ±10 % ;
- le % de phrases signalées est affiché à titre indicatif (repère < 45 %).

Calibration (9 livres) :

| | Fiction | Pratique | Explicatif |
|---|---|---|---|
| Extraits humains hors profils | 26 / 32 (Guerrieri 8/8, Martin 7/8, Fargetton 6/8, Sapkowski 5/8) | 5 / 7 | 7 / 8 |
| Textes Claude bruts (consignes nouvelles) | 0 / 4 | 0 / 2 | 0 / 2 |
| Première version du skill (sans la passe 5) | 3 / 4 | 0 / 2 | 0 / 2 |
| Scène livrée pour Pangram (pipeline complet) | 1 / 1 (indice 95 ; Pangram : 91 % humain sur un passage) | | |

Si la porte n'est pas franchie : une passe ciblée (v3), puis accepter et noter les écarts.

### Étape 7 : Jugement adverse → `atelier/jugement.md`
`references/jugement.md` :
1. **Lecture du détecteur** : 5 phrases les plus suspectes (croiser avec `points.py`) et liste des macro-tics.
2. **Lecture de l'éditeur** : grille fermée sur le sens, la clarté, la voix, l'absence d'invention et de faute volontaire.
3. **Lecture à voix haute** : souffle, rythme, nouveaux tics créés par la révision.

**Porte 7** : le diagnostic final (`final.md --avant v2.md --cible N`) confirme la porte 6. Si le jugement l'a fait régresser, défaire les retouches fautives. Budget : 3 diagnostics par texte, 4 avec une v3.

### Étape 8 : Finition et livraison
- **Typographie d'édition** (`typo_fr.py`) si le texte est destiné à l'édition.
- **Livraison** : le texte seul, sans `atelier/` ni commentaire de méthode, sauf demande.
- **Exception** : les sources citées de mémoire sont listées **hors du texte**, « à vérifier avant publication ».

## Mode révision ou humanisation d'un texte existant

Fiche réduite (voix déduite, ce qui doit rester), puis étapes 5 à 8.

Interdits :
- changer le fond ;
- ajouter des faits ou des sources ;
- remplacer les mots un par un par des synonymes. On change la *construction* ; un mot ne se remplace que par un mot aussi précis et moins coûteux en points.

## Coût et dosage

- **Mode léger** (moins de 600 mots, demandes rapides) :
  - fiche en 5 lignes, 2 ou 3 choix de matière ;
  - rédaction avec la grille ;
  - un double diagnostic ;
  - une révision unique, avec variantes pour les 3 phrases les plus « IA » seulement ;
  - lecture du détecteur.
- **Texte de 600 à 4 000 mots** : pipeline complet, révision par blocs de 5 à 10 paragraphes.
- **Livre** : `long-format.md`. Une bible de voix pour tout le livre ; fiche, matière et pipeline par chapitre ; `--dossier` pour les tics transversaux ; `points.py` par chapitre.

## Fichiers de référence

- `references/cadrage.md` : fiche et contrat de voix.
- `references/matiere.md` : choix de matière, anti-accessoires, ancrage.
- `references/decisions.md` : **points de décision** mesurés (ouvrir, relier, densifier, finir, enchaîner les longueurs, nommer).
- `references/emotion-scene.md` : **fabrication de l'émotion et des scènes** (arc des pics, émotion nommée et corps, discours indirect libre, sens, dialogue).
- `references/construction.md` : grammaire calibrée (zones par genre).
- `references/points.md` : **barème de points** et procédure de sélection des variantes.
- `references/revision.md` : tables de décision par code et par règle, mode sans script.
- `references/jugement.md` : lecture adverse, grille de l'éditeur, macro-tics.
- `references/genres/` : fiction, non-fiction, conversation (textes courts et discussion), long format.
- `references/donnees-calibration.md` : corpus, méthode, validation, limites.
- `references/marqueurs.json`, `references/profils.json`, `references/modele_points.json` : données des scripts.
- `eval/protocole.md` : mesurer l'effet du skill, détecteurs externes compris.
