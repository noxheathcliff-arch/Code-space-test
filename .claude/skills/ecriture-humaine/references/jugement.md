# Étape 7 : Jugement adverse

Une relecture « est-ce que c'est bien ? » par le modèle qui a écrit le texte est complaisante : les juges LLM corrèlent faiblement avec les experts en écriture créative. Le jugement est donc **adverse et outillé** : on cherche activement ce qui trahit le texte, avec des grilles fermées.

## Lecture 1 : le détecteur (écrire dans `atelier/jugement.md`)

Se mettre dans la peau d'un lecteur qui utilise l'IA tous les jours et sait la reconnaître. Ces lecteurs identifient les textes IA presque sans erreur (Russell, Karpinska & Iyyer, 2025).

1. Nommer les **5 phrases les plus suspectes** du texte, avec la raison de chacune en une ligne. Il y en a toujours 5 : le texte le plus réussi a ses phrases les moins sûres. Les corriger selon `revision.md`.
2. Parcourir la **liste des macro-tics** ci-dessous et cocher ceux qui sont présents.

### Macro-tics (au niveau du texte, invisibles pour le script)

**Partout**
- [ ] Fin de texte ou de section sur une morale, une maxime, un bilan, une antithèse
- [ ] Récapitulatif (« En somme », « Autrement dit », « Au fond », « Bref »)
- [ ] Structure en trois temps égaux, triades anaphoriques (« l'usage compte, le contenu compte, le contexte compte »)
- [ ] Même gabarit de paragraphe répété (affirmation → exemple → chute)
- [ ] Nuance systématique, absence de prise de position, tiédeur polie
- [ ] Aucun jugement ni humour, aucun registre autre que le registre courant
- [ ] Concret « de catalogue » : horaires, jours, café, téléphone, prénoms avec âge exact
- [ ] Mot-concept répété à chaque paragraphe

**Fiction**
- [ ] Phrase qui explique l'effet d'une description ou le sens d'un geste
- [ ] Incises « dit-il / répondit-elle » en série
- [ ] Tension résolue trop vite : réplique d'apaisement, geste tendre final
- [ ] Comparaisons « comme on + verbe », images isolées non filées
- [ ] Le narrateur interprète des indices au lieu de juger les personnes
- [ ] Pas un seul point de suspension, pas une exclamation dans une scène émotionnelle
- [ ] Rafales de phrases d'un mot (« Rien. Personne. Le silence. ») répétées

**Non-fiction**
- [ ] Ouverture par une scène datée (« Il est 17 h 40… ») ou par une idée reçue démontée (« C'est faux. »)
- [ ] « Ce n'est pas X, c'est Y » ou « ni X ni Y » comme thèse
- [ ] Analogie expliquée dans la phrase suivante, une par section
- [ ] « Des études montrent », « les chercheurs » sans source précise
- [ ] Personnage composite à prénom et âge exacts (« Sacha a sept ans ») servant d'exemple universel
- [ ] Intertitres en concepts parallèles, gras, puces symétriques
- [ ] Clôture par injonction (« Essayez cette semaine ») ou promesse (« Vous verrez que… »)
- [ ] « on » générique, absence de « nous » ou de « je » d'auteur
- [ ] Aucun renvoi interne, aucune parenthèse, aucune digression

Chaque case cochée est corrigée, ou justifiée par une ligne dans `jugement.md` (« la triade est voulue : c'est le slogan du personnage »).

## Lecture 2 : l'éditeur (grille fermée, tout doit être « oui »)

| Question | Oui / Non |
|---|---|
| Le sens et les faits du brouillon (ou du texte source en révision) sont-ils intacts ? | |
| Chaque phrase longue se lit-elle d'une traite sans relecture ? | |
| La voix correspond-elle au contrat de la fiche (personne, registre, ponctuation, jugement) du début à la fin ? | |
| Les trois non-dits restent-ils non dits et déductibles ? | |
| Aucune source, aucun chiffre ni aucune anecdote n'est-il inventé et présenté comme réel ? | |
| Aucune faute, coquille ni maladresse n'a-t-elle été introduite volontairement ? | |
| Les corrections ont-elles évité de créer un nouveau tic (même liaison répétée, mêmes points de suspension partout, même verbe d'incise) ? | |
| Le texte est-il au moins aussi bon qu'avant la révision ? Si une phrase était meilleure avant, l'avoir restaurée. | |

## Lecture 3 : la voix haute (mentale)

Lire chaque paragraphe comme à voix haute et marquer :
- les endroits où l'on manque de souffle : phrase trop longue sans appui. La recouper en **une longue et une courte**, jamais en deux moyennes (cela crée de la monotonie et fait ressortir l'écart-type en ✗) ;
- les endroits où l'on bute : construction lourde, la simplifier ;
- les endroits où le rythme devient mécanique : trois phrases de même allure, en refondre une ;
- les **nouveaux tics créés par la révision** : la même liaison répétée, le même verbe d'incise, des points de suspension en fin de chaque paragraphe, des adjectifs greffés.

## Porte 7

- Les 5 phrases suspectes sont traitées.
- Toutes les cases de macro-tics sont décochées ou justifiées.
- La grille de l'éditeur est entièrement à « oui ».
- **Diagnostic final obligatoire** (`diagnostic.py final.md --avant v2.md --cible N`) : la porte 6 doit tenir. Si le jugement l'a fait régresser, revenir sur les retouches du jugement qui l'ont cassée (en général des recoupes en phrases moyennes), pas sur la v2 entière.
- Budget : au plus **trois diagnostics** par texte (brouillon, v2, final), quatre si une v3 a été nécessaire. Au-delà, on tourne en rond : accepter l'écart et le noter.
