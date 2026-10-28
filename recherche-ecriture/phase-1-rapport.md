# Écriture indistinguable — Phase 1 : diagnostic, état de la recherche, ressources, direction

*Rapport de recherche, 28 octobre 2026. Aucun skill n'est construit à ce stade.*

---

## 0. Statut des sources (à lire d'abord)

La recherche a été conduite par six agents (Haiku) en parallèle, puis recoupée. **La politique réseau de l'environnement a bloqué tous les sites primaires** : arxiv.org, pangram.com, aclanthology.org, pnas.org, nature.com, wikipedia.org, gallica.bnf.fr, kdp.amazon.com (réponse 403 du proxy, vérifiée moi-même). Seuls la recherche web (extraits de résultats) et GitHub étaient accessibles.

Conséquence :

- Les chiffres ci-dessous proviennent d'**extraits de résultats de recherche** et de sources secondaires, recoupés entre agents et avec ce que je connais déjà de cette littérature. Je les juge suffisants pour orienter l'architecture, **pas** pour être cités comme définitifs.
- Étiquettes utilisées :
  - **[Établi]** : plusieurs sources concordantes, résultat connu de la littérature.
  - **[Extrait]** : un seul extrait ou une source secondaire, à revérifier.
  - **[Fabricant]** : chiffre publié par Pangram lui-même.
  - **[Hypothèse]** : plausible, non démontré.
  - **[Reco]** : recommandation tirée de mon analyse.
  - **[À tester]** : idée originale, sans preuve.
- Pour vérifier, il faut ajouter dans *Network access → Allowed domains* de l'environnement : `arxiv.org`, `www.pangram.com`, `aclanthology.org`, `www.pnas.org`, `en.wikipedia.org`, `gallica.bnf.fr`.

---

## 1. Diagnostic

### 1.1 Une prémisse à corriger d'emblée

Le cahier des charges suppose implicitement que **qualité d'écriture et indétectabilité vont ensemble** : écrire assez bien ferait disparaître la signature. Les données disent autre chose.

- Pangram ne détecte pas la « mauvaise écriture ». Il détecte la **distribution statistique d'un modèle aligné par instruction (instruct/RLHF)**. Un texte excellent produit par Claude reste détecté. Un texte médiocre produit par un modèle de base peut passer.
- Chakrabarty, Ginsburg & Dhillon (2025, arXiv 2510.13939) **[Établi/Extrait]** : avec simple prompting (in-context), les textes sont **signalés comme IA à 97 %** ; après fine-tuning sur l'œuvre complète d'un auteur, **3 %** seulement. Les lecteurs experts (MFA) **préfèrent** les sorties fine-tunées. Coût médian du fine-tuning : environ 81 $ par auteur **[Extrait]**.
- arXiv 2605.19516, « Base Models Look Human To AI Detectors » **[Extrait]** : Llama-3-8B **base**, amorcé par un début de texte humain, obtient 98,8 % de probabilité « humain » chez Pangram, contre 17,1 % pour sa version instruct.
- Pangram, sur les modèles Claude récents **[Fabricant]** :
  - Sonnet 5.5 : 99,71 % détecté sur 1 022 prompts ; poésie et création : 197 sur 198.
  - Opus 5.5 : 99,70 %.
  - Fable 5.1 : 99,64 %.
  - Un test indépendant (HackerNoon) **[Extrait]** : Opus 5, explicitement chargé de déjouer Pangram, reste à 100 % IA.

**Conséquence majeure.** Un skill, c'est-à-dire des instructions, des exemples et des scripts autour de Claude, peut améliorer considérablement la *qualité*. Il est très improbable qu'il fasse passer Pangram de façon reproductible, et a fortiori sur un livre entier. Ce n'est pas un défaut de rédaction des consignes : le skill **ne change pas la distribution de sortie du modèle**, il la déplace à la marge. L'objectif « Pangram ne détecte pas un livre entier » exige d'agir sur le **générateur de la prose elle-même**.

### 1.2 Causes, symptômes, et ce que des consignes ne peuvent pas résoudre

