# Étape 2 : Matière (quoi dire, avec quels éléments)

Le style ne rattrape pas une matière moyenne. Un modèle choisit spontanément l'élément le plus probable : le café qui refroidit, le téléphone qui vibre, l'enfant de sept ans prénommé Léo, la réunion du jeudi, l'étude « qui montre que ». La calibration le confirme en chiffres. Dans les textes IA, les nombres écrits en lettres sont 9 fois plus fréquents en fiction et 3 fois plus en vulgarisation. Les jours de la semaine, les horaires et les objets domestiques reviennent d'un texte à l'autre, quel que soit le sujet.

## 1. Échantillonnage de queue (pour chaque choix clé)

Pour chaque décision qui compte (le détail qui caractérise un lieu, le geste d'un personnage, l'exemple qui illustre une idée, la réplique qui fait basculer une scène, l'image d'un concept), écrire dans `atelier/matiere.md` :

```
CHOIX : (ex. le détail qui montre que la chambre a été fouillée)
1. … ← le plus attendu : ce que presque tout le monde écrirait
2. …
3. …
4. … ← le moins attendu encore plausible
RETENU : n° … parce que … (juste pour CE narrateur ou CET argument, et pas le plus attendu)
```

Règles :
- les options sont classées du plus au moins attendu. Il est inutile de chiffrer des probabilités : le classement suffit ;
- on écarte l'option 1 sauf raison explicite ;
- on écarte aussi ce qui est improbable *et* gratuit (l'étrange pour l'étrange) ;
- on retient en général une option 2 ou 3 qui dit quelque chose du personnage ou de l'argument.

C'est une transposition du *verbalized sampling* (Zhang et al., 2025), qui augmente nettement la diversité des sorties créatives sans entraînement. Il s'applique aux **décisions de contenu**, pas à chaque phrase : **3 à 5 choix** par texte de 1 000 mots suffisent. Au-delà, le coût dépasse le gain.

## 2. Tri anti-accessoires (obligatoire)

Passer chaque élément concret au crible :

| Accessoire | Garder seulement si… | Sinon |
|---|---|---|
| Nombre précis (« quarante minutes », « trois ans », « dix-neuf heures ») | le nombre a une conséquence dans le texte, ou il **est** l'information (heures de sommeil recommandées, prix, dose) ; on l'écrit alors en chiffres s'il est technique | approximation humaine (« une bonne heure », « des années ») ou rien |
| Jour de la semaine, date, heure | l'intrigue ou l'argument en dépend | supprimer |
| Objet domestique standard (café, tasse, cuisine, téléphone, écran, tiroir, carnet, dossier) | il appartient en propre au personnage ou à la situation | le remplacer par un objet qui *caractérise* (un objet que seul ce personnage aurait), ou rien |
| Prénom plus âge exact d'un enfant ou d'un cas (« Sacha, 7 ans ») | le cas est développé et l'âge importe | « un petit garçon », « la fille d'une amie », ou un cas réel fourni |
| Scène d'ouverture datée (« Il est 17 h 40 au supermarché ») | jamais par défaut | ouvrir sur la suite de ce qui précède, ou sur une situation sans horodatage |

## 3. Fiction : ce que le narrateur pense

- Décider de **2 à 4 jugements** que le narrateur ou le personnage focal porte sur les gens de la scène : verdict, mépris, tendresse, ironie, insulte intérieure si la voix l'autorise. Ils seront dits, pas suggérés : c'est un trait humain mesuré.
- Le narrateur n'explique **pas** l'effet de ce qu'il décrit (« C'est ce silence qui me glace ») ni le sens d'un geste (« C'était sa façon de dire pardon »). Il le montre et passe.
- **Émotion** : par le corps (souffle, gorge, poitrine, mains, peau), par l'action interrompue, par un jugement. Les conventions du genre (le cœur qui cogne, le sang qui se glace) sont tolérées *une fois* et dans la voix. La prose IA les évite, et leur absence totale est elle-même un indice.
- **Fin de scène** : choisir une fin *ouverte* (question, action interrompue, réplique qui reste en suspens, phrase en points de suspension), et pas un geste accompli ni une réplique d'apaisement.

## 4. Non-fiction : ancrage

- **Sources** : uniquement réelles et vérifiables (auteur, ouvrage, institution). Jamais « des études montrent » seul. Jamais de chercheur, de chiffre ou de titre inventé. Si l'utilisateur n'en fournit pas et que l'on n'en connaît aucune avec certitude, on écrit sans source plutôt qu'avec une fausse, ou on marque `[SOURCE À FOURNIR]`.
- **Expérience d'auteur** : les auteurs humains du corpus parlent en « nous » ou en « je » de leur pratique, de leurs enfants, de leurs patients. On ne l'invente pas. On la demande à l'utilisateur, ou on prend la forme du cas illustratif assumé (« Prenons une mère qui… »), qui est un procédé humain courant et légitime. On peut aussi écrire `[ANECDOTE PERSONNELLE À FOURNIR : situation où…]`. Le « nous » inclusif (« lorsque nous sommes fatigués ») reste toujours disponible.
- **Introduire par un cas**, puis généraliser. On ne fait pas l'inverse, et on ne commence jamais par démonter une idée reçue (« On dit que… C'est faux. ») : c'est un tic IA systématique en vulgarisation.
- **Une image filée** sur plusieurs paragraphes (le lecteur de DVD intérieur qu'on met sur pause, qu'on rembobine…) plutôt qu'une analogie par section expliquée dans la phrase suivante.
- **Renvois internes** quand le texte s'inscrit dans un ensemble (« nous y reviendrons », « comme au chapitre précédent »). Les textes humains en contiennent, les textes IA jamais.

## Porte 2

Pour chaque élément retenu, une ligne répond à « pourquoi celui-ci et pas le plus probable ? ». Aucun accessoire non justifié ne subsiste. Aucune source, aucun chiffre ni aucune anecdote n'est présenté comme réel sans l'être.
