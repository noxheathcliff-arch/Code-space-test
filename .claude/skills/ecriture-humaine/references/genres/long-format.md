# Long format (au-delà de 4 000 mots, livre, série de chapitres)

Un livre entier est le cas le plus exigeant. Les tics se cumulent, la voix dérive, et un détecteur qui découpe le texte en fenêtres dispose de centaines d'occasions de repérer un motif récurrent. Le long format exige donc deux choses en plus : une **mémoire de voix** et un **suivi des tics transversaux**.

## Dispositif

```
livre/
  bible-de-voix.md        ← une fois, avant le chapitre 1
  journal-des-tics.md     ← mis à jour après chaque chapitre
  plan.md                 ← arc général, rôle de chaque chapitre
  chapitres/01.md, 02.md, …
  atelier/                ← fiches, matière, rapports par chapitre
```

### Bible de voix (une fois)
Elle regroupe :
- le contrat de voix complet de `cadrage.md`, valable pour tout le livre ;
- **la grammaire propre** de cette voix : longueur de phrase, ponctuation expressive, registre, mots familiers autorisés, tournures signatures (5 à 10, inventées pour le livre) ;
- **les champs d'images** du livre (2 ou 3) et ceux qui sont exclus ;
- pour chaque personnage qui parle : façon de parler (longueur des répliques, tics de langage, registre, ce qu'il ne dit jamais).

### Journal des tics (après chaque chapitre)
Après le diagnostic de chaque chapitre, noter :
- les formules, images, gestes et constructions qui reviennent (le script en mode `--dossier` liste les 4-grammes présents dans au moins 3 chapitres) ;
- les gestes récurrents des personnages (se passer la main dans les cheveux, serrer la mâchoire, hausser les épaules). Au-delà de deux occurrences dans le livre, l'interdire pour la suite ;
- la liste « déjà utilisé, ne plus employer » : images, comparaisons, ouvertures de chapitre.

Le journal est relu à l'étape 2 de chaque nouveau chapitre.

## Procédure par chapitre

1. Étapes 1 à 3 du pipeline : fiche réduite, qui hérite de la bible ; matière avec relecture du journal des tics ; plan du chapitre.
2. Étape 4 : rédaction **scène par scène**, de 1 500 à 3 000 mots par passage.
3. Étapes 5 et 6 : diagnostic et révision par scène.
4. Étape 7 : jugement adverse sur le chapitre entier.
5. Diagnostic transversal : `python3 scripts/diagnostic.py --dossier livre/chapitres --genre fiction`. Tout 4-gramme non banal présent dans 3 chapitres ou plus est examiné et varié.
6. Mise à jour du journal des tics.

## Contrôles de cohérence sur le livre

- **Variance entre chapitres** : les mesures d'un chapitre à l'autre ne doivent pas être identiques. Un livre humain respire : un chapitre d'action a plus de phrases courtes, un chapitre d'introspection plus de phrases longues. Si tous les chapitres ont exactement le même profil, varier le contrat chapitre par chapitre dans les limites de la bible.
- **Ouvertures et fins de chapitre** : les lister toutes à la suite. Elles ne doivent pas suivre le même gabarit (chapitre qui s'ouvre sur une phrase courte, se ferme sur un suspense en phrase isolée…).
- **Dérive de voix** : relire le premier et le dernier chapitre l'un après l'autre. Le narrateur doit être reconnaissable.

## Coût

Pour un livre de 80 000 mots : environ 30 à 50 passages rédigés et révisés. Le diagnostic coûte quelques secondes par chapitre. Le coût réel est la révision : c'est là qu'il faut investir, pas dans des réécritures complètes.
