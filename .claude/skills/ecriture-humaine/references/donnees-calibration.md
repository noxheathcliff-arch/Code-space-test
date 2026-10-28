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

## Limites (à garder en tête)

1. **Trois livres, trois auteurs.** Les profils décrivent ces voix-là autant que « l'humain » en général. Romance populaire, développement personnel et vulgarisation traduite ne sont pas la littérature blanche ni la presse. Pour une autre cible, construire un profil (`construire_profil.py`) à partir de 50 000 mots ou plus de textes humains du genre visé.
2. **Traduction.** Le livre explicatif est traduit de l'anglais, peut-être aussi le livre pratique. Certaines liaisons (« afin de », « lorsque ») sont plus fréquentes en traduction.
3. **Claude uniquement.** Les marqueurs IA sont ceux de Claude (Haiku, Sonnet, Opus). D'autres modèles ont d'autres tics.
4. **Consignes de 900 mots.** Les textes très courts (moins de 300 mots) ont des mesures instables.
5. **Corrélation n'est pas cause.** Rapprocher un texte des zones humaines réduit les marqueurs mesurés ici. Cela ne garantit pas qu'un détecteur entraîné sur d'autres traits ne le reconnaîtra pas.
6. **Typographie.** Les livres humains utilisent l'apostrophe typographique ’ et les textes IA l'apostrophe droite '. Cette différence parfaite est probablement un artefact de production (EPUB édité contre sortie brute) et n'est pas comptée dans les mesures. Son effet sur les détecteurs est inconnu.
