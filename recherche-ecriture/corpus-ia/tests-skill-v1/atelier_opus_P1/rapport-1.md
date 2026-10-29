# Diagnostic — genre : pratique — 825 mots, 41 phrases

## 1. Profil global (zone humaine = p10–p90 du corpus humain du genre)

| Mesure | Valeur | Zone humaine | Médiane IA | Verdict | Règle |
|---|---|---|---|---|---|
| Virgules / 1000 mots | 47.27 | 33.41–52.16 | 70.03 | ✓ | R-PONCT |
| Virgules par phrase | 0.95 | 0.46–0.91 | 0.93 | ✗ | R-PONCT |
| « , et » / 1000 mots | 1.21 | 0.00–2.21 | 5.31 | ~ | R-PONCT |
| Deux-points / 1000 mots | 1.21 | 1.00–12.37 | 9.38 | ✓ | R-PONCT |
| Guillemets hors dialogue / 1000 | 0.00 | 0.00–0.00 | 4.83 | ✓ | R-PONCT |
| Points de suspension / 1000 | 0.00 | 0.00–3.30 | 0.00 | ✓ | R-EXPR |
| Exclamations / 1000 | 0.00 | 0.00–3.42 | 0.00 | ✓ | R-EXPR |
| Parenthèses / 1000 | 2.42 | 0.00–3.21 | 0.00 | ✓ | R-EXPR |
| « on » / 1000 mots | 0.00 | 0.00–4.50 | 7.83 | ✓ | R-VOIX |
| Longueur moyenne des phrases (mots) | 20.17 | 12.01–18.25 | 12.89 | ✓ | R-SYNT |
| Écart-type des longueurs | 10.32 | 6.93–10.48 | 7.20 | ✓ | R-SYNT |
| % phrases ≥ 30 mots | 21.95 | 1.37–14.29 | 2.63 | ⚠ | R-SYNT |
| Diversité des débuts de phrase | 0.68 | 0.55–0.78 | 0.62 | ✓ | R-OUV |
| % phrases ouvertes par un pronom sujet | 24.39 | 8.77–30.77 | 23.33 | ✓ | R-OUV |
| % paragraphes ouverts par une phrase courte | 0.00 | 7.69–33.33 | 27.27 | ✓ | R-ARCH |
| Accessoires de fausse concrétude / 1000 | 0.00 | 0.00–4.27 | 4.16 | ✓ | R-LEX |
| Formules typiques IA / 1000 | 0.00 | 0.00–3.36 | 4.38 | ✓ | R-LEX |
| Contrastes correctifs / 1000 | 0.00 | 0.00–2.28 | 1.63 | ✓ | R-LEX |
| Liaisons « humaines » / 1000 | 7.27 | 7.62–15.62 | 2.10 | ✗ | R-LIAIS |
| Adjectifs par nom | 0.27 | 0.30–0.52 | 0.33 | ✗ | R-LEX |
| % prépositions | 15.57 | 11.47–16.10 | 11.77 | ✓ | R-SYNT |
| % conjonctions de coordination | 3.12 | 2.62–4.12 | 2.26 | ✓ | R-SYNT |
| Participes présents / 1000 | 3.64 | 2.08–8.12 | 2.08 | ✓ | R-SYNT |
| Adverbes en -ment / 1000 | 13.33 | 8.12–23.97 | 10.37 | ✓ | R-LEX |

Légende : ✓ humain · ~ limite · ✗ côté IA · ⚠ sur-correction (au-delà des humains, dans l'autre sens : à corriger aussi).

## 2. Priorités de révision (par pouvoir discriminant)

- ✗ **Liaisons « humaines » / 1000** = 7.27 (trop bas) → viser 9.70–14.84 — voir revision.md §R-LIAIS
- ✗ **Virgules par phrase** = 0.95 (trop élevé) → viser 0.49–0.84 — voir revision.md §R-PONCT
- ✗ **Adjectifs par nom** = 0.27 (trop bas) → viser 0.34–0.43 — voir revision.md §R-LEX
- ⚠ **% phrases ≥ 30 mots** = 21.95 (dépassé dans le sens opposé à l'IA) → viser 3.39–11.32 — voir revision.md §R-SYNT

## 3. Phrases signalées

- §1.2 [P1] « La soirée a été franchement bonne : il a ri, raconté quelques histoires qui ont porté et mangé plus que de raison sans se sentir un seul instant en dessous de qui que ce soit. »
    ↳ P1: deux-points de révélation ou d'annonce
- §1.9 [O1] « Il coupe le moteur et reste un long moment dans la voiture, en tête à tête avec lui. »
    ↳ O1: même premier mot que la phrase précédente (« il »)
- §2.1 [V1] « Pourquoi ces gens-là, et pas un milliardaire ou une actrice dont il connaît pourtant la vie bien mieux que celle de ses camarades ? »
    ↳ V1: virgule avant « et »
- §2.3 [R1] « Lorsqu'aucune mesure objective n'est disponible, ce qui est évidemment le cas pour la réussite d'une vie, nous nous évaluons en nous mesurant aux autres et choisissons de préférence ceux qui nous ressemblent. »
    ↳ R1: 5 phrases de longueur voisine (33, 18, 23, 28, 32 mots)
- §4.5 [S3] « Quant au sang »
    ↳ S3: fragment sans verbe
- §4.6 [C2 S3] « froid »
    ↳ C2: deux phrases très courtes à la suite ; S3: fragment sans verbe
- §5.4 [S3] « Notez »
    ↳ S3: fragment sans verbe
- §5.8 [O1] « Peut-être aussi découvrirez-vous que vous n'enviiez que la médaille, ce qui vous renseigne tout autant et vous épargne les genoux. »
    ↳ O1: même premier mot que la phrase précédente (« peut-être »)

## 4. Comptage des signalements

S3 Fragment sans verbe : 3, O1 Ouverture répétée : 2, P1 Deux-points d'annonce : 1, V1 Virgule avant « et » : 1, C2 Rafale de phrases courtes : 1, R1 Monotonie de longueur : 1

Taux : 20 % des phrases narratives signalées au moins une fois (repère : 25-40 % sur les extraits humains de calibration, 55-80 % sur les textes IA bruts).
