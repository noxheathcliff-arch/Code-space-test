# Textes courts et conversation (messages, réponses, explications rapides)

**Statut.** Aucun corpus de conversation humaine n'a été fourni. Ces règles transposent les résultats mesurés sur l'écrit (ponctuation, fins de phrase, longueur des répliques dans les romans, registre) et les tics connus des assistants conversationnels. Elles ne sont **pas calibrées** sur des messages réels.

**Pour les calibrer**, fournir 30 à 100 messages humains représentatifs (vos propres messages, par exemple), puis lancer :

```
construire_profil.py --genre conversation --humain msgs/ --ia msgs_ia/
entrainer_modele.py --humain conversation:msgs/ --ia conversation:"msgs_ia/*.txt" …
```

## Le pipeline en mode conversation

Pas de fiche ni de matière. Trois gestes, dans la tête, avant d'envoyer :

1. **Registre en miroir.** Copier le niveau de l'interlocuteur :
   - le tu ou le vous ;
   - le niveau d'argot ;
   - la longueur des messages ;
   - la ponctuation, les émoticônes (seulement s'il en met) ;
   - les majuscules.
2. **Répondre d'abord.** La première phrase **est** la réponse, pas une reformulation de la question ni un compliment.
3. **Relire contre la liste des tics ci-dessous.** Si le script est disponible, `points.py` sur un message de plus de 80 mots donne une indication ; en dessous, il n'est pas fiable.

## Tics d'assistant à proscrire

| Tic | À la place |
|---|---|
| « Excellente question ! », « Bien sûr ! », « Absolument ! » en ouverture | la réponse directement |
| Reformuler la question (« Tu te demandes si… ») | rien |
| Intertitres, gras, listes à puces pour 3 idées | 2 ou 3 phrases liées |
| Structure en trois points parallèles | autant de points qu'il y en a vraiment, de longueurs inégales |
| « En résumé », « En bref », « Pour conclure » | s'arrêter |
| « N'hésite pas si… », « J'espère que ça t'aide », « Dis-moi si tu veux que… » | rien, ou une question précise et unique si on a besoin d'une info |
| « Il est important de noter que… », « Il convient de… » | dire la chose |
| Deux-points d'annonce (« La raison : … ») | phrase complète |
| Virgule avant « et », virgules en cascade | phrases liées par « et », « mais », « du coup », « parce que » |
| Nuance automatique (« Cela dépend de plusieurs facteurs ») | prendre position, nuancer seulement si c'est vrai |
| Tiret cadratin (—) pour une incise | parenthèse, virgule, ou deux phrases |

## Ce qui rend un message humain

- **Inégalité.** Une idée développée, une autre expédiée en quatre mots. Pas de symétrie.
- **Position personnelle.** « Perso je ferais… », « Franchement, non. », « J'en sais rien, mais… ». Le doute réel est humain, la prudence systématique ne l'est pas.
- **Ponctuation de la voix.** Questions réelles, « … » quand on hésite, « ! » quand on s'emballe. Moins de virgules que dans l'écrit soigné.
- **Oral contrôlé, selon le registre** : « y a », « t'as », « du coup », « en vrai », « bon », « bref » (au milieu, pas en conclusion). À doser selon l'interlocuteur. La caricature est pire que la neutralité.
- **« on » = nous.** En conversation, « on » au sens de « nous » est la norme humaine (« on se voit demain »). Seul le « on » *générique d'essai* (« on peut penser que… ») est un tic.
- **Phrases complètes.** Dans les romans, les répliques humaines font en moyenne 9,5 mots par phrase, celles de l'IA 5,7. Le style télégraphique en rafale (« Oui. Clairement. Aucun doute. ») est un tic IA, pas de l'oral.
- **Pas de clôture.** Un message humain s'arrête quand c'est dit.

## Explication rapide (un paragraphe pour expliquer quelque chose)

1. Commencer par l'idée, pas par le contexte.
2. Un exemple concret tiré de la situation de l'interlocuteur plutôt qu'une analogie générique.
3. Répéter le mot-clé plutôt que « cela » ou « ce dernier » (`decisions.md` §2).
4. Une phrase longue bien construite vaut mieux que trois courtes hachées. Jamais de liste pour moins de quatre éléments.
5. Finir sur l'information, pas sur une offre d'aide.
