# Version 2 (9 livres) : à lire en premier

## Corpus

| Genre | Livres humains | Mots | Statut |
|---|---|---|---|
| fiction | romance sombre française (Guerrieri) ; *Le Trône de fer* (Martin, trad. J. Sola) ; *L'Épée de la providence* (Sapkowski, trad. du polonais) ; *À quoi rêvent les étoiles* (Fargetton, roman contemporain français) | ≈ 555 000 | 4 voix très différentes |
| pratique | Giacomello (2021) ; d'Ansembourg, *Cessez d'être gentil, soyez vrai !* (2001) ; Mercier (2020, avant les IA grand public) | ≈ 125 000 | |
| explicatif | Siegel et Bryson (trad.) ; André et Lelord, *L'Estime de soi* (1999-2007) | ≈ 140 000 | |

- **IA** : 146 textes Claude Haiku, Sonnet et Opus. Ce sont les 114 du premier corpus, 8 textes de test et 24 nouveaux (fantasy, roman contemporain, psychologie, communication).
- **Profils** : au plus 70 extraits par livre, prélevés à intervalle régulier, pour qu'aucun livre ne domine la norme.
- **Analyse** : syntaxe complète (spaCy, dépendances) de chaque phrase, mise en cache. Les points de décision, le rythme et l'émotion sont calculés phrase par phrase.

## Ce que la version 2 a changé

1. **La validation « livre tenu à l'écart »** (on entraîne sur 8 livres et on teste sur le 9e, inconnu) donne une **AUC moyenne de 0,937** par passage de 45 mots. Les décisions explicites (ouverture, lien, fin, rythme) n'ajoutent pas de pouvoir prédictif aux trigrammes, qui les captent déjà, mais elles rendent les points **lisibles**. Le livre le plus difficile est Fargetton (AUC 0,84) : phrases courtes au présent, beaucoup de dialogue, c'est le style humain le plus proche de l'IA.
2. **Les zones de fiction sont plus larges** : la densité de virgules, la longueur des phrases et la part de phrases courtes ne séparent plus nettement les humains de l'IA en fiction. Restent robustes sur les 9 livres : « , et », les accessoires, les liaisons, les incises neutres, les ouvertures par pronom, les fins sur négation, les adjectifs, l'autocorrélation du rythme, la ponctuation finale expressive, la longueur des répliques et, en non-fiction, la reprise du nom-clé.
3. **Invariants** : 886 traits humains et 752 traits IA gardent le même signe dans tous les modèles « livre tenu à l'écart ». Ce sont les choix partagés par les 9 auteurs (voir `points.md` et `decisions.md`).
4. **Artefacts neutralisés** : les tirets de dialogue (– ou —) et le guillemet d'ouverture de réplique sont rendus équivalents. Sans cela, le modèle apprenait à distinguer la typographie de l'éditeur, pas l'écriture. 46 mots trop liés aux sujets des livres ont été retirés (roi, cheval, estime, école…).
5. **Porte 6 recalibrée** : environ 80 % des extraits humains hors profils la franchissent (de 63 % à 100 % selon le livre), contre 0 sur 8 textes Claude bruts.
6. **Premier retour Pangram** : sur la scène produite avec le pipeline complet, un passage de trois phrases a été évalué à **91 % humain, 9 % IA**.

## Analyses de fabrication (fiction)

Médianes par extrait de 900 mots, humains et IA. Le détail est dans `emotion-scene.md` et `decisions.md`.

| Mesure | Humain | IA |
|---|---|---|
| Questions dans la narration / 1000 | 1,1 | 0 |
| Verbes mentaux / 1000 | 8,6 | 13,1 |
| Noms propres / 1000 | 41,5 | 23,8 |
| Émotions nommées / 1000 | 4,3 | 2,2 |
| Mots du corps (phrases) / 1000 | 8,3 | 10,5 |
| Vue / 1000 | 5,8 | 9,9 |
| Ouïe / 1000 | 23,5 | 16,5 |
| Longueur des phrases avant un pic émotionnel | 11,1 | 9,6 |
| Phrases ≤ 8 mots hors pic | 48 % | 57-63 % |

---

# Version 1 (3 livres) : historique

