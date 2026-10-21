# Décompilation — FlowReply v1.7

APK source : `FlowReply - v1.7.apk` (11,6 Mo, `classes.dex` + `classes2.dex`)
Décompilé le 2026-10-21.

## Outils utilisés

| Outil | Version | Rôle | Sortie |
|-------|---------|------|--------|
| **jadx** | 1.5.1 | DEX → source Java lisible | `decompiled/jadx/` |
| **apktool** | 2.10.0 | ressources, `AndroidManifest.xml`, `res/`, `assets/` décodés | `decompiled/apktool/` |

> Le smali généré par apktool (`smali/`, `smali_classes2/`, ~334 Mo) a été retiré : c'est le
> même bytecode que celui déjà rendu en Java lisible par jadx. Pour le régénérer :
> `java -jar apktool.jar d "FlowReply - v1.7.apk" -o decompiled/apktool`.

## Identité de l'application

- **Nom** : FlowReply
- **Package** : `com.izumih.flowreply`
- **versionName / versionCode** : 1.7 / 10
- **minSdk / targetSdk / compileSdk** : 21 / 34 / 34
- **Langage** : Kotlin (Jetpack Compose pour l'UI, coroutines, OkHttp + Gson)

## Ce que fait l'app

FlowReply est un **assistant de réponse automatique par IA** qui se greffe sur d'autres applis
de messagerie via le **service d'accessibilité** Android et une **bulle flottante** en overlay.

Chaîne fonctionnelle :

1. `FlowReplyAccessibilityService` (permission `BIND_ACCESSIBILITY_SERVICE`) lit l'arborescence
   de l'écran courant (`extractMessagesFromScreen` / `extractMessagesRecursively`), reconstruit la
   conversation en objets `Message`, repère le champ de saisie (`findInputField`).
2. `FloatingBubbleService` (foreground service `specialUse` + `SYSTEM_ALERT_WINDOW`) affiche une
   bulle ; au clic, elle déclenche la génération.
3. `GeminiService` appelle l'API **Google Gemini** (`generativelanguage.googleapis.com`) via OkHttp :
   construit un prompt système à partir des `Prompt` activés + d'une tonalité, prend les 5 derniers
   messages comme contexte, avec retry (3 essais, backoff exponentiel + jitter).
4. La réponse générée est réinsérée dans le champ de saisie (`insertTextIntoInputField`).

Config utilisateur gérée par `PreferencesManager` ; UI Compose (`MainActivity`, écrans
`Splash`/`Onboarding`, `ConfigDialog`, `ConfigOverlayActivity`).

### Permissions déclarées
`INTERNET`, `ACCESS_NETWORK_STATE`, `SYSTEM_ALERT_WINDOW`, `FOREGROUND_SERVICE` (+ `SPECIAL_USE`),
`POST_NOTIFICATIONS`, `RECEIVE_BOOT_COMPLETED`, `READ/WRITE_EXTERNAL_STORAGE` (anciens SDK).

## ⚠️ Constat de sécurité important

`com/izumih/flowreply/api/GeminiService.java` contient **5 clés d'API Google Gemini en dur**
(liste `apiKeys`, utilisées en rotation aléatoire). Des clés embarquées dans un APK sont
**extractibles par quiconque** récupère le binaire — exactement comme ici.

> **Caviardage** : dans cette sortie commitée, les 5 clés ont été remplacées par
> `<REDACTED_GEMINI_API_KEY>` dans `GeminiService.java`, et les copies brutes de `classes.dex` /
> `classes2.dex` (bytecode binaire contenant les mêmes clés) ont été retirées de `jadx/resources/`,
> afin de ne pas publier de secrets vivants dans le dépôt. Les clés réelles restent présentes dans
> l'APK d'origine (`FlowReply - v1.7.apk`, sur la branche `main`).

Recommandations pour le propriétaire :
- **Révoquer / régénérer immédiatement** ces 5 clés dans la Google Cloud Console (elles doivent
  être considérées comme compromises dès lors que l'APK a circulé).
- Ne jamais stocker de clé API côté client : passer par un **backend proxy** qui détient la clé,
  ou au minimum des **restrictions de clé** (application Android + API autorisée) côté Google Cloud.

`network_security_config.xml` autorise par ailleurs le trafic en clair vers
`generativelanguage.googleapis.com` (le reste du trafic en clair est interdit).

## Arborescence de la sortie

```
decompiled/
├── ANALYSE.md                 ← ce fichier
├── jadx/
│   ├── sources/com/izumih/flowreply/   ← code propre de l'app (~47 fichiers)
│   │   ├── api/        GeminiService
│   │   ├── service/    FlowReplyAccessibilityService, FloatingBubbleService
│   │   ├── ui/         MainActivity, screens, components (Compose)
│   │   ├── data/       modèles Gemini + Message/Prompt/Configuration
│   │   └── util/       PreferencesManager, PermissionHelper, NotificationHelper
│   ├── sources/androidx|kotlin|okhttp3|...   ← bibliothèques tierces embarquées
│   └── resources/      ← ressources extraites par jadx
└── apktool/
    ├── AndroidManifest.xml   ← manifest décodé
    ├── apktool.yml
    ├── res/                  ← layouts, values, xml (strings, thèmes, configs)
    └── assets/
```

## Pour explorer

- Code métier de l'app : `decompiled/jadx/sources/com/izumih/flowreply/`
- Manifest / permissions / composants : `decompiled/apktool/AndroidManifest.xml`
- Ressources & chaînes : `decompiled/apktool/res/values/`
