# Fabrication de l'émotion et des scènes

Comment les romanciers humains du corpus produisent l'émotion, comparés à Claude, à partir de deux sources :
- **mesures** sur 4 romans (≈ 555 000 mots : romance sombre française, Martin, Sapkowski, Fargetton) et 46 scènes Claude ;
- **lecture guidée par le modèle** : 719 pics émotionnels repérés automatiquement (densité d'émotion, de corps et de ponctuation forte), dont 25 passages lus de près (19 humains, 6 IA).

Seuls les écarts récurrents chez au moins 3 auteurs humains différents sont retenus.

---

## 1. L'arc d'un pic : calme → contraction → sortie

Moyennes autour des 719 pics humains et des 80 pics IA (fenêtres de 3 phrases ; 0 = le pic) :

| | −6 à −2 (montée) | −1 | **0 (pic)** | +1 | +2, +3 |
|---|---|---|---|---|---|
| Longueur des phrases, humain | 11,1 | 10,1 | **6,3** | 10,6 | 11,3 |
| Longueur des phrases, IA | 9,6 | 9,5 | **6,1** | 8,7 | 9,2 |
| Part de phrases ≤ 8 mots, humain | 48 % | 53 % | **77 %** | 50 % | 47 % |
| Part de phrases ≤ 8 mots, IA | 57-63 % | 58 % | **81 %** | 65 % | 62 % |

**Lecture**
- **L'humain écrit calme avant le pic.** Ses phrases sont ordinaires (11 mots), sa narration est posée. Le pic est une **contraction brutale**, et l'on revient aussitôt à la normale.
- **L'IA est sous pression en permanence** : phrases courtes partout, de sorte que le pic n'a pas de relief. Elle reste agitée après.

**Règles**
1. La montée se fait en **phrases ordinaires** : pas de phrases courtes « pour la tension » avant le pic.
2. Le pic, c'est **une ou deux phrases contractées** (5 à 7 mots), pas un paragraphe de fragments. Ces phrases sont l'exception permise aux plafonds de phrases courtes (`construction.md` §D) et à la règle des zones de rythme (`decisions.md` §5).
3. Juste après, **retour immédiat à la longueur normale**.

## 2. Ce que les humains font au pic et que l'IA ne fait jamais

Observé dans 6 passages humains sur 19, issus de 3 à 4 auteurs différents, et dans 0 passage IA sur 6.

- **La réplique coupée.** Le personnage n'arrive pas au bout : « Tu crois que je… Aïe ! », « C'est quand même dingue… », un nom bégayé. L'IA fait toujours aboutir la réplique (« Zéro ! », « Bien sûr. »).
- **La réponse à côté.** Au moment fort, on ne répond pas à la question : on renvoie une question, on dit « Rien », on parle d'autre chose (« On s'en fiche, comment c'est plié ! »). L'IA répond droit.
- **L'émotion portée par un objet, un nom, un juron ou le corps**, sans mot de sentiment au pic : « Pas mon luth ! », un prénom crié, une main qui se porte au ventre. Observé chez 4 humains.

**Règle.** Au pic, choisir au moins l'un des trois : réplique coupée, réponse à côté, objet ou nom à la place du sentiment.

## 3. Ce que les humains font après le pic

- **Changer de cadre** (6 humains sur 19, 0 IA sur 6) : saut dans le temps (« Un quart d'heure plus tard »), autre lieu, autre plan, autre point de vue. L'IA reste dans la pièce.
- **Ne pas commenter.** 4 passages IA sur 6 glosent le sens du pic juste après (« C'est ça qui me rend dingue », « sans qu'elle sache encore pourquoi »), contre 5 humains sur 19. On ne dit jamais ce que la scène vient de signifier.
- **Finir sur une chute ironique ou cinglante** (6 humains, 1 IA) : « Tu n'avais pas été très clair avec moi. »
- **Revenir au banal**, par une réplique pratique ou un geste matériel. Les deux le font ; c'est une bonne pratique, pas un marqueur.

## 4. Ce que les humains préparent pendant la montée

- **Un mot posé tôt et repris au pic** (4 humains, 2 IA) : un surnom, un objet, un projet évoqué en passant revient au moment fort. C'est l'écho qui donne l'impression de construction.
- **Un détail matériel sans fonction apparente** : les deux le font. Chez l'humain, il appartient au monde du personnage. Chez l'IA, il horodate (« Vingt-trois heures dix ») : voir les accessoires.

## 5. Nommer l'émotion : contre le dogme

| Pour 1000 mots (fiction) | Humain | IA |
|---|---|---|
| Émotions **nommées** (peur, colère, honte, joie…) | **4,3** | 2,2 |
| Phrases avec un mot du corps | 8,3 | **10,5** |
| Verbes mentaux (penser, savoir, comprendre…) | 8,6 | **13,1** |
| Questions dans la narration (discours indirect libre) | **1,1** | 0 |

**Lecture.** L'IA a trop bien appris « montrer plutôt que dire ». Elle évite de nommer l'émotion, la remplace par des réactions corporelles (mâchoire, gorge, souffle) et par des verbes de cognition (« il comprit que… », « elle savait que… »). Les romanciers **nomment** l'émotion en passant (« La honte lui brûlait les joues »). Ils font penser le personnage **par des questions** dans la narration (« Pourquoi était-il revenu ? »), pas par « il se demandait si ».

**Règles**
1. Nommer l'émotion **une fois, sobrement**, quand elle arrive, puis passer à autre chose. Au pic, en revanche, laisser parler l'objet ou la réplique (§2).
2. Remplacer « il se demanda si X » par la question elle-même dans la narration : « X ? » (1 à 4 pour 1000 mots).
3. Pas plus d'une réaction corporelle par paragraphe. Pas de « sa mâchoire se crispa » par réflexe.
4. Réduire « comprendre que », « savoir que », « réaliser que » : les remplacer par le fait.

## 6. Les sens : un, pas cinq

| Pour 1000 mots | Humain | IA |
|---|---|---|
| Vue | 5,8 | **9,9** |
| **Ouïe** (voix, bruit, silence, cri) | **23,5** | 16,5 |
| Odorat, toucher | 1,1 / 1,2 | 1,7 / 2,0 |
| Nombre de sens mobilisés par extrait | 3 | 4 |

**Règle.** L'IA fait une tournée des sens (lumière, odeur, texture, son), l'humain en choisit **un dominant**, le plus souvent l'ouïe : les voix, les bruits, le silence. Une scène se construit autour d'un sens, avec au plus un second en contrepoint.

## 7. Nommer les gens et les lieux

Fiction : **41,5 noms propres** pour 1000 mots chez l'humain (médiane ; zone de 12 à 62), contre 23,8 chez l'IA. L'humain désigne par le nom, le surnom ou le titre (« Ser Rodrik », « le Lannister », « Petit-Œil »). L'IA dit « il », « l'homme », « la femme ».

## 8. Le dialogue

| | Humain | IA |
|---|---|---|
| Mots par phrase de réplique | **9,5** (zone 5,6-13) | 5,7 |
| Alternances dialogue/narration pour 1000 mots | 12 | **18** |
| Paragraphes de narration entre deux blocs de dialogue | 2 | 1,5 |
| Incises neutres (« dit-il ») | 0-25 % | **80-100 %** |

**Lecture.**
- L'IA écrit des répliques **télégraphiques** et coupe le dialogue sans cesse par une ligne de narration (un geste après chaque réplique).
- L'humain laisse le dialogue **courir** sur plusieurs répliques de longueur normale, puis revient à la narration pour un vrai bloc.

**Règles**
1. Des répliques de longueur normale, avec des phrases complètes.
2. Des séries de 3 à 6 répliques sans geste intercalé.
3. Des blocs de narration de plusieurs paragraphes entre les séquences.
4. Pas un « il posa sa tasse » entre chaque réplique.

## 9. Liste de contrôle d'une scène (étape 7, lecture du détecteur)

- [ ] La montée est écrite en phrases ordinaires, pas en fragments.
- [ ] Un mot ou un objet posé tôt revient au pic.
- [ ] Au pic : réplique coupée, réponse à côté, ou objet/nom à la place du sentiment.
- [ ] Après le pic : pas de glose ; changement de cadre ou chute.
- [ ] L'émotion est nommée au moins une fois (hors pic), sobrement.
- [ ] Au moins une question dans la narration.
- [ ] Un sens dominant (souvent l'ouïe), pas une tournée des cinq sens.
- [ ] Les personnages et les lieux sont nommés.
- [ ] Répliques de longueur normale, en séries ; incises d'attitude ou absentes.

**Limites.** Deux des quatre romans sont des traductions, et 6 passages IA lus de près, c'est peu. Ce sont des tendances robustes (plusieurs auteurs, mesures concordantes), pas des lois. Le contenu d'une scène, ce qu'elle raconte, reste la première source d'émotion. Ces règles portent sur la manière de le porter.
