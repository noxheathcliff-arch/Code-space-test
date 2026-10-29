# État du projet : écriture « humaine » en français (skill Claude)

*Dernière mise à jour : 29 octobre 2026. Branche : `ccr-f8007a15-0no3h4`.*

## 1. Objectif

Un skill Claude qui fait écrire l'IA en français comme un auteur humain : romans, scènes, essais, développement personnel, vulgarisation, textes courts, conversation. Trois exigences, ensemble :
1. **Une vraie qualité d'écriture.** Ne jamais dégrader le texte, ne jamais fabriquer de fautes.
2. **Des textes que le détecteur Pangram ne reconnaisse pas comme IA**, de façon reproductible.
3. **Une méthode durable**, réutilisable par n'importe quelle session Claude ou Claude Code.

## 2. Où on en est

| Étape | Statut |
|---|---|
| Recherche initiale (Pangram, détection, littérature) | faite : `recherche-ecriture/phase-1-rapport.md` |
| **Skill v1** (3 livres, 114 textes IA, pipeline en 8 étapes, système de points v1) | fait : `livraison/ecriture-humaine-v1.zip` |
| **Skill v2** (9 livres, 146 textes IA, modèle validé livre tenu à l'écart, points de décision, émotion et scènes, conversation) | fait : `.claude/skills/ecriture-humaine/` et `livraison/ecriture-humaine-v2.zip` |
| Tests Pangram | 2 retours (§4) |
| Modèle de type Pangram (transformeur) | **pas fait** : bloqué par le réseau (§6) |
| Analyse ML des segments surlignés par Pangram | **proposée, pas faite** (§6) |

## 3. Comment marche le skill

Lire `.claude/skills/ecriture-humaine/SKILL.md`. Le pipeline compte 8 étapes, chacune avec une porte :
1. **Triage, cadrage, matière**, avec échantillonnage de queue (on écarte l'option la plus attendue) et chasse aux « accessoires » (horaires, café, téléphone…).
2. **Lecture de la grille de choix** : `decisions.md`, `construction.md`, `points.md`.
3. **Rédaction.**
4. **Double diagnostic** : `scripts/diagnostic.py` (zones humaines par genre) et `scripts/points.py` (indice d'humanité 0-100).
5. **Révision en 5 passes.** La 5e écrit des variantes de chaque phrase « IA » et les classe par points.
6. **Jugement adverse**, puis livraison.

Les scripts demandent Python 3 et spaCy (`fr_core_news_md`). scikit-learn ne sert qu'à réentraîner.

**Résultats internes (modèle du skill)**
- textes Claude bruts : indice d'humanité de 1 à 27 ;
- textes passés par le pipeline : 95 à 97 ;
- extraits humains : 87 en médiane.
- Validation « livre tenu à l'écart » : AUC 0,937.
- Test à l'aveugle avec deux juges LLM sur la v1 : textes du skill jugés humains 13 fois sur 16, contre 31 sur 40 pour les vrais humains et 5 sur 16 pour Claude brut.

## 4. Résultats Pangram (les seuls qui comptent vraiment)

| Texte | Version | Résultat Pangram |
|---|---|---|
| `textes-pangram/scene-avec-skill.md` (scène, Jura) | v1 | passage de 3 phrases : **91 % humain** (résultat global non transmis) |
| `textes-pangram/v2/procrastination-avec-skill.md` (développement personnel) | v2 | **64 % IA, 36 % humain** |
| `textes-pangram/v2/scene-port-avec-skill.md` (scène, port) | v2 | résultat perdu |

**Leçon principale.** Sur le texte « procrastination », le modèle du skill donnait **90 à 100 d'humanité à tous les passages**, y compris ceux que Pangram classe IA.
- **Classé humain** : le cas concret (Agnès, la lettre) et la description factuelle d'une étude.
- **Classé IA** :
  - le raisonnement général en « nous » ;
  - l'analogie filée qui conclut les paragraphes ;
  - les antithèses élégantes.

Le skill rend humaine la **surface** (ponctuation, mots-outils, syntaxe, rythme), mais Pangram voit autre chose : le **mode de discours** (généralisation éloquente, chutes imagées), et sans doute la **prévisibilité des mots et des idées**, que nos traits ne mesurent pas. Des règles provisoires ont été ajoutées dans `references/genres/non-fiction.md`.

On ne sait pas encore si la v2 marche moins bien que la v1 : les deux tests portent sur des genres différents, et la non-fiction a toujours été le genre le plus difficile.

## 5. Contenu du dépôt

```
ETAT-DU-PROJET.md                  ce document
.claude/skills/ecriture-humaine/   le skill v2 (version courante)
livraison/                         archives zip v1 et v2, prêtes à installer
textes-pangram/                    textes soumis à Pangram (avec et sans skill) et README
recherche-ecriture/
  phase-1-rapport.md               rapport de recherche initial
  outils/                          scripts d'analyse ML (hors skill), voir ci-dessous
  corpus-ia/                       les textes IA générés : lot1 (114), lot2 (24), tests de la v1 avec ateliers
  consignes/                       consignes utilisées pour générer le corpus IA
  resultats/                       sorties des analyses (décisions, émotion, validation, test à l'aveugle)
```

**Outils (`recherche-ecriture/outils/`)**, à lancer avec un environnement contenant spaCy, `fr_core_news_md` et scikit-learn :

| Script | Rôle |
|---|---|
| `epub2txt.py`, `zip_recup.py`, `htm2txt.py`, `chunk.py` | extraire les livres (y compris un EPUB abîmé) et les découper en extraits de ~900 mots |
| `cache.py` | analyse syntaxique complète, mise en cache par phrase (`.pkl`) |
| `lobo.py` | entraîne et valide le modèle de points (livre tenu à l'écart), exporte `modele_points.json`, liste les invariants |
| `decisions.py` | points de décision : ouvertures, liens, fins, densité, transitions de rythme, dialogue |
| `emotion.py` | fabrication de l'émotion : pics, sens, verbes mentaux, noms propres |
| `features.py`, `compare.py`, `lexique.py` | analyses de la v1 |
| `aveugle.py` | prépare un test à l'aveugle |

**Corpus humain : non versionné (droits d'auteur).** Neuf EPUB fournis par le propriétaire du projet :

| Genre | Livres |
|---|---|
| Fiction | Guerrieri (*L'Aube écarlate*), Martin (*Le Trône de fer*, l'EPUB est abîmé : `zip_recup.py` puis `htm2txt.py`), Sapkowski (*L'Épée de la providence*), Fargetton (*À quoi rêvent les étoiles*) |
| Pratique | Giacomello (*Arrêtez d'être gentil*), d'Ansembourg (*Cessez d'être gentil, soyez vrai*), Mercier (*Comment analyser les personnes*) |
| Explicatif | Siegel et Bryson (*Le Cerveau de votre enfant*), André et Lelord (*L'Estime de soi*) |

Pour reconstruire :
1. extraire chaque livre (`epub2txt.py`) ;
2. couper le paratexte et le découper (`chunk.py`) ; les bornes utilisées sont dans l'historique de la conversation, sinon les repérer à la main : début du chapitre 1, fin avant notes, remerciements et bibliographie ;
3. `cache.py`, puis `lobo.py`.

## 6. Suite proposée

1. **Analyser les verdicts Pangram par segment.**
   - Collecter 30 à 50 textes passés dans Pangram avec leurs passages surlignés : humains, Claude brut, Claude avec skill.
   - Comparer, **à l'intérieur d'un même texte**, les phrases que Pangram classe IA et celles qu'il classe humaines. Le sujet, le style et l'auteur sont alors contrôlés.
   - Entraîner un « substitut de Pangram » sur ces segments et chercher les traits qui séparent ses verdicts : mode de discours (général ou concret), images en chute, périodes balancées, abstraction, prévisibilité.
   - Respecter les conditions d'utilisation de Pangram : évaluation par lots, jamais dans la boucle d'écriture.
2. **Modèle de langue français.** Ajuster un CamemBERT ou un DistilCamemBERT sur les 9 livres et le corpus IA, l'architecture la plus proche de Pangram. Il faut autoriser `huggingface.co` dans le réseau de l'environnement (menu de l'environnement cloud, Edit, Network access, Allowed domains). Ses scores de prévisibilité deviendraient des traits du modèle de points.
3. **Conversation.** Fournir 30 à 100 messages humains réels pour calibrer `genres/conversation.md`.
4. **Retester** la v2 corrigée en fiction et en non-fiction, avec témoins, et noter tous les résultats Pangram dans `textes-pangram/README.md`.

## 7. Points d'attention

- **Goodhart.** Optimiser contre notre propre modèle peut produire un style artificiel : liaisons plaquées, exclamations multipliées, éloquence. Les plafonds sont dans `points.md` §7.
- **Pas de faute volontaire, pas de source inventée.** Les sources citées de mémoire sont listées hors du texte, « à vérifier ».
- **Le coût est réel.** Le pipeline complet fait écrire 30 à 50 variantes pour un texte de 900 mots. La première session a atteint la limite de quota de 5 heures.
- Le dossier de travail temporaire (`/tmp/.../scratchpad`) est perdu à la fin de la session. Tout ce qui compte est versionné ici, sauf les livres et les caches `.pkl`, à régénérer.