# Données de calibration : d'où viennent les chiffres

## Corpus

**Humain** (≈ 190 000 mots, découpés en 202 extraits de ~900 mots) :

| Genre de profil | Source | Mots | Extraits | Remarque |
|---|---|---|---|---|
| fiction | Roman français contemporain (romance sombre et suspense, années 1920), 1re personne du présent, deux narrateurs | 114 000 | 123 | Écrit en français, publié par un grand éditeur |
| pratique | Livre de développement personnel (2021) | 28 000 | 29 | Avant les IA génératives grand public ; possiblement traduit |
| explicatif | Livre de psychologie de l'enfant pour parents | 49 000 | 50 | Traduit de l'anglais par une traductrice humaine (édition québécoise) |

Les textes intégraux ne sont **pas** inclus dans le skill (droits d'auteur). Seules des statistiques agrégées le sont.

**IA** (114 textes, ≈ 95 000 mots) : Claude Haiku, Sonnet et Opus, chacun avec les mêmes 38 consignes (10 scènes de roman, 10 sections de développement personnel, 10 passages de vulgarisation pour parents, 8 textes divers : essai, article, nouvelle, lettre, chronique, récit de voyage, dialogue, billet). Les consignes sont dans `eval/consignes_*.txt`. Les textes ont été produits par des agents indépendants, sans instruction de style (« comme tu le ferais d'habitude »).

## Méthode

- Analyse morphosyntaxique spaCy `fr_core_news_md`. Mesures par extrait, normalisées pour 1000 mots ou en pourcentage.
- Pouvoir discriminant : δ de Cliff entre textes IA et extraits humains du même genre. δ = +1 signifie que l'IA est au-dessus de tous les humains ; δ = −1, en dessous de tous.
- Lexique : rapport de fréquence IA/humain. On ne retient un mot ou une expression que s'il est sur-représenté (×2 ou plus) dans au moins 3 genres IA et présent dans au moins 6 textes issus de consignes différentes. Cela écarte les mots liés au sujet.
- Lecture qualitative : trois agents stylisticiens indépendants, un par genre, ont comparé 5 extraits humains et 5 textes IA, avec citations.

## Principaux résultats (δ de Cliff, IA par rapport à l'humain)

| Mesure | Fiction | Pratique | Explicatif |
|---|---|---|---|
| Virgules / 1000 mots | +1,00 | +0,98 | +0,88 |
| « , et » | +0,99 | +0,91 | +0,54 |
| Accessoires (nombres, jours, heures, objets domestiques) | +0,99 | +0,53 | +0,71 |
| Liaisons « humaines »* | −0,98 | −0,95 | −0,88 |
| Incises de dialogue neutres | +0,97 | - | - |
| Points de suspension | −0,91 | −0,44 | −0,19 |
| Diversité des débuts de phrase | −0,91 | −0,40 | −0,45 |
| Adjectifs par nom | −0,83 | −0,62 | −0,67 |
| « on » | +0,69 | +0,72 | +0,87 |
| Formules IA* | +0,67 | +0,77 | +0,90 |
| Prépositions | −0,76 | −0,61 | −0,72 |
| Participes présents | −0,74 | −0,68 | −0,12 |
| Deux-points | +0,75 | +0,38 | +0,71 |
| % phrases ≤ 5 mots | +0,81 | +0,17 | +0,26 |
| Paragraphe ouvert par une phrase courte | +0,61 | +0,41 | +0,52 |
| Longueur moyenne des phrases | −0,59 | −0,35 | −0,58 |
| « nous » | −0,58 | −0,11 | −0,89 |

\* Listes sélectionnées sur ce même corpus : leur pouvoir discriminant est **surestimé** (circularité). Il faut les valider sur de nouveaux textes, voir `eval/protocole.md`.

**Non discriminants** (|δ| < 0,3, donc à ne pas viser) : longueur des paragraphes, % de paragraphes d'une phrase, fréquence des questions, triades lexicales simples, « à la fois », « non seulement ». La diversité lexicale (MATTR) varie dans des sens opposés selon le genre.

## Validation des portes

- **Profils construits sur 70 % des extraits humains, testés sur les 30 % restants** : la porte 6 (au plus 3 ✗, au plus 2 ⚠, au plus 45 % ou 50 % de phrases signalées) est franchie par 25 extraits sur 36 en fiction, 6 sur 9 en pratique et 9 sur 15 en explicatif. Les extraits humains ont une médiane de 1 à 2 mesures ✗.
- **Textes IA bruts** : 5 à 19 mesures ✗ (médiane 11 à 15). Aucun ne franchit la porte.
- La porte est donc exigeante sans être hors d'atteinte : environ 2 textes humains sur 3 la passent du premier coup. Le pipeline prévoit une passe supplémentaire, puis l'acceptation des écarts restants.

## Modèle de points (`modele_points.json`)

**Construction**
- Régression logistique L2 sur des fenêtres d'environ 45 mots : 3 011 fenêtres humaines et 2 599 fenêtres IA pour la validation, davantage pour le modèle final.
- Traits retenus :
  - trigrammes de constructions (catégorie grammaticale ou mot-outil, avec la ponctuation et les bords de phrase) ;
  - mots-outils ;
  - mots de contenu, **seulement si leur biais va dans le même sens dans tous les genres où ils apparaissent**, ce qui écarte les mots liés au sujet d'un livre ;
  - forme des phrases ;
  - les quatre catégories de marqueurs.
- 18 mots trop liés aux sujets des livres ont été retirés à la main (voir `retires_manuellement`).

**Validation croisée groupée** (une consigne IA ou un bloc de 8 extraits voisins d'un livre ne sont jamais à la fois en entraînement et en test) : AUC de **0,976** par fenêtre.

**Test sur des textes jamais vus** (modèle entraîné sur 70 % des extraits humains) :

| Groupe | Indice d'humanité médian | Plage |
|---|---|---|
| Extraits humains tenus à l'écart (60) | **91** | p10 78, minimum 66 |
| Claude brut, nouvelles consignes (8) | **10** | 7 à 13 |
| Claude avec la v1 du skill, sans la passe par points (8) | **72** | 30 à 84 |

Le modèle n'a jamais servi à produire ces textes v1 : c'est une mesure indépendante.

## Test à l'aveugle (juges LLM)

Deux juges Claude Haiku indépendants ont reçu 36 extraits anonymisés de ~380 mots, mélangés, typographie uniformisée :
- 20 extraits humains tenus à l'écart ;
- 8 textes Claude bruts ;
- 8 textes Claude avec la v1 du skill.

Consigne : « humain ou IA ».

| Groupe | Jugés humains |
|---|---|
| Extraits humains | 31 / 40 (78 %) |
| Claude brut | 5 / 16 (31 %) |
| Claude avec la v1 du skill | **13 / 16 (81 %)** |

L'échantillon est petit et les juges sont des LLM, qui corrèlent mal avec les experts humains : c'est un signal, pas une preuve.

## Limites (à garder en tête)

1. **Trois livres, trois auteurs.** Les profils décrivent ces voix-là autant que « l'humain » en général. Romance populaire, développement personnel et vulgarisation traduite ne sont pas la littérature blanche ni la presse. Pour une autre cible, construire un profil (`construire_profil.py`) à partir de 50 000 mots ou plus de textes humains du genre visé.
2. **Traduction.** Le livre explicatif est traduit de l'anglais, peut-être aussi le livre pratique. Certaines liaisons (« afin de », « lorsque ») sont plus fréquentes en traduction.
3. **Claude uniquement.** Les marqueurs IA sont ceux de Claude (Haiku, Sonnet, Opus). D'autres modèles ont d'autres tics.
4. **Consignes de 900 mots.** Les textes très courts (moins de 300 mots) ont des mesures instables.
5. **Corrélation n'est pas cause.** Rapprocher un texte des zones humaines réduit les marqueurs mesurés ici. Cela ne garantit pas qu'un détecteur entraîné sur d'autres traits ne le reconnaîtra pas.
6. **Typographie.** Les livres humains utilisent l'apostrophe typographique ’ et les textes IA l'apostrophe droite '. Cette différence parfaite est probablement un artefact de production (EPUB édité contre sortie brute) et n'est pas comptée dans les mesures. Son effet sur les détecteurs est inconnu.
