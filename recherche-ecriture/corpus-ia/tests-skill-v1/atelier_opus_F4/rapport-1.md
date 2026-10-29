# Diagnostic — genre : fiction — 820 mots, 67 phrases

## 1. Profil global (zone humaine = p10–p90 du corpus humain du genre)

| Mesure | Valeur | Zone humaine | Médiane IA | Verdict | Règle |
|---|---|---|---|---|---|
| Virgules / 1000 mots | 43.90 | 36.99–57.56 | 85.78 | ✓ | R-PONCT |
| Virgules par phrase | 0.54 | 0.39–0.73 | 0.77 | ✓ | R-PONCT |
| « , et » / 1000 mots | 0.00 | 0.00–2.28 | 7.16 | ✓ | R-PONCT |
| Deux-points / 1000 mots | 0.00 | 0.00–2.37 | 3.91 | ✓ | R-PONCT |
| Guillemets hors dialogue / 1000 | 0.00 | 0.00–1.14 | 1.09 | ✓ | R-PONCT |
| Points de suspension / 1000 | 3.66 | 1.14–10.10 | 0.00 | ✓ | R-EXPR |
| Exclamations / 1000 | 2.44 | 0.00–13.08 | 0.00 | ✓ | R-EXPR |
| « on » / 1000 mots | 2.44 | 0.00–4.54 | 6.13 | ✓ | R-VOIX |
| « nous » / 1000 mots | 1.22 | 0.00–6.87 | 0.00 | ✓ | R-VOIX |
| Longueur moyenne des phrases (mots) | 17.69 | 11.35–16.51 | 11.22 | ✓ | R-SYNT |
| % phrases ≤ 5 mots | 17.95 | 4.44–25.40 | 28.57 | ✓ | R-RYTH |
| Diversité des débuts de phrase | 0.51 | 0.53–0.72 | 0.46 | ✗ | R-OUV |
| % débuts identiques consécutifs | 10.53 | 0.00–9.30 | 12.50 | ✗ | R-OUV |
| % phrases ouvertes par un pronom sujet | 35.90 | 21.57–40.00 | 40.91 | ~ | R-OUV |
| % paragraphes ouverts par une phrase courte | 16.67 | 0.00–42.86 | 38.89 | ✓ | R-ARCH |
| Accessoires de fausse concrétude / 1000 | 1.22 | 1.05–5.64 | 16.71 | ✓ | R-LEX |
| Formules typiques IA / 1000 | 0.00 | 0.00–4.51 | 5.11 | ✓ | R-LEX |
| Liaisons « humaines » / 1000 | 4.88 | 3.43–12.33 | 0.00 | ~ | R-LIAIS |
| Adjectifs par nom | 0.19 | 0.23–0.35 | 0.20 | ✗ | R-LEX |
| % prépositions | 16.57 | 12.81–15.95 | 12.26 | ✓ | R-SYNT |
| % conjonctions de coordination | 2.23 | 2.12–3.31 | 2.18 | ~ | R-SYNT |
| Subordonnants par phrase | 0.27 | 0.19–0.38 | 0.19 | ✓ | R-SYNT |
| Participes présents / 1000 | 6.10 | 2.24–8.89 | 1.96 | ✓ | R-SYNT |
| Adverbes en -ment / 1000 | 6.10 | 3.35–12.40 | 4.24 | ✓ | R-LEX |

Légende : ✓ humain · ~ limite · ✗ côté IA · ⚠ sur-correction (au-delà des humains, dans l'autre sens : à corriger aussi).

## 2. Priorités de révision (par pouvoir discriminant)

- ✗ **Diversité des débuts de phrase** = 0.51 (trop bas) → viser 0.57–0.68 — voir revision.md §R-OUV
- ✗ **Adjectifs par nom** = 0.19 (trop bas) → viser 0.26–0.32 — voir revision.md §R-LEX
- ✗ **% débuts identiques consécutifs** = 10.53 (trop élevé) → viser 2.33–6.90 — voir revision.md §R-OUV

## 3. Phrases signalées

- §1.2 [O1] « Le reste de la vitrine dort déjà dans mon sac, chaque pièce roulée dans une chaussette de laine, alors que je devrais être dans l'escalier depuis un bon moment. »
    ↳ O1: même premier mot que la phrase précédente (« le »)
- §6.2 [S3] « Bravo, ma grande. »
    ↳ S3: fragment sans verbe
- §7.1 [C1 O1 S3] « La fenêtre… non. »
    ↳ C1: paragraphe ouvert par une phrase très courte ; O1: même premier mot que la phrase précédente (« la ») ; S3: fragment sans verbe
- §7.2 [O1] « La cour pavée est bien trop basse pour mes chevilles. »
    ↳ O1: même premier mot que la phrase précédente (« la »)
- §16.1 [C1 S3] « Évidemment »
    ↳ C1: paragraphe ouvert par une phrase très courte ; S3: fragment sans verbe
- §24.1 [O1 L2] « Il s'assoit dans le fauteuil le plus proche de la porte, pose doucement ses gants sur son genou et ne cherche pas son téléphone. »
    ↳ O1: même premier mot que la phrase précédente (« il ») ; L2: téléphone
- §28.2 [R1] « Je serre l'ivoire à m'en marquer la paume, exactement comme une gamine prise avec un bonbon volé. »
    ↳ R1: 5 phrases de longueur voisine (16, 24, 20, 13, 17 mots)
- §28.3 [S3] « Pathétique. »
    ↳ S3: fragment sans verbe

## 4. Comptage des signalements

O1 Ouverture répétée : 4, S3 Fragment sans verbe : 4, C1 Ouverture courte : 2, L2 Accessoire de fausse concrétude : 1, R1 Monotonie de longueur : 1

Taux : 21 % des phrases narratives signalées au moins une fois (repère : 25-40 % sur les extraits humains de calibration, 55-80 % sur les textes IA bruts).
