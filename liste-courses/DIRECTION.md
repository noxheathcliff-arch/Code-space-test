# Direction : Ticket de courses

Mini app de liste de courses, majoritairement noir et blanc. Cahier des charges : le document `Contenu` à la racine du dépôt (persona Monique, 58 ans, peur de « tout casser »).

## Indices
- La liste papier qu'on barre au stylo en rayon : le geste de cocher existe déjà, il faut le garder visible.
- Le ticket de caisse thermique : noir sur blanc, chiffres alignés à droite, pointillés entre le nom et le prix, total en bas.
- La perforation et le geste de détacher : on arrache le ticket à la fin, la souche reste.
- Le carnet à souches : ce qu'on détache n'est pas perdu, une trace reste. C'est le filet de sécurité du `Contenu`.
- L'étiquette de rayon : un nom, un gros prix, sans fioriture. Elle sert de repère pour les produits habituels.
- La peur documentée : « j'appuie au mauvais endroit et tout s'efface ». Les avis se plaignent de listes supprimées sans avertissement.
- La lumière du magasin, la presbytie, une main sur le caddie : gros texte, fort contraste, cibles larges.
- Les conventions à éviter : pastilles de couleur par catégorie, swipe pour supprimer, appui long caché, popups.

## Idée organisatrice
**La liste est un ticket qu'on écrit avant de payer : on la barre en rayon et, quand on la détache, la souche reste.**

Le ticket donne le noir et blanc, les chiffres en mono, les pointillés et les bords déchirés. La perforation sépare le geste fréquent (cocher) du geste rare (terminer), et la souche rend tout récupérable pendant 30 jours.

## Architecture
1. **Ma liste** : le ticket. En-tête de caisse (date), champ d'ajout unique, habituels en raccourcis, compte des produits restants, lignes à cocher, section « Dans le panier », perforation, « Terminer les courses ». « Vider toute la liste » reste tout en bas, loin du reste.
2. **Habituels** : des étiquettes de rayon, les plus achetées d'abord. On les met sur la liste en un geste.
3. **Retrouver** : les souches. Tickets détachés, produits retirés, listes vidées, gardés 30 jours.
4. **Réglages** : taille du texte et monnaie, rien d'autre.

Les parcours critiques gardent les conventions : champ + bouton « Ajouter », case à cocher, barre de navigation à 3 destinations.

## Composants signature
- **La ligne de ticket** : case carrée, nom en gros, pointillés, prix en mono. Toute la ligne coche (cible ≥ 64 px). Cocher dessine un trait sur le nom, remplit la case et range la ligne dans « Dans le panier ». Lecteur d'écran : `role="checkbox"` avec `aria-checked`. En mouvement réduit, le trait apparaît sans être dessiné.
- **La perforation** : pointillés et encoches sur les bords, « détacher ici ». Elle ne se déclenche jamais d'un seul toucher : « Terminer les courses » ouvre une confirmation qui dit ce qui part, ce qui reste, et que le ticket se retrouve pendant 30 jours.

## Typographie
- **Atkinson Hyperlegible Next** (lecture, titres) : dessinée pour les personnes malvoyantes par le Braille Institute. Grande hauteur d'x et lettres très distinctes (I/l/1, O/0), ce qui répond à la presbytie et à la lecture debout.
- **Atkinson Hyperlegible Mono** (prix, date, en-têtes de ticket) : la voix du ticket de caisse, de la même famille, avec des chiffres tabulaires.
- Écartées : IBM Plex Mono (trop « technique »), Courier Prime (trop maigre à l'écran), Lexend (bonne lisibilité mais sans mono assortie).

## Couleur
- Source : le papier thermique et son encre. Neutres très légèrement froids, chroma quasi nulle.
- Clair : comptoir gris clair, papier blanc, encre presque noire. Sombre : papier gris très foncé, encre claire.
- Un seul rôle sémantique en couleur : `danger` (rouge brique), réservé au bouton « Vider la liste » confirmé.

## Forme, matière, profondeur
Coins nets (rayon 0) comme le papier. Plat contour : bordures 2 px d'encre pour les actions, pointillés pour les séparations, bords déchirés en zigzag pour le ticket. Aucune ombre.

## Mouvement
Le moment chorégraphié : **détacher le ticket**. La partie « Dans le panier » descend, pivote légèrement et disparaît (450 ms). Ailleurs : le trait qui barre le nom (350 ms), le surlignage d'un produit ajouté. Tout est coupé en mouvement réduit.

## Densité et rythme
Aéré. Corps de base 18 px, noms de produits 22 px. Réglage de taille : normale, grande, très grande.

## Ce qu'on évite
Swipe pour supprimer, appui long, icônes sans texte, pastilles de couleur par catégorie, « OK / Annuler », « Sauvegarder », comptes et popups.

## Passage à material-design
1. **Couleur** : statique, monochrome, neutres à peine froids ; rôles `surface`, `on-surface`, `on-surface-variant`, `outline`, `outline-variant`, `inverse-surface` ; action principale en `inverse` (fond encre, texte papier) ; `error` seul rôle chromatique.
2. **Typographie** : brand = Atkinson Hyperlegible Next 800 ; plain = Next 400/600 ; utilitaire = Atkinson Hyperlegible Mono pour les nombres.
3. **Forme** : nette, rayon `None` partout.
4. **Profondeur** : plat contour.
5. **Mouvement** : scheme standard, l'expressivité réservée au détachement du ticket.
6. **Densité** : aérée, cibles ≥ 48 dp (lignes 64 dp), taille de texte réglable.