| Niveau | Cause probable | Symptômes visibles | Soluble par consignes ? |
|---|---|---|---|
| **Distributionnel** | Échantillonnage des continuations les plus probables, plus alignement RLHF qui réduit la diversité (Kirk et al. 2024 ; « typicality bias » des données de préférence, Zhang et al. 2025, *Verbalized Sampling*) **[Établi]** | Vocabulaire sur-représenté (Kobak et al. : « delve », « underscore »… ; en français, à mesurer) ; homogénéité **entre** textes ; rythme « moyen » | **Non**, pour l'essentiel. C'est ce que Pangram apprend. |
| **Grammatical** | L'instruction-tuning déplace le profil syntaxique (Reinhart et al., PNAS 2025) **[Établi/Extrait]** | Nominalisations environ 1,5 à 2 fois plus fréquentes que chez les humains ; participiales présentes 2 à 5 fois plus ; moins de passifs sans agent. Les modèles base sont plus proches de l'humain. | Partiellement : on corrige ce qu'on voit, pas la distribution. |
| **Processus** | Écriture linéaire en un passage. C'est du *knowledge-telling* (Bereiter & Scardamalia 1987) : récupérer puis énoncer, sans modèle du lecteur ni problème rhétorique à résoudre **[Établi pour l'humain ; Hypothèse pour le LLM]** | Paragraphes construits selon le même schéma ; transitions-charnières ; tout est dit dans l'ordre logique plutôt que dans l'ordre utile au lecteur | **Oui, largement**, par une procédure (planification, contraintes, révision ciblée). |
| **Pragmatique (« assistant »)** | Entraînement à être clair, utile, prudent et complet | Exposition superflue, thèmes énoncés explicitement, émotion nommée, fins conciliantes ou optimistes (cf. étude Villanova sur les récits : « thèmes énoncés, plus lisse, plus positif » **[Extrait]**), équilibre systématique | **Oui en partie**. C'est le terrain principal d'un skill. |
| **Contenu** | Le modèle produit la moyenne des détails possibles | Détails génériques ; pas de détail « que seul ce narrateur connaîtrait » ; métaphores attendues | Oui en partie : un inventaire de détails spécifiques imposé avant la rédaction aide. |
| **Long format** | Fenêtre de contexte, absence de mémoire de style, dérive | Motifs répétés d'un chapitre à l'autre, aplatissement de la voix, tics qui s'accumulent | Par outillage (bible de style, journal des tics, diagnostics inter-chapitres). |
| **Révision par LLM** | Une réécriture par le même modèle réinjecte sa distribution | La révision « lisse » et homogénéise. Chakrabarty et al. (CHI 2025, corpus LAMP) : les LLM détectent mal leurs propres idiosyncrasies et les corrigent moins bien que des éditeurs humains **[Extrait]**. | C'est un piège : réviser par Claude augmente la signature (cf. EditLens, §2.1). |

Taxonomie empirique des défauts (Chakrabarty et al., CHI 2025), à reprendre comme grille de révision : **clichés, exposition superflue, prose ampoulée (« purple prose »), structure de phrase pauvre ou mécanique, manque de spécificité**, et d'autres (7 catégories au total ; liste exacte à revérifier). Le skill open source `blader/humanizer`, fondé sur la page Wikipedia *Signs of AI writing*, compte 26 motifs répartis en 6 familles. Son propre README reconnaît que **« les détecteurs signalent encore la plupart de ses sorties »** **[Établi, page GitHub consultée]**. C'est la démonstration directe qu'une approche « liste de motifs à éviter » améliore la lecture mais ne déplace pas Pangram.

### 1.3 Autres hypothèses de cadrage à revoir

