# Diagnostic — genre : fiction — 860 mots, 71 phrases

## 1. Profil global (zone humaine = p10–p90 du corpus humain du genre)

| Mesure | Valeur | Zone humaine | Médiane IA | Verdict | Règle |
|---|---|---|---|---|---|
| Virgules / 1000 mots | 55.81 | 36.99–57.56 | 85.78 | ~ | R-PONCT |
| Virgules par phrase | 0.68 | 0.39–0.73 | 0.77 | ~ | R-PONCT |
| « , et » / 1000 mots | 2.33 | 0.00–2.28 | 7.16 | ✗ | R-PONCT |
| Deux-points / 1000 mots | 0.00 | 0.00–2.37 | 3.91 | ✓ | R-PONCT |
| Guillemets hors dialogue / 1000 | 0.00 | 0.00–1.14 | 1.09 | ✓ | R-PONCT |
| Points de suspension / 1000 | 4.65 | 1.14–10.10 | 0.00 | ✓ | R-EXPR |
| Exclamations / 1000 | 3.49 | 0.00–13.08 | 0.00 | ✓ | R-EXPR |
| « on » / 1000 mots | 2.33 | 0.00–4.54 | 6.13 | ✓ | R-VOIX |
| « nous » / 1000 mots | 3.49 | 0.00–6.87 | 0.00 | ✓ | R-VOIX |
| Longueur moyenne des phrases (mots) | 20.10 | 11.35–16.51 | 11.22 | ✓ | R-SYNT |
| % phrases ≤ 5 mots | 16.67 | 4.44–25.40 | 28.57 | ✓ | R-RYTH |
| Diversité des débuts de phrase | 0.60 | 0.53–0.72 | 0.46 | ✓ | R-OUV |
| % débuts identiques consécutifs | 0.00 | 0.00–9.30 | 12.50 | ✓ | R-OUV |
| % phrases ouvertes par un pronom sujet | 16.67 | 21.57–40.00 | 40.91 | ⚠ | R-OUV |
| % paragraphes ouverts par une phrase courte | 0.00 | 0.00–42.86 | 38.89 | ✓ | R-ARCH |
| Accessoires de fausse concrétude / 1000 | 3.49 | 1.05–5.64 | 16.71 | ✓ | R-LEX |
| Formules typiques IA / 1000 | 0.00 | 0.00–4.51 | 5.11 | ✓ | R-LEX |
| Liaisons « humaines » / 1000 | 4.65 | 3.43–12.33 | 0.00 | ~ | R-LIAIS |
| Adjectifs par nom | 0.27 | 0.23–0.35 | 0.20 | ✓ | R-LEX |
| % prépositions | 15.62 | 12.81–15.95 | 12.26 | ✓ | R-SYNT |
| % conjonctions de coordination | 1.95 | 2.12–3.31 | 2.18 | ✗ | R-SYNT |
| Subordonnants par phrase | 0.23 | 0.19–0.38 | 0.19 | ✓ | R-SYNT |
| Participes présents / 1000 | 2.33 | 2.24–8.89 | 1.96 | ~ | R-SYNT |
| Adverbes en -ment / 1000 | 4.65 | 3.35–12.40 | 4.24 | ~ | R-LEX |

Légende : ✓ humain · ~ limite · ✗ côté IA · ⚠ sur-correction (au-delà des humains, dans l'autre sens : à corriger aussi).

## 2. Priorités de révision (par pouvoir discriminant)

- ✗ **« , et » / 1000 mots** = 2.33 (trop élevé) → viser 0.00–1.17 — voir revision.md §R-PONCT
- ⚠ **% phrases ouvertes par un pronom sujet** = 16.67 (dépassé dans le sens opposé à l'IA) → viser 24.59–34.04 — voir revision.md §R-OUV
- ✗ **% conjonctions de coordination** = 1.95 (trop bas) → viser 2.35–3.05 — voir revision.md §R-SYNT

## 3. Phrases signalées

- §1.3 [V1 L2] « La barque reposait sur sa quille, calée de chaque bord par deux madriers noircis, et sentait le bois mouillé, la vase et le vieux gasoil. »
    ↳ V1: virgule avant « et » ; L2: deux
- §2.2 [R1] « Ange le connaissait de vue depuis le printemps, ce Vasseur qui avait fait planter des piquets orange devant l'ancien séchoir à filets et répétait à qui voulait l'entendre que le village méritait mieux. »
    ↳ R1: 5 phrases de longueur voisine (34, 25, 21, 33, 33 mots)
- §2.3 [R1] « Un grand type souple aux dents de présentateur, qui s'était brodé un bateau sur le cœur pour se dispenser d'en monter un vrai. »
    ↳ R1: 5 phrases de longueur voisine (25, 21, 33, 33, 23 mots)
- §5.1 [R1] « Vasseur rit de bon cœur, d'un rire qui avait dû servir dans bien des réunions, puis posa la main sur le plat-bord à l'endroit précis où la peinture n'était pas encore grattée. »
    ↳ R1: 5 phrases de longueur voisine (21, 33, 33, 23, 32 mots)
- §9.1 [V1] « Le père d'Ange avait baptisé ainsi, par un jour de bonne humeur, un bateau qui n'avait jamais dépassé l'allure d'un homme pressé, et la plaisanterie ne se destinait pas à décorer un hall d'entrée. »
    ↳ V1: virgule avant « et »
- §12.2 [L2] « Ange avait calculé le triple avant la fin de la phrase et s'était surpris à penser, une seconde, à son toit qui fuyait depuis l'hiver. »
    ↳ L2: une seconde
- §14.1 [C1 S3] « Déconcerté »
    ↳ C1: paragraphe ouvert par une phrase très courte ; S3: fragment sans verbe
- §14.2 [C2] « , Vasseur tenta une autre approche. »
    ↳ C2: deux phrases très courtes à la suite
- §21.1 [C1] « Ange racla plus fort. »
    ↳ C1: paragraphe ouvert par une phrase très courte
- §28.4 [V2] « Et le maire, ce pauvre Rolland, qui avait fait ses premiers pas sur cette cale et qui allait y laisser poser des pontons de plastique… Ange sentit sa mâchoire se serrer et le sang lui monter aux oreilles mais ne dit r… »
    ↳ V2: 5 virgules : phrase hachée
- §30.1 [C1 S3] « Vasseur »
    ↳ C1: paragraphe ouvert par une phrase très courte ; S3: fragment sans verbe

## 4. Comptage des signalements

C1 Ouverture courte : 3, R1 Monotonie de longueur : 3, V1 Virgule avant « et » : 2, L2 Accessoire de fausse concrétude : 2, S3 Fragment sans verbe : 2, C2 Rafale de phrases courtes : 1, V2 Phrase hachée de virgules : 1

Taux : 37 % des phrases narratives signalées au moins une fois (repère : 25-40 % sur les extraits humains de calibration, 55-80 % sur les textes IA bruts).
