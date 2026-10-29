# Diagnostic — genre : explicatif — 840 mots, 45 phrases

## 1. Profil global (zone humaine = p10–p90 du corpus humain du genre)

| Mesure | Valeur | Avant | Zone humaine | Médiane IA | Verdict | Règle |
|---|---|---|---|---|---|---|
| Virgules / 1000 mots | 51.19 | 69.23 | 47.09–69.46 | 77.78 | ✓ | R-PONCT |
| « , et » / 1000 mots | 1.19 | 10.26 | 1.10–6.68 | 5.76 | ✓ | R-PONCT |
| Deux-points / 1000 mots | 2.38 | 2.56 | 2.06–10.87 | 12.14 | ✓ | R-PONCT |
| Guillemets hors dialogue / 1000 | 0.00 | 0.00 | 1.11–10.87 | 10.10 | ✓ | R-PONCT |
| « on » / 1000 mots | 1.19 | 1.28 | 0.00–4.18 | 6.67 | ✓ | R-VOIX |
| « nous » / 1000 mots | 13.10 | 10.26 | 3.41–21.12 | 0.00 | ✓ | R-VOIX |
| Longueur moyenne des phrases (mots) | 22.17 | 24.63 | 14.03–21.93 | 14.65 | ✓ | R-SYNT |
| Écart-type des longueurs | 10.05 | 11.42 | 8.29–11.43 | 8.40 | ✓ | R-SYNT |
| % phrases ≥ 30 mots | 25.00 | 33.33 | 5.00–21.43 | 5.56 | ✓ | R-SYNT |
| Diversité des débuts de phrase | 0.72 | 0.67 | 0.61–0.83 | 0.65 | ✓ | R-OUV |
| % paragraphes ouverts par une phrase courte | 0.00 | 0.00 | 0.00–36.36 | 33.33 | ✓ | R-ARCH |
| Accessoires de fausse concrétude / 1000 | 2.38 | 8.97 | 1.06–6.70 | 9.64 | ✓ | R-LEX |
| Formules typiques IA / 1000 | 0.00 | 0.00 | 0.00–3.18 | 6.16 | ✓ | R-LEX |
| Contrastes correctifs / 1000 | 0.00 | 0.00 | 0.00–1.09 | 1.21 | ✓ | R-LEX |
| Liaisons « humaines » / 1000 | 10.71 | 14.10 | 4.32–14.51 | 1.17 | ✓ | R-LIAIS |
| Adjectifs par nom | 0.28 | 0.26 | 0.28–0.42 | 0.27 | ~ | R-LEX |
| % prépositions | 13.24 | 12.02 | 13.08–17.34 | 12.34 | ~ | R-SYNT |
| % conjonctions de coordination | 2.41 | 3.03 | 2.93–4.25 | 2.81 | ✗ | R-SYNT |
| Subordonnants par phrase | 0.67 | 0.79 | 0.31–0.64 | 0.37 | ✓ | R-SYNT |

Légende : ✓ humain · ~ limite · ✗ côté IA · ⚠ sur-correction (au-delà des humains, dans l'autre sens : à corriger aussi).

## 2. Priorités de révision (par pouvoir discriminant)

- ✗ **% conjonctions de coordination** = 2.41 (trop bas) → viser 3.20–4.06 — voir revision.md §R-SYNT

## 3. Phrases signalées

- §11.2 [L2] « Jean Piaget a noté et classé, dans *Le Langage et la pensée chez l'enfant* (1923), les innombrables questions d'un garçon de six ans. »
    ↳ L2: six
- §11.3 [P1 L2 R1] « Il y remarque que les pourquoi du jeune enfant mélangent deux choses que nous autres adultes séparons sans y penser : la cause d'un événement et l'intention de quelqu'un. »
    ↳ P1: deux-points de révélation ou d'annonce ; L2: deux ; R1: 5 phrases de longueur voisine (25, 24, 18, 22, 28 mots)
- §11.4 [R1] « Demander pourquoi la limace est morte revient aussi à demander qui l'a voulu et dans quel but. »
    ↳ R1: 5 phrases de longueur voisine (24, 18, 22, 28, 17 mots)
- §11.5 [R1] « Piaget parlait de précausalité pour désigner cette façon de chercher derrière chaque fait une volonté, un motif, voire un projet. »
    ↳ R1: 5 phrases de longueur voisine (18, 22, 28, 17, 20 mots)
- §12.3 [O1] « Quand la réponse n'expliquait rien, il répétait sa question parfois mot pour mot ou proposait sa propre explication, exactement comme notre enfant devant la limace. »
    ↳ O1: même premier mot que la phrase précédente (« quand »)
- §12.5 [S3] « contrôle »
    ↳ S3: fragment sans verbe
- §13.3 [V1] « Expliquez que le passant regardait devant lui au lieu de regarder ses pieds, et vous voilà sommé de dire pourquoi les grandes personnes ne regardent jamais leurs pieds, puis pourquoi elles marchent si vite. »
    ↳ V1: virgule avant « et »
- §14.1 [P1] « Il en découle des manières de répondre qui coûtent moins d'énergie qu'il n'y paraît : renvoyer la question à l'enfant ou, plus coûteux pour notre fierté, avouer que nous ne savons pas. »
    ↳ P1: deux-points de révélation ou d'annonce

## 4. Comptage des signalements

R1 Monotonie de longueur : 3, L2 Accessoire de fausse concrétude : 2, P1 Deux-points d'annonce : 2, O1 Ouverture répétée : 1, S3 Fragment sans verbe : 1, V1 Virgule avant « et » : 1

Taux : 22 % des phrases narratives signalées au moins une fois (repère : 25-40 % sur les extraits humains de calibration, 55-80 % sur les textes IA bruts).