1. **« Un skill enseigne durablement. »** Faux au sens strict. Un skill est un ensemble d'instructions et de fichiers chargés à la demande (métadonnées environ 100 tokens toujours présentes, corps < 5 k tokens au déclenchement, fichiers et scripts lus au besoin ; doc Anthropic consultée). La persistance vient du fait qu'il est **rechargé à chaque fois**, pas d'un apprentissage. Seul un fine-tuning modifie les poids, et Claude n'est pas fine-tunable par un particulier.
2. **« Un livre entier indétectable. »** C'est le cas le plus difficile, pas le plus facile. Pangram découpe en fenêtres et classe chaque segment ; il existe une catégorie « mixte » / « AI-assisted ». Plus le texte est long, plus le détecteur accumule d'indices, et un seul tic récurrent suffit sur 300 pages.
3. **« Un score Pangram favorable prouve l'indétectabilité. »** Non : un score vaut pour une version donnée du détecteur, à une date donnée. Pangram réentraîne sur les sorties d'humaniseurs (article DAMAGE, 19 outils) **[Fabricant/Extrait]**. C'est une course aux armements. Un résultat honnête s'énonce ainsi : « sur N textes définis à l'avance, Pangram version X au JJ/MM a classé Y % comme humains, IC 95 % [a ; b] ».
4. **Filigrane (watermark).** Une source secondaire indique qu'Anthropic filigranerait statistiquement les sorties des modèles Claude lancés depuis le 2 août 2026, sans détecteur public pour l'instant **[Extrait, NON vérifié auprès d'Anthropic]**. Si c'est exact, toute prose *générée par Claude* reste identifiable par Anthropic, indépendamment de Pangram. C'est une raison supplémentaire de ne pas faire de Claude le rédacteur final de la prose dans la branche « indétectabilité ».

---

## 2. Conclusions de la recherche

### 2.1 Pangram : ce qu'on sait

- **Fonctionnement** : classifieur à base de transformeur entraîné en supervisé sur des paires humain/IA, avec « hard negative mining » et prompts miroirs (rapport technique Emi & Spero, arXiv 2402.14873). Version actuelle « Pangram 4 », arXiv 2607.27183 : AUROC 0,9916, taux de faux positifs annoncé 0,0041 %, faux négatifs 0,34 % **[Fabricant/Extrait]**.
- **EditLens** (Thai, Emi, Masrour, Iyyer, arXiv 2510.03154, ICLR 2026) : estime la **part d'édition IA** dans un texte, avec une classification ternaire humain / mixte / IA (F1 90,4 %) **[Fabricant/Extrait]**. Conséquence pratique : un texte humain retouché par Claude, ou une prose d'un autre modèle retouchée par Claude, peut tomber en « mixte ».
- **Longueur** : minimum 50 mots ; segmentation en fenêtres, avec des étiquettes fusionnées à environ 2 phrases minimum. En cas de doute, Pangram « penche humain » sur les textes mixtes **[Fabricant/Extrait]**.
- **Français** : pris en charge (20 à 24 langues selon les pages). Taux de manqués annoncé pour le français : 1,78 % contre 0,34 % en anglais **[Fabricant/Extrait]**. **Aucune évaluation indépendante en français trouvée.** Un roman français a été publiquement signalé comme IA dans un litige (France 24, septembre 2026 ; Boing Boing) **[Extrait]** : c'est un cas potentiel de faux positif sur de la fiction française.
- **Robustesse** :
  - Évaluation indépendante principale : Jabarian & Imas (2025, Chicago Booth/NBER w34223). Pangram y serait le seul outil à garder des performances « de niveau politique publique » sur quatre générateurs, robuste à StealthGPT sur les passages longs. Tous les outils se dégradent sous 50 mots **[Extrait ; chiffres exacts non vérifiés]**.
  - Epoch AI (juillet 2026) : environ 26 % de passages IA manqués quand l'IA imite l'écriture scientifique **[Extrait]**. Pangram n'est donc pas infaillible.
- **Accès** : gratuit environ 2 000 mots/jour sur le site ; API à 0,05 $ / 100 mots, lot -20 % **[Extrait]**.
- **Conditions d'utilisation** (mise à jour du 14 août 2025, extraits) : licence « solely for your internal business use », et une clause tronquée semblant interdire l'accès par d'autres outils ou agents que le logiciel Pangram **[Extrait]**. **À lire intégralement avant toute utilisation automatisée.** Je n'ai pas pu vérifier l'existence d'une clause sur le développement de techniques d'évasion. Si elle existe, la question de l'usage de Pangram comme *oracle d'optimisation* se pose, et c'est une raison de plus pour ne l'utiliser **qu'en évaluation finale**.

### 2.2 Limites de la détection en général

- Les détecteurs historiques sont fragiles face aux attaques adverses, au changement d'échantillonnage (pénalité de répétition) et aux modèles non vus (RAID, Dugan et al., ACL 2024) **[Établi]**.
- Paraphrase récursive (Sadasivan et al.) et DIPPER (Krishna et al., NeurIPS 2023 : DetectGPT tombe de 70,3 % à 4,6 % à 1 % de faux positifs) **[Établi]**. Ces attaques précèdent Pangram, qui affirme y résister.
- **Faux positifs** : biais contre les non-natifs (Liang et al. 2023 : 61 % de faux positifs moyens sur des essais TOEFL, pour 7 détecteurs de l'époque) **[Établi]**. Aucune étude indépendante n'a testé ce biais sur Pangram. La poésie est le domaine où Pangram reconnaît le plus de faux positifs **[Fabricant]**.
- **Lecteurs humains** :
  - Les non-spécialistes ne distinguent pas les deux. Porter & Machery (Sci. Rep. 2024) : 46,6 % de bonnes identifications sur des poèmes, sous le hasard, et les poèmes IA sont préférés. Étude Villanova sur des nouvelles : niveau du hasard.
  - Les utilisateurs intensifs de LLM, eux, sont d'excellents détecteurs : Russell, Karpinska & Iyyer (ACL 2025), 1 erreur sur 300 articles en vote majoritaire, robuste à la paraphrase **[Établi]**.
  - Donc « des lecteurs trouvent ça humain » est un critère faible. Il faut des **lecteurs experts**.

### 2.3 Approches pour améliorer l'écriture : bilan comparatif

Les six approches de ta section 4 :

| Approche | Effet probable sur la **qualité** | Effet probable sur **Pangram** | Coût | Verdict |
|---|---|---|---|---|
| 1. Principes persistants (skill) | Moyen. Corrige le niveau pragmatique (exposition, clichés, thèmes énoncés). | Faible à nul **[Établi par humanizer + données Pangram/Claude]** | Faible | Nécessaire, pas suffisant |
| 2. Exemples et analyses stylistiques | Moyen à bon pour imiter une voix ; le few-shot bat le zero-shot, mais l'imitation des styles implicites reste mauvaise (Wang et al., EMNLP 2025 : vérification d'auteur environ 17-21 % sur les blogs) **[Extrait]** | Faible | Contexte coûteux sur les longs textes | Utile en petites doses ciblées (2-3 extraits **choisis** par scène ou genre), pas en corpus massif dans le prompt |
| 3. Procédure générer / évaluer / réviser | Bonne si la révision est **ciblée** et pilotée par un diagnostic. Agents' Room (DeepMind, ICLR 2025) : planification par agents plus rédaction, préférée aux baselines. Self-Refine : gains, mais aucune tâche narrative testée. | Négatif possible : chaque réécriture par Claude renforce la signature (EditLens) | 2 à 4 appels par passage | Oui, avec garde-fous : réviser localement, ne jamais tout réécrire |
| 4. Voix spécifique depuis un corpus | En contexte : limité. **Par fine-tuning : fort** (Chakrabarty 2025 : préférence des experts inversée) | En contexte : faible. **Par fine-tuning : très fort** (97 % → 3 %) | Fine-tuning : environ 100 $ et un corpus de l'auteur | **Levier principal pour l'objectif Pangram** |
| 5. Outils externes d'analyse | Bon *diagnostic*, à condition de ne pas les transformer en cibles (Goodhart) | Indirect | Faible (scripts locaux) | Oui : signaler des passages, ne pas produire de score à maximiser |
| 6. Adapter le modèle | Fort pour la voix, à condition d'avoir un bon corpus | **Le seul levier démontré**. Aussi au niveau de l'échantillonnage : sampler Antislop (Paech, ICLR 2026) avec retour arrière sur des motifs bannis ; FTPO environ -90 % de motifs « slop » sans perte de qualité, alors que DPO dégrade **[Extrait]** | GPU ou API de fine-tuning, hébergement | Nécessaire pour l'objectif Pangram ; **ne peut pas porter sur Claude** |

Autres résultats utiles :

- **Verbalized Sampling** (Zhang et al. 2025) : demander au modèle plusieurs candidats *avec leurs probabilités* puis échantillonner dans la queue de distribution multiplie la diversité par 1,6 à 2,1 en écriture créative, sans entraînement **[Extrait]**. Applicable dans un skill pour les **décisions de contenu** (quel détail, quel geste, quelle réplique), pas pour la prose.
- **LLM comme juge** : corrélation faible avec les experts en écriture créative. TTCW (Chakrabarty 2024) : aucun juge LLM n'y était positivement corrélé avec les experts ; d'autres études donnent τ ≈ 0,31 **[Extrait]**. Claude-juge sert à **trier**, pas à **valider**.
- **WQRM** (« AI-Slop to AI-Polish », Chakrabarty 2025) : un modèle de récompense de qualité entraîné sur des éditions d'experts. Les écrivains préfèrent les sorties qu'il sélectionne dans 66 % des cas (72 % quand l'écart est net) **[Extrait]**. C'est un modèle possible d'évaluateur appris, à plus long terme.
- **Sciences cognitives de la révision** : Sommers (1980) montre que les novices révisent au niveau du mot, les experts au niveau de l'argument et du lecteur. Kellogg (2008) décrit le stade *knowledge-crafting*, où l'écrivain gère simultanément son plan, le texte et la lecture anticipée. Un outil qui ne révise que les phrases reproduit le comportement novice **[Établi]**. La procédure doit donc imposer une révision **de haut en bas** (intention, puis ordre de l'information, puis scène, puis phrase).

---

## 3. Ressources dont j'ai besoin, par priorité

Ce que je peux faire **sans rien recevoir** : écrire le skill v0 (méthode et procédure de révision), les scripts de diagnostic en français, le harnais d'évaluation, le jeu de prompts de test, et générer les textes de référence « Claude sans système » et « Claude avec skill ». Les livres sur l'écriture **ne sont pas** prioritaires : je connais suffisamment Browne & King, Williams, Le Guin, Wood, Prose, McKee, Gardner, Flower & Hayes, Bereiter & Scardamalia et Sommers pour en extraire la méthode. Le texte intégral n'ajouterait presque rien.

### Priorité 1 : décisions à prendre (aucun fichier)

1. **Accepter ou non une couche « rédacteur fine-tuné »** (modèle open-weight francophone, type Mistral ou Qwen, adapté par LoRA) pour l'objectif Pangram. Sans elle, l'objectif réaliste devient « qualité éditoriale de haut niveau », pas « indétectable ». Il faut un budget GPU ou API de fine-tuning, de l'ordre de quelques dizaines à quelques centaines d'euros pour les essais.
2. **Quelle voix cible ?** Ta propre voix, celle d'auteurs donnés, ou une voix « neutre-littéraire » par genre. Cela détermine le corpus.

### Priorité 2 : corpus humain en français (le plus important)

- **(a) Pour l'évaluation** : 20 à 30 textes humains **récents et non publiés en ligne** (les tiens, ceux de proches consentants, des textes d'atelier). Répartition : environ 8 récits, 6 scènes dialoguées, 8 essais ou articles, entre 500 et 3 000 mots. Pourquoi récents et non publiés : les textes classiques du domaine public sont probablement dans les données d'entraînement de Pangram comme exemples humains, ce qui fausserait l'estimation des faux positifs.
- **(b) Pour le fine-tuning** (seulement si la décision 1 est oui) : **100 000 à 500 000 mots** dans une même voix ou un même genre, avec les droits nécessaires. Si c'est ta voix, tes textes. Sinon, une voix construite à partir du domaine public : ELTeC-fra, 100 romans 1840-1920 sous CC BY 4.0, que je peux récupérer moi-même si le réseau l'autorise. Ce choix vieillit la langue.

### Priorité 3 : accès à Pangram

- Un compte payant ou une clé API, transmis comme **secret d'environnement** (jamais dans le dépôt), plus l'autorisation de `www.pangram.com` dans le réseau. Sinon, tu lances les tests toi-même sur le site et tu me renvoies les résultats.
- Budget approximatif du protocole complet (§4.3) : environ 200 000 mots, soit environ 100 $ en API.
- Avant cela, il faut lire les CGU pour vérifier que l'usage d'évaluation est autorisé.

### Priorité 4 : tes réactions (petite quantité, fort rendement)

- **5 à 10 textes IA que tu trouves artificiels, annotés** (soulignement plus une phrase : « ce qui me gêne ici »).
- **5 à 10 extraits que tu admires** (une demi-page chacun), avec une phrase sur ce qui t'y frappe.

Cela sert à séparer les défauts généraux de tes préférences, et à calibrer le juge.

### Priorité 5 : réseau

Autoriser `arxiv.org`, `aclanthology.org`, `www.pnas.org`, `en.wikipedia.org`, `gallica.bnf.fr` pour que je vérifie les chiffres de ce rapport contre les textes originaux.

**Livres** (optionnel, faible priorité) : seulement *Introduction à l'analyse stylistique* (Fromilhague & Sancier-Château, Armand Colin), si tu veux que les diagnostics utilisent la terminologie stylistique française. Albalat, *Le Travail du style* (1903, domaine public), est utile pour la méthode des corrections manuscrites, et je le récupère moi-même si Gallica est ouvert.

---

## 4. Direction méthodologique envisagée (hypothèse v0)

### 4.1 Architecture à deux étages

```
┌─────────────────────────── Étage A : MÉTHODE (Claude + skill) ───────────────────────────┐
│ 1. Brief → modèle du lecteur, intention, ce qui doit rester implicite                     │
│ 2. Décisions de contenu : inventaire de détails spécifiques, tensions, sous-texte         │
│    (Verbalized Sampling sur les choix, pas sur la prose)                                  │
│ 3. Plan de scène / d'argument : ordre de révélation de l'information                      │
│ 4. Rédaction ──► (Étage B si objectif Pangram ; sinon Claude)                             │
│ 5. Diagnostic par scripts → passages signalés (pas de score global à maximiser)           │
│ 6. Révision de haut en bas : intention → structure → scène → phrase, LOCALE et ciblée     │
└───────────────────────────────────────────────────────────────────────────────────────────┘
┌──────────────────── Étage B : PROSE (rédacteur adapté — branche Pangram) ─────────────────┐
│ Modèle open-weight francophone + LoRA sur le corpus de voix + sampler anti-slop           │
│ Reçoit le plan et les notes de révision de Claude ; c'est LUI qui (ré)écrit la prose      │
└───────────────────────────────────────────────────────────────────────────────────────────┘
```

Principe clé **[Reco]** : dans la branche Pangram, **Claude pense, planifie et critique, mais n'écrit pas la prose finale**. Il annote, et le rédacteur adapté réécrit le passage. Sans cela, EditLens et un éventuel filigrane réintroduisent la signature.

Contenu du skill (modulaire mais sobre) :

- `SKILL.md` (< 5 k tokens) : la procédure en six étapes, et les questions de décision à se poser à chaque étage. Pas une liste d'interdits.
- `references/` chargées à la demande : `fiction.md`, `dialogue.md`, `essai-article.md`, `revision.md` (grille issue de la taxonomie LAMP et de Browne & King), `long-format.md` (bible de style, journal des tics).
- `voix/<nom>.md` : profil stylométrique calculé par script, avec 3 à 5 extraits annotés.
- `scripts/diagnostic.py` (spaCy français) :
  - lexique **sur-représenté calculé** par comparaison à un corpus humain, pas une liste écrite à la main ;
  - dispersion des longueurs de phrase comparée à la référence ;
  - attaques de phrases répétées ;
  - constructions marquées (« non pas X mais Y », triades d'adjectifs, participiales, nominalisations) ;
  - similarité **entre** plusieurs sorties sur un même prompt (l'homogénéité inter-textes est un indice fort).
- `eval/` : prompts figés, conditions, client Pangram, interface de comparaison à l'aveugle, statistiques.

Coût d'usage visé : branche qualité seule, environ 3 appels par passage. Branche Pangram : en plus, un hébergement du LoRA (serverless chez un fournisseur, ou GPU local).

### 4.2 Ce qui reste à vérifier avant de figer l'architecture

1. **Ligne de base** (expérience décisive et peu coûteuse) : comment Pangram classe-t-il Claude seul, puis Claude avec skill v0, sur nos genres **en français** ? J'attends environ 100 % IA dans les deux cas. Si le skill seul faisait nettement baisser le taux, l'étage B serait superflu.
2. **Pilote de l'étage B** : un LoRA sur environ 100 000 mots donne-t-il, en français, un taux « humain » élevé chez Pangram **et** une qualité jugée au moins équivalente à l'aveugle ?
3. **Effet d'une retouche par Claude** sur une prose de l'étage B (EditLens) : y a-t-il une bascule vers « mixte », et à partir de quelle proportion de texte retouché ?
4. **Tenue sur un texte long** : un chapitre de 8 000 à 10 000 mots, avec analyse segment par segment.
5. Les conditions d'utilisation de Pangram.

### 4.3 Protocole d'évaluation

- **Conditions** :
  - A : Claude nu (prompt minimal).
  - B : Claude avec skill.
  - C : étage A + étage B.
  - H : humains (corpus 3.a).
  - Option D : un « humaniseur » commercial, comme témoin de dégradation.
- **Plan** :
  - **Développement** : 12 prompts (4 genres × 3 sujets, 2 longueurs : environ 600 et environ 2 000 mots), 2 tirages par condition.
  - **Test, figé à l'avance et jamais consulté pendant le développement** : 24 autres prompts.
  - **Long format** : 2 chapitres.
  - Soit environ 150 à 200 textes au total.
- **Mesures Pangram** : étiquette et fraction IA par texte, profil par fenêtre pour les longs. On rapporte la **proportion classée humaine par condition avec IC 95 % (bootstrap)**, jamais un score isolé. On note la date et la version de Pangram. On mesure le **taux de faux positifs sur H** : s'il n'est pas proche de 0, nos conclusions sont bruitées.
- **Qualité, à l'aveugle** :
  - Comparaisons par paires de 2 à 4 lecteurs exigeants (toi plus des lecteurs expérimentés), selon une grille inspirée du TTCW, adaptée au genre : voix, précision, sous-texte, rythme, dialogues, cohérence.
  - Plus une question « humain ou IA ? » avec niveau de confiance.
  - Claude-juge seulement pour le tri en développement.
- **Diagnostics stylométriques** : décrits **en écart par rapport au corpus humain du même genre**, pas comme des cibles à atteindre (« plus de variance » n'est pas « mieux »).
- **Critère de succès proposé** [Reco] :
  - Sur le jeu de test, la condition C atteint un taux « humain » chez Pangram **statistiquement indiscernable de H**.
  - **Et** elle n'est pas jugée inférieure à A ou B en qualité par les lecteurs à l'aveugle.
  - Les deux conditions sont exigées ensemble. Une baisse de qualité invalide un gain sur Pangram.
- **Garde-fou anti-Goodhart** : Pangram **n'entre jamais dans la boucle de génération** (pas de génération répétée jusqu'à obtenir « humain »), seulement dans l'évaluation par lots. Sinon on mesure notre capacité à exploiter le détecteur, pas à écrire.

### 4.4 Ce qu'on pourra et ne pourra pas affirmer

- **Possible** : « Sur ce protocole, à cette date, Pangram ne distingue pas nos textes de textes humains du même genre mieux que le hasard, et des lecteurs experts ne les jugent pas inférieurs. »
- **Impossible** : « Pangram ne pourra jamais détecter ces textes. » Le détecteur évolue, et un adversaire peut s'entraîner sur nos sorties. Personne ne peut honnêtement garantir cela, quel que soit l'outil.

### 4.5 Remarque sur l'usage

L'objectif d'indétectabilité ne supprime pas les obligations de déclaration qui s'appliquent selon le contexte : Amazon KDP impose de déclarer les textes générés par IA, et certains contrats d'édition (clause type de l'Authors Guild) ou cadres académiques l'exigent aussi **[Extrait]**. C'est à toi d'en juger selon tes usages. Je le mentionne parce que cela peut influencer le choix de la voix cible et du corpus.

---

## 5. Prochaine étape concrète

1. **Toi** : trancher les décisions 1 et 2 (§3) ; ouvrir les domaines réseau ; fournir l'accès Pangram, ou accepter de lancer les tests toi-même ; rassembler le corpus 3.a, et 3.b si l'étage B est retenu ; puis les annotations 3.4 si tu en as le temps.
2. **Moi, ensuite, sans attendre tes fichiers** :
   - vérifier les chiffres de ce rapport contre les sources primaires ;
   - écrire le jeu de prompts figé ;
   - construire `diagnostic.py` en français ;
   - rédiger le skill v0 ;
   - générer les conditions A et B.
3. **Dès qu'on a l'accès Pangram** : ligne de base A et B (expérience 4.2.1). C'est le premier résultat chiffré, et il décidera si l'étage B est indispensable (ce que j'attends) ou superflu.
4. **Si l'étage B est retenu** : pilote LoRA sur ton corpus, puis expériences 4.2.2 à 4.2.4, puis itérations jusqu'au jeu de test final.

---

## Annexe : principales références (identifiants à revérifier, cf. §0)

- Emi & Spero, *Technical Report on the Pangram AI-Generated Text Classifier*, arXiv 2402.14873 ; Pangram 4, arXiv 2607.27183 ; EditLens, arXiv 2510.03154 ; DAMAGE, GenAIDetect 2025.
- Jabarian & Imas, *Artificial Writing and Automated Detection*, NBER w34223 / BFI WP 2025-116.
- Russell, Karpinska & Iyyer, ACL 2025, arXiv 2501.15654.
- Chakrabarty, Ginsburg & Dhillon, *Readers Prefer Outputs of AI Trained on Copyrighted Books over Expert Human Writers*, arXiv 2510.13939.
- Chakrabarty, Laban & Wu, *Can AI writing be salvaged?*, CHI 2025, arXiv 2409.14509 ; *Art or Artifice?* (TTCW), arXiv 2309.14556 ; *AI-Slop to AI-Polish?* (WQRM), arXiv 2504.07532.
- Reinhart et al., *Do LLMs write like humans?*, PNAS 2025, doi 10.1073/pnas.2422455122.
- Kobak et al., excess vocabulary, arXiv 2406.07016 ; Kirk et al., ICLR 2024 ; Padmakumar & He, ICLR 2024 ; Zhang et al., *Verbalized Sampling*, arXiv 2510.01171.
- Wang et al., *Catch Me If You Can? Not Yet*, arXiv 2509.14543.
- *Base Models Look Human To AI Detectors*, arXiv 2605.19516.
- Paech, *Antislop*, arXiv 2510.15061 ; github.com/sam-paech/antislop-sampler ; github.com/EQ-bench/creative-writing-bench.
- Dugan et al., RAID, ACL 2024 ; Liang et al., arXiv 2304.02819 ; Sadasivan et al., arXiv 2303.11156 ; Krishna et al., NeurIPS 2023.
- Agents' Room, ICLR 2025, arXiv 2410.02603 ; Self-Refine, arXiv 2303.17651.
- Porter & Machery, Sci. Rep. 14:26133 (2024).
- Flower & Hayes 1981 (CCC 32:4) ; Bereiter & Scardamalia 1987 ; Kellogg 2008 (JoWR 1:1) ; Sommers 1980 (CCC 31:4).
- github.com/blader/humanizer ; doc Agent Skills : platform.claude.com/docs/en/agents-and-tools/agent-skills/overview.
- ELTeC-fra (CC BY 4.0, Zenodo).
