# Genre : fiction (roman, nouvelle, scène, récit, dialogue)

Profil : `--genre fiction`. Calibré sur un roman français contemporain à la première personne du présent (deux narrateurs alternés, registre courant à familier, romance sombre et suspense), comparé à 30 scènes générées par Claude sur des consignes du même type.

## Ce qui sépare le plus la fiction humaine de la fiction IA (|δ| ≥ 0,8)

1. **Virgules** : 47 pour 1000 mots contre 86. La phrase humaine avance par compléments et verbes coordonnés. La phrase IA juxtapose.
2. **« , et »** : 1 contre 7.
3. **Accessoires** : 2 contre 17 pour 1000 mots (nombres en lettres, horaires, café, téléphone…).
4. **Liaisons classiques** : 8 contre 0.
5. **Points de suspension** : 4 contre 0.
6. **Diversité des débuts de phrase** : 0,62 contre 0,46. L'IA enchaîne « Je… Je… Il… Il… ».
7. **Incises neutres** : 0 % contre 83 %.
8. **Adjectifs par nom** : 0,29 contre 0,20.
9. **Phrases de 5 mots ou moins** : 14 % contre 29 %.

## Procédure spécifique (s'ajoute au pipeline)

**Avant la rédaction (étape 2)**
- **Fiche de scène** : ce que le personnage focal veut, ce qui l'en empêche, ce qui change à la fin. Ce changement ne doit pas être un apaisement.
- **Jugements** : 2 à 4 jugements du narrateur sur les personnes présentes (cf. `matiere.md` §3).
- **Images** : un champ métaphorique dominant pour la scène (choisi par échantillonnage de queue), filé sur 2 ou 3 occurrences.
- **Dialogue** : ce que chaque personnage veut dans l'échange et ce qu'il ne dira pas. Au moins une réplique esquive, une ment ou répond à côté.

**Pendant la rédaction (étape 4)**
- Narration : phrases moyennes à longues, verbes coordonnés, peu de virgules, participes et gérondifs. Ouvertures variées.
- Voix intérieure : exclamations, points de suspension, questions, verdicts secs (« Pathétique. »), mots familiers si le contrat l'autorise.
- Émotion : par le corps, l'action interrompue, le jugement. Jamais par une phrase d'explication.
- Dialogue : peu d'incises ; quand il en faut, verbe d'attitude ou action. Les répliques s'interrompent, se chevauchent, n'aboutissent pas.
- Fin : ouverte (question, réplique en suspens, action interrompue, menace).

**Révision (étape 6) : priorités fiction**
1. V1 et V2 (virgules), L2 (accessoires), O1 et O2 (ouvertures) : ce sont les plus fréquents en premier jet.
2. Incises neutres → verbes d'attitude ou suppression.
3. Ajouter les points de suspension et les exclamations là où la voix les appelle.
4. Supprimer toute phrase de glose (« C'est ce détail qui… »).

## Ce qu'il ne faut pas faire au nom de l'« humain »

- Saturer le texte de familiarités ou d'insultes que la voix ne justifie pas.
- Mettre des points de suspension à chaque fin de paragraphe : la zone haute est de 10 pour 1000 mots.
- Copier les clichés de genre en série. Une convention par scène suffit, de préférence un peu détournée.
- Écrire des phrases interminables : la zone fiction est de 11 à 16,5 mots en moyenne.

## Variantes de voix

- **Passé simple, troisième personne, registre soutenu** : les mêmes principes s'appliquent (virgules, accessoires, ouvertures, incises). La zone de ponctuation expressive baisse. Construire un profil dédié avec `construire_profil.py` si l'utilisateur fournit des textes de référence.
- **Polar sec, phrases brèves** : accepter une longueur moyenne basse si c'est le contrat. Compenser par une virgule rare, aucun accessoire, des ouvertures variées et des verbes coordonnés.
