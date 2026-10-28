---
name: ecriture-humaine
description: Pipeline strict d'écriture et de révision en français pour produire une prose dont la fabrication ressemble à celle d'auteurs humains (roman, nouvelle, scène, dialogue, essai, article, chronique, développement personnel, vulgarisation, livre entier). Cadrage, choix de matière, rédaction selon une grammaire calibrée sur des livres humains, diagnostic chiffré par script, révision en passes ordonnées, jugement adverse et portes de validation. À utiliser dès qu'il faut écrire ou réécrire un texte destiné à être lu comme humain, « humaniser » un texte généré par IA, ou réviser un manuscrit long.
---

# Écriture humaine — pipeline

Ce skill impose une **procédure**, pas une liste d'astuces. Chaque étape produit un livrable écrit et se termine par une **porte** : on ne passe pas à l'étape suivante tant que la porte n'est pas franchie. Les règles chiffrées viennent d'une calibration sur trois livres humains et 114 textes générés par Claude dans les mêmes genres (voir `references/donnees-calibration.md`).

## Ce qu'il faut savoir avant de commencer

1. **La signature IA en français n'est pas celle qu'on croit.** Les conseils habituels (« phrases courtes », « pas d'adverbes », « du concret », « montrer plutôt qu'expliquer ») poussent le texte *vers* le profil IA. Mesuré : l'IA met 1,5 à 1,8 fois plus de virgules, 2 à 3 fois plus de deux-points, 3 à 6 fois plus de « on », plus de phrases très courtes, moins d'adjectifs, moins de prépositions, moins de coordination, moins de subordination, moins d'adverbes en -ment. Elle évite les liaisons classiques (« lorsque », « afin de », « ainsi », « à nouveau », « bien que »). Et elle simule le concret par des **accessoires** : nombres en lettres, jours, horaires, cuisine, café, téléphone (×3 à ×9).
2. **Humain ne veut pas dire négligé.** On ne fabrique jamais de fautes, de coquilles ni de désordre artificiel. On vise la *maîtrise* d'un auteur, avec ses choix assumés : phrases longues bien construites, ponctuation expressive, registre propre, jugements, images filées.
3. **Le diagnostic signale, il ne décide pas.** Les mesures décrivent des zones humaines (percentiles 10 à 90). Un texte humain en sort sur 1 à 3 mesures en moyenne. Viser le *centre* d'une zone partout produit un autre automatisme. La qualité et le sens priment toujours.
4. **Aucune garantie face aux détecteurs.** Ce pipeline réduit les marqueurs mesurables. Il ne rend aucun texte « indétectable ». L'évaluation se fait avec `eval/protocole.md`, jamais sur un texte isolé.

## Outils

- `scripts/diagnostic.py` : mesure un texte contre le profil humain du genre et liste les phrases à examiner. Nécessite Python 3. L'analyse complète demande spaCy (`pip install spacy` puis `python -m spacy download fr_core_news_md`). Sans spaCy, le script tourne en mode partiel.
- Genres de profil : `fiction` (roman, nouvelle, scène, récit), `pratique` (développement personnel, guide, conseil), `explicatif` (vulgarisation, pédagogie), `essai` (essai, article, chronique, billet : profil non-fiction mixte).
- `scripts/construire_profil.py` crée un profil à partir de textes humains fournis (par exemple une voix précise).
- `scripts/typo_fr.py` applique la typographie française d'édition (facultatif, étape 8).
- Sans exécution de code possible : appliquer les grilles manuelles de `references/revision.md` (section « Mode sans script »).

Commande de base (depuis le dossier du skill) :
```
python3 scripts/diagnostic.py atelier/brouillon.md --genre fiction
python3 scripts/diagnostic.py atelier/v2.md --genre fiction --avant atelier/brouillon.md
```

## Le pipeline

Travailler dans un dossier `atelier/` (fiche, brouillons, rapports). Seul le texte final est livré à l'utilisateur, sans commentaire de fabrication, sauf s'il les demande.

### Étape 0 : Triage (toujours)
Déterminer :
- le **mode** : écrire un texte neuf, réviser ou humaniser un texte existant, ou long format (plus de 4 000 mots ou plusieurs chapitres) ;
- le **genre de profil** et la **longueur** ;
- les **références à charger**.

| Situation | Charger |
|---|---|
| Fiction, scène, nouvelle | `references/genres/fiction.md` (contient le dialogue) |
| Essai, article, développement personnel, vulgarisation | `references/genres/non-fiction.md` |
| Plus de 4 000 mots, livre, série de chapitres | en plus, `references/genres/long-format.md` |
| Révision d'un texte existant | aller directement à l'étape 4 après une fiche de cadrage réduite |

