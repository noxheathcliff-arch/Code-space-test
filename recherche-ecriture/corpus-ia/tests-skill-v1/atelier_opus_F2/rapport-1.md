# Diagnostic — genre : fiction — 795 mots, 62 phrases

## 1. Profil global (zone humaine = p10–p90 du corpus humain du genre)

| Mesure | Valeur | Zone humaine | Médiane IA | Verdict | Règle |
|---|---|---|---|---|---|
| Virgules / 1000 mots | 65.41 | 36.99–57.56 | 85.78 | ✗ | R-PONCT |
| Virgules par phrase | 0.84 | 0.39–0.73 | 0.77 | ✗ | R-PONCT |
| « , et » / 1000 mots | 0.00 | 0.00–2.28 | 7.16 | ✓ | R-PONCT |
| Deux-points / 1000 mots | 0.00 | 0.00–2.37 | 3.91 | ✓ | R-PONCT |
| Guillemets hors dialogue / 1000 | 0.00 | 0.00–1.14 | 1.09 | ✓ | R-PONCT |
| Points de suspension / 1000 | 5.03 | 1.14–10.10 | 0.00 | ✓ | R-EXPR |
| Exclamations / 1000 | 10.06 | 0.00–13.08 | 0.00 | ✓ | R-EXPR |
| « on » / 1000 mots | 0.00 | 0.00–4.54 | 6.13 | ✓ | R-VOIX |
| « nous » / 1000 mots | 1.26 | 0.00–6.87 | 0.00 | ✓ | R-VOIX |
| Longueur moyenne des phrases (mots) | 19.66 | 11.35–16.51 | 11.22 | ✓ | R-SYNT |
| % phrases ≤ 5 mots | 3.12 | 4.44–25.40 | 28.57 | ⚠ | R-RYTH |
| Diversité des débuts de phrase | 0.66 | 0.53–0.72 | 0.46 | ✓ | R-OUV |
| % débuts identiques consécutifs | 6.45 | 0.00–9.30 | 12.50 | ✓ | R-OUV |
| % phrases ouvertes par un pronom sujet | 34.38 | 21.57–40.00 | 40.91 | ~ | R-OUV |
| % paragraphes ouverts par une phrase courte | 16.67 | 0.00–42.86 | 38.89 | ✓ | R-ARCH |
| Accessoires de fausse concrétude / 1000 | 5.03 | 1.05–5.64 | 16.71 | ~ | R-LEX |
| Formules typiques IA / 1000 | 1.26 | 0.00–4.51 | 5.11 | ✓ | R-LEX |
| Liaisons « humaines » / 1000 | 5.03 | 3.43–12.33 | 0.00 | ~ | R-LIAIS |
| Adjectifs par nom | 0.19 | 0.23–0.35 | 0.20 | ✗ | R-LEX |
| % prépositions | 15.38 | 12.81–15.95 | 12.26 | ✓ | R-SYNT |
| % conjonctions de coordination | 1.53 | 2.12–3.31 | 2.18 | ✗ | R-SYNT |
| Subordonnants par phrase | 0.45 | 0.19–0.38 | 0.19 | ✓ | R-SYNT |
| Participes présents / 1000 | 10.06 | 2.24–8.89 | 1.96 | ✓ | R-SYNT |
| Adverbes en -ment / 1000 | 3.77 | 3.35–12.40 | 4.24 | ~ | R-LEX |

Légende : ✓ humain · ~ limite · ✗ côté IA · ⚠ sur-correction (au-delà des humains, dans l'autre sens : à corriger aussi).

## 2. Priorités de révision (par pouvoir discriminant)

- ✗ **Virgules / 1000 mots** = 65.41 (trop élevé) → viser 41.81–53.24 — voir revision.md §R-PONCT
- ✗ **Adjectifs par nom** = 0.19 (trop bas) → viser 0.26–0.32 — voir revision.md §R-LEX
- ⚠ **% phrases ≤ 5 mots** = 3.12 (dépassé dans le sens opposé à l'IA) → viser 8.70–18.37 — voir revision.md §R-RYTH
- ✗ **Virgules par phrase** = 0.84 (trop élevé) → viser 0.45–0.63 — voir revision.md §R-PONCT
- ✗ **% conjonctions de coordination** = 1.53 (trop bas) → viser 2.35–3.05 — voir revision.md §R-SYNT

## 3. Phrases signalées

- §1.1 [L2] « Comme tous les matins depuis la sixième, je garde la place de Justine avec mon sac et m'écrase contre la vitre, à côté du dossier où nos initiales sont gravées au compas, un J et un M de travers que personne n'a jamai… »
    ↳ L2: dossier
- §5.1 [O1] « Elle me tend son avant-bras, sur lequel je ne vois rien d'autre qu'une peau dorée qui n'avait pas cette couleur avant-hier. »
    ↳ O1: même premier mot que la phrase précédente (« elle »)
- §9.1 [O1 O2] « Elle rit trop fort en se tortillant sur la banquette, comme si le skaï lui brûlait les cuisses. »
    ↳ O1: même premier mot que la phrase précédente (« elle ») ; O2: troisième phrase de suite ouverte par un pronom sujet
- §9.2 [O2] « Je regarde défiler les champs de colza sans répondre, parce que je n'ai aucune envie de lui expliquer que les mamies, au moins, ont quelqu'un avec qui jouer. »
    ↳ O2: troisième phrase de suite ouverte par un pronom sujet
- §13.1 [R1] « Les rires roulent jusqu'à l'avant du bus, où le chauffeur monte le son de sa radio sans se retourner. »
    ↳ R1: 5 phrases de longueur voisine (21, 18, 28, 24, 19 mots)
- §13.3 [L2] « Elle fixe nos initiales sur le dossier avec une application d'élève modèle tandis que ses oreilles virent au cramoisi. »
    ↳ L2: dossier
- §13.6 [L1] « Cette dinde s'est toujours crue dans une série américaine, avec sa piscine à débordement et sa mère en peignoir blanc qui distribue des esquimaux au bord de l'eau. »
    ↳ L1: débordement
- §27.2 [V2 L2] « Elle m'avait tout raconté au retour, la belle-mère qui cuisine des lasagnes au tofu, le demi-frère qui ronfle à travers la cloison, les documentaires animaliers du soir, toutes ces misères que j'avais plaintes de bon … »
    ↳ V2: 4 virgules : phrase hachée ; L2: cuisine

## 4. Comptage des signalements

L2 Accessoire de fausse concrétude : 3, O1 Ouverture répétée : 2, O2 Série de pronoms sujets : 2, L1 Formule IA : 1, V2 Phrase hachée de virgules : 1, R1 Monotonie de longueur : 1

Taux : 25 % des phrases narratives signalées au moins une fois (repère : 25-40 % sur les extraits humains de calibration, 55-80 % sur les textes IA bruts).
