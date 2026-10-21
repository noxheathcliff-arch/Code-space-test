# Sécurité — gestion de la clé API Gemini

## La vérité, d'abord

Tu as choisi de **garder la clé dans l'application**. Il faut être clair :

> **Une clé livrée dans un APK ne peut pas être gardée secrète.**

Peu importe l'obfuscation (NDK, R8, chiffrement de chaînes, `BuildConfig`) :
quelqu'un qui possède l'APK peut récupérer la clé — par décompilation (ce qui a
justement été fait sur la v1.7) ou par interception du trafic réseau. Sources
faisant autorité : OWASP MASVS/MASTG (MASWE-0004, MASWE-0005) et la
documentation Google sur les secrets codés en dur.

Ce projet applique donc le **meilleur durcissement possible dans ce cadre**,
sans prétendre rendre la clé réellement secrète.

## Ce qui a été fait dans ce projet

1. **Clé hors du code source.** Les clés ne sont plus écrites en dur dans
   `GeminiService` (comme en v1.7). Elles viennent de `secrets.properties`
   (git-ignoré), injecté dans `BuildConfig` au build. → la clé n'est plus dans
   le dépôt Git.
2. **Clé envoyée en en-tête**, pas dans l'URL. `x-goog-api-key: <clé>` au lieu
   de `?key=<clé>`. → la clé ne fuite pas dans les logs d'URL, proxys, ou
   traces de crash.
3. **HTTPS obligatoire.** `network_security_config` interdit tout trafic en
   clair (la v1.7 autorisait le cleartext vers le host Gemini).
4. **Certificate pinning** disponible (défense en profondeur), derrière le flag
   `ENABLE_CERT_PINNING` (désactivé par défaut — un pin périmé casse l'app).
5. **R8 / shrinking** activé en release.

⚠️ Aucune de ces mesures ne rend la clé extractible impossible. Elles réduisent
la surface (fuite réseau/logs, clé hors du dépôt), pas plus.

## À faire côté Google Cloud Console (indispensable)

Puisque la clé est dans l'app, limite les dégâts en la **restreignant** :

1. **Restriction d'application Android** : nom de package
   `com.izumih.flowreply` + empreinte **SHA-1 de la clé de signature release**
   (pas la clé debug).
2. **Restriction d'API** : limite la clé à la seule *Generative Language API*.
3. Évite toute restriction réseau `0.0.0.0/0` (équivaut à aucune restriction).

Limites : package + SHA-1 sont des identifiants semi-publics qu'un
re-packageur peut contourner en re-signant ; ça réduit le rayon d'impact mais
ne rend pas la clé secrète.

## À faire immédiatement sur les clés de la v1.7

Les **5 clés** présentes dans l'APK v1.7 doivent être considérées comme
**compromises** (l'APK a circulé et a été décompilé). Actions :

- **Révoquer / régénérer** ces 5 clés dans la Google Cloud Console.
- Vérifier l'usage Gemini de ces clés pour détecter tout abus.
- Appliquer les restrictions ci-dessus aux nouvelles clés.

## La seule vraie solution (« jamais exposée »)

Si la garantie « la clé n'est jamais exposée » devient un impératif, il faut
**retirer la clé de l'app** et router via :

- **Firebase AI Logic + App Check** (Play Integrity), ou
- un **proxy serveur** (ex. Cloudflare Worker) qui détient la clé en secret,
  vérifie un jeton App Check, limite le débit, puis relaie vers Gemini.

Le code de `GeminiService` est volontairement isolé : basculer vers un proxy
revient à changer l'URL de base et l'en-tête d'auth, sans toucher au reste.
