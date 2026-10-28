# Protocole d'évaluation du skill

Objectif : mesurer une amélioration **réelle et reproductible**, et non conclure à partir d'un texte ou d'un score isolé.

## 1. Conditions comparées

| Code | Condition |
|---|---|
| A | Claude sans skill (consigne seule) |
| B | Claude avec le skill `ecriture-humaine` (pipeline complet) |
| H | Textes humains de référence du même genre, **récents et jamais publiés en ligne** si possible (les vôtres, ceux de proches consentants) |
| (D) | Facultatif : un « humaniseur » commercial appliqué à A, comme témoin de dégradation du sens |

## 2. Jeux de consignes

- **Développement** : `consignes_fiction.txt`, `consignes_pratique.txt`, `consignes_explicatif.txt` et `consignes_essai.txt`, qui ont servi à la calibration. Ils servent à régler le skill.
- **Test** : un jeu de consignes **nouveau**, écrit avant de lancer les textes et jamais utilisé pour régler le skill. Il compte au moins 10 consignes par genre, sur deux longueurs : environ 900 mots et environ 2 500 mots. Le figer (date, version du skill) dans `eval/test-AAAA-MM-JJ.txt`.
- **Long format** : 2 chapitres de 5 000 à 8 000 mots minimum, pour mesurer la tenue de la voix et les tics transversaux.

## 3. Mesures

### 3.1 Diagnostic interne (gratuit, instantané)
```
python3 scripts/lot.py --genre fiction --groupe A sorties/A/ --groupe B sorties/B/ --groupe H refs/
```
Rapporter, pour chaque groupe : médiane du nombre de ✗ et de ⚠, médiane du % de phrases signalées, mesures clés. Une amélioration crédible rapproche B de H **sans dépasser** H, c'est-à-dire sans ⚠.

Attention : ce diagnostic est le critère que le skill optimise. Il ne peut pas servir seul à prouver l'effet (loi de Goodhart). Il sert à vérifier que le pipeline a été appliqué.

### 3.2 Détecteur externe (Pangram ou autre)
- **Conditions d'usage** : lire d'abord les conditions d'utilisation du détecteur. Pangram accorde une licence « pour usage interne ». Un usage d'évaluation ponctuel, par lots, est le seul compatible avec l'esprit de ce protocole.
- **Le détecteur n'entre JAMAIS dans la boucle d'écriture.** On ne régénère pas un texte jusqu'à ce qu'il passe : cela mesurerait la capacité à exploiter le détecteur, pas la qualité de l'écriture, et le résultat ne tiendrait pas à la mise à jour suivante.
- **Procédure** :
  1. Soumettre **tous** les textes des conditions A, B et H du jeu de test, sans sélection.
  2. Noter pour chacun l'étiquette (IA / mixte / humain), le score ou la fraction IA, et pour les textes longs le profil par segments.
  3. Noter la **date** et la **version** du détecteur.
- **Rapport** :
  - par condition, la proportion de textes classés humains, avec un intervalle de confiance à 95 % (Wilson ou bootstrap) ;
  - le **taux de faux positifs sur H** (humains classés IA). S'il n'est pas proche de 0, toutes les conclusions sont fragiles.
- **Ce qu'on peut conclure** : « À la date X, sur N textes définis à l'avance, le détecteur Y a classé humains p % des textes B (IC [a ; b]) contre q % des textes A. »
- **Ce qu'on ne peut pas conclure** : qu'un texte est « indétectable ». Les détecteurs évoluent, Pangram se réentraîne notamment sur les sorties d'humaniseurs, et un résultat ponctuel ne vaut que pour la version testée.
- **Attente réaliste** : sur des textes générés intégralement par Claude, les détecteurs actuels obtiennent des taux de détection très élevés, et un skill d'instructions ne change pas les poids du modèle. Mesurer honnêtement, sans présumer du résultat.

### 3.3 Lecteurs humains (le critère de qualité)
- **Comparaison par paires à l'aveugle** : A contre B sur la même consigne, ordre aléatoire. Question : « Lequel préférez-vous lire, et pourquoi ? » Puis, pour chaque texte : « Écrit par un humain ou une IA ? Confiance de 1 à 5. »
- Lecteurs : au moins 3, dont au moins un qui utilise souvent l'IA. Les utilisateurs intensifs d'IA sont de bien meilleurs détecteurs que les autres (Russell et al., 2025).
- **Critère d'échec** : si B est moins souvent préféré que A, le skill dégrade la prose, quel que soit le détecteur.

### 3.4 Juge LLM (tri seulement)
Un juge LLM qui classe « humain ou IA » sur des extraits mélangés (H, A, B) donne un signal rapide. Ce signal est **faible** : les juges LLM corrèlent mal avec les experts. On ne s'en sert jamais comme preuve.

## 4. Critère de succès proposé
1. Sur le jeu de test, B est **au moins aussi souvent préféré** que A par les lecteurs.
2. **Et** B est classé humain par le détecteur significativement plus souvent que A (IC disjoints), avec un taux de faux positifs sur H proche de 0.
3. **Et** le sens est conservé (vérification manuelle des révisions).

Les trois conditions sont exigées ensemble. Un gain au détecteur avec une perte de qualité invalide le résultat.

## 5. Journal
Chaque campagne d'évaluation est consignée dans `eval/journal.md` :
- date, version du skill (commit) et modèle Claude ;
- consignes ;
- résultats bruts (tableaux) ;
- décisions prises pour la version suivante.
