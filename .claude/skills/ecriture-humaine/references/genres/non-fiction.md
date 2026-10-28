# Genre : non-fiction (essai, article, chronique, billet, développement personnel, vulgarisation)

Profils :
- `--genre pratique` (développement personnel, guide, conseil) : calibré sur un livre de développement personnel français de 2021 ;
- `--genre explicatif` (vulgarisation, pédagogie) : calibré sur un livre de psychologie de l'enfant traduit de l'anglais par une traductrice humaine ;
- `--genre essai` (essai, article, chronique, billet) : profil mixte des deux.

Les comparaisons portent sur 30 textes IA par genre, plus 8 textes « divers » (essai, article, chronique, lettre, billet).

## Ce qui sépare le plus la non-fiction humaine de la non-fiction IA

1. **Virgules** : 44 à 58 pour 1000 mots contre 70 à 78.
2. **« on » générique** : 1 à 2 contre 7 à 8.
3. **« nous » d'auteur** : 11 contre 0 en vulgarisation.
4. **Deux-points d'annonce** : « Résultat : », « Le piège : ».
5. **Guillemets** : citations de phrases-types (développement personnel : 0 chez l'humain contre 5 pour 1000 mots).
6. **Liaisons classiques** : 9 à 11 contre 1 à 2.
7. **Phrases longues (≥ 30 mots)** : 8 à 13 % contre 3 à 6 %.
8. **Prépositions et coordination** : nettement plus fréquentes chez l'humain.

À la lecture, on observe aussi :
- l'ancrage humain : auteurs nommés, expérience propre, renvois à d'autres chapitres ;
- l'humour et les apartés entre parenthèses ;
- les fins sur une scène ou une annonce plutôt que sur une maxime ;
- les listes irrégulières.

## Procédure spécifique

**Avant la rédaction (étape 2)**
- **Thèse** : l'écrire en une phrase dans la fiche… puis la mettre dans les non-dits si possible. Le lecteur doit la tirer du cas.
- **Ancrage** : lister ce qui est réel et disponible (sources connues avec certitude, expériences fournies par l'utilisateur). Le reste se marque `[À FOURNIR]`. Ne jamais compléter par de l'invention.
- **Cas d'entrée** : une situation reconnaissable par le lecteur. Pas datée à la minute, pas « Sacha, 7 ans » par défaut.
- **Image filée** : une image de travail pour tout le passage (choisie par échantillonnage de queue), reprise 2 à 4 fois.
- **Plan** : asymétrique. Si des intertitres sont nécessaires, à l'impératif, à l'infinitif ou en libellé concret (« Dire non au patron », « Quand la crise éclate au supermarché »), jamais en concepts parallèles.

**Pendant la rédaction (étape 4)**
- Voix d'auteur en « nous » ou « je », avec « vous » pour le lecteur. « on » réservé aux expressions figées.
- Phrases de raisonnement longues : cause, condition, concession, construites avec des liaisons (« lorsque », « afin de », « bien que », « ainsi », « il s'agit de »).
- Une parenthèse d'aparté ou d'exemple par section, une pointe d'humour si la fiche l'autorise.
- Conseils formulés directement (impératif, « vous pouvez ») plutôt que « il faut » répété.
- Listes seulement si le contenu est vraiment énumératif. Les rendre irrégulières (longueurs différentes, un élément commenté).
- Fin : une annonce de la suite, un cas qui reste ouvert, un conseil concret. Jamais de maxime, de bilan, d'injonction « essayez cette semaine » ni de promesse de résultat.

**Révision (étape 6) : priorités non-fiction**
1. L3 (« on »), P1 (deux-points), guillemets, S1 (contrastes « ce n'est pas X, c'est Y »).
2. V1 et V2 (virgules) ; fusion des phrases courtes en raisonnements longs.
3. Liaisons, prépositions, « nous ».
4. Macro-tics de `jugement.md` : ouverture par une idée reçue, analogie expliquée, chute aphoristique, sources vagues.

## Articles de presse et chroniques

Pas de profil de calibration propre (aucun corpus de presse fourni) : utiliser `--genre essai` et les mêmes principes.

Conventions humaines à respecter :
- **Article d'information** : attaque factuelle, citations réelles attribuées, pas de morale.
- **Chronique** : un « je » qui tranche, de la mauvaise foi assumée, une chute qui n'est pas une leçon.

Si l'utilisateur fournit des articles de référence, construire un profil dédié (`construire_profil.py --genre presse`).