**Porte 0** : mode, genre de profil et références sont écrits en tête de `atelier/fiche.md`.

### Étape 1 : Cadrage → `atelier/fiche.md`
Remplir la fiche de `references/cadrage.md`. Elle comprend :
- le lecteur et ce qu'il sait déjà ;
- l'intention ;
- la voix, avec son *contrat* : personne grammaticale, registre, ponctuation expressive autorisée, tolérance aux expressions figées, longueur de phrase visée ;
- trois choses à ne **pas** dire explicitement ;
- ce que le texte ne doit pas faire en finissant.

**Porte 1** : chaque champ est rempli par une décision concrète (pas « ton naturel », mais « je narratif, présent, familier, phrases longues coupées de rares exclamations »). En révision, la fiche est déduite du texte existant.

### Étape 2 : Matière → `atelier/matiere.md`
Appliquer `references/matiere.md` :
- inventaire des éléments par **échantillonnage de queue** (lister 6 options pour chaque choix clé, estimer laquelle « tout le monde écrirait », retenir une option plausible mais moins attendue) ;
- **tri anti-accessoires** : aucun nombre, jour, horaire ou objet domestique qui ne serve pas l'histoire ou l'argument ;
- pour la fiction : verdicts et jugements du narrateur ;
- pour la non-fiction : ancrage (cas, source réelle, expérience fournie par l'utilisateur).

Ne **jamais inventer** de source, d'étude, de chiffre ou d'anecdote présentée comme réelle. Ce qui manque est demandé à l'utilisateur ou marqué `[À FOURNIR : …]`.

**Porte 2** : chaque élément retenu répond à la question « pourquoi celui-ci et pas le plus probable ? ».

### Étape 3 : Plan → dans `atelier/fiche.md`
- Ordre de révélation de l'information, rôle de chaque paragraphe ou scène.
- Plan **asymétrique** : pas trois parties égales, pas d'intertitres en concepts parallèles.
- Pour chaque paragraphe, une **ouverture** qui reprend ce qui précède (pas de phrase-choc) et une **fermeture** qui n'est ni maxime, ni bilan, ni antithèse.
- Fin du texte ouverte ou concrète.

**Porte 3** : aucune fin de section ne contient de morale, de récapitulatif (« En somme », « Autrement dit ») ni d'injonction finale (« Essayez cette semaine »).

### Étape 4 : Rédaction → `atelier/brouillon.md`
Rédiger en appliquant `references/construction.md`, la grammaire calibrée. Points essentiels :
- **Virgules** : environ deux fois moins qu'un premier jet IA. **Jamais** de virgule avant « et » pour coordonner. Verbes coordonnés sans répéter le sujet (« Il enjambe les débris et marche sur le verre »).
- **Deux-points** : presque jamais en narration ; pas de « Résultat : », pas de deux-points de révélation.
- **Phrases** : longues, construites par compléments du nom, prépositions, relatives, subordonnées (lorsque, tandis que, afin de, bien que, dès que), participes et gérondifs. En fiction, moins d'une phrase narrative sur six fait 5 mots ou moins, et jamais deux de suite.
- **Ouvertures de phrase** variées : jamais trois pronoms sujets d'affilée, jamais deux fois le même premier mot.
- **Lexique** : adjectifs (les évaluatifs placés avant le nom), adverbes en -ment, liaisons classiques à dose humaine. Pas de « on » générique en non-fiction.
- **Voix** : l'auteur existe, avec « nous » ou « je » en non-fiction, des jugements et du registre en fiction.

Pour un long format : rédiger et réviser **par unité** (scène ou chapitre), voir `long-format.md`.

**Porte 4** : le brouillon est complet. Ne pas réviser pendant la rédaction.

### Étape 5 : Diagnostic → `atelier/rapport-1.md`
Lancer `diagnostic.py` sur le brouillon avec le genre de profil. Lire :
- les priorités (✗ et ⚠, triées par pouvoir discriminant) ;
- les phrases signalées (codes V1 à R1).

**Porte 5** : le rapport est enregistré. Si le texte fait moins de 300 mots, s'appuyer surtout sur les phrases signalées.

### Étape 6 : Révision en quatre passes ordonnées → `atelier/v2.md`
Ordre obligatoire, du plus haut niveau au plus bas. Chaque passe a ses règles dans `references/revision.md`.
1. **Architecture** (R-ARCH) : ouvertures et fermetures de paragraphes, fins de section, explicitations superflues (gloses du type « C'est ça qui me glace »), structure trop régulière.
2. **Syntaxe et ponctuation** (R-PONCT, R-SYNT, R-RYTH, R-OUV) : traiter chaque phrase signalée V1, V2, P1, C1, C2, O1, O2, S3 et R1 selon sa table de décision. Fusionner les rafales de phrases courtes, alléger les virgules, varier les ouvertures.
3. **Lexique et voix** (R-LEX, R-VOIX, R-LIAIS) : traiter les signalements L1, L2, L3 et S1. Ajuster adjectifs, adverbes et liaisons jusqu'à la zone humaine, sans la dépasser (⚠).
4. **Expressivité** (R-EXPR, fiction et voix vives) : ponctuation expressive et incises de dialogue à verbe d'attitude, là où la voix le justifie.

Règles de révision :
- modifications **locales** : on réécrit la phrase ou le paragraphe, jamais tout le texte d'un bloc ;
- le sens et les faits ne bougent pas ;
- toute modification qui rend la phrase moins claire ou moins juste est annulée.

**Porte 6** : relancer `diagnostic.py atelier/v2.md --avant atelier/brouillon.md`. Conditions pour passer :
- **au plus 3 mesures ✗** (les extraits humains de calibration en ont 0 à 3 dans 75 % des cas, les textes IA bruts 5 à 19) ;
- **au plus 2 ⚠** (sur-correction) ;
- **au plus 45 % de phrases narratives signalées** (50 % en `explicatif`).

Sinon, une seule passe supplémentaire, ciblée sur les ✗ restants (v3). Au-delà, accepter le résultat et noter les écarts restants : forcer davantage dégrade la prose.

### Étape 7 : Jugement adverse → `atelier/jugement.md`
Appliquer `references/jugement.md`. Il se fait en trois lectures, et non en une relecture complaisante.
1. **Lecture du détecteur.** Relire comme un lecteur expert qui sait reconnaître l'IA. Nommer les 5 phrases les plus suspectes et les macro-tics (fin morale, symétrie, analogie expliquée, personnage composite, idée reçue démontée, etc.). Corriger.
2. **Lecture de l'éditeur.** Vérifier le sens, la clarté, la cohérence de la voix contre la fiche, l'absence de dégradation et l'absence de faute inventée.
3. **Lecture à voix haute** (mentale) : rythme, souffle, phrases trop longues pour être lues d'une traite sans ponctuation.

**Porte 7** : les 5 phrases suspectes sont corrigées ou justifiées, et la grille de l'éditeur est toute verte. Relancer le diagnostic si plus de 10 % du texte a changé.

### Étape 8 : Finition et livraison
- **Typographie** : française d'édition (« » avec espaces insécables, apostrophe ’, points de suspension …, tirets de dialogue —) si le texte est destiné à l'édition (`scripts/typo_fr.py`). Sinon, conserver la typographie demandée.
- **Livraison** : le texte seul. Ne jamais livrer `atelier/`, les rapports ni les commentaires sur la méthode, sauf si l'utilisateur le demande.

## Mode révision ou humanisation d'un texte existant
1. Étape 0, puis fiche réduite (voix déduite du texte, intention, ce qui doit rester).
2. Étape 5 sur le texte original, puis étapes 6 à 8.
3. Interdits :
   - changer le fond, ajouter des faits ou des sources ;
   - « décorer » par synonymes : on restructure les phrases, on ne remplace pas les mots un par un.

## Coût et dosage
- **Texte court** (moins de 1 500 mots) : pipeline complet, deux diagnostics.
- **Texte moyen** (1 500 à 4 000 mots) : idem, révision par blocs de 5 à 10 paragraphes.
- **Livre** : voir `long-format.md`.
  - Fiche et matière une fois par chapitre ; la bible de voix une fois pour tout le livre.
  - Diagnostic `--dossier` pour suivre les tics transversaux entre chapitres.

## Fichiers de référence
- `references/cadrage.md` : fiche de cadrage et contrat de voix.
- `references/matiere.md` : choix de la matière, échantillonnage de queue, anti-accessoires, ancrage.
- `references/construction.md` : grammaire calibrée de la phrase, du paragraphe et de la voix (à lire avant toute rédaction).
- `references/revision.md` : tables de décision par code de signalement et par règle (R-…), mode sans script.
- `references/jugement.md` : lecture adverse, grille de l'éditeur, macro-tics.
- `references/genres/fiction.md`, `references/genres/non-fiction.md`, `references/genres/long-format.md`.
- `references/donnees-calibration.md` : corpus, mesures, limites.
- `references/marqueurs.json`, `references/profils.json` : données utilisées par les scripts.
- `eval/protocole.md` : comment mesurer l'effet du skill, détecteurs compris.
