# FlowReply (reconstruit, v2.0)

Réécriture complète et modernisée de l'application FlowReply, reconstruite à
partir de l'analyse de l'APK v1.7 décompilé (voir `../decompiled/`). Le code
d'origine n'était pas recompilable (sortie jadx lossy, pas de projet Gradle) :
ce dossier est un projet Android/Kotlin propre, qui **compile réellement**
(debug + release R8 vérifiés).

## Ce qui a changé par rapport à v1.7

**Architecture & code**
- Projet Gradle moderne (Kotlin DSL, version catalog), **compileSdk/targetSdk 36**.
- 100 % Kotlin, UI 100 % Jetpack Compose.
- Réseau : `kotlinx.serialization` + OkHttp (remplace Gson), résultats typés
  (`GenerationResult`), retry + backoff exponentiel, rotation de clés.
- Persistance : **Jetpack DataStore** (Flow/coroutines) au lieu de
  SharedPreferences + Gson.
- Services nettoyés : lecture d'écran robuste (null-safety, filtrage par
  `packageNames`), génération **toujours déclenchée par l'utilisateur** (bulle),
  jamais autonome.
- DI manuel léger (pas de dépendance lourde), `ViewModel` + `StateFlow`.

**UI/UX — Material You (Material 3)**
- **Couleur dynamique** dérivée du fond d'écran (Android 12+), fallback baseline.
- Type scale, échelle de formes, tokens d'espacement (8dp), motion M3.
- Écrans refaits : Splash animé, Onboarding avec divulgation + consentement,
  écran de configuration (`LargeTopAppBar`, cartes, switches, FAB, bulle).
- Edge-to-edge, thème clair/sombre géré par Compose.

**Sécurité** — voir [`SECURITY.md`](SECURITY.md).

## Build

```bash
# 1. Configurer le SDK
echo "sdk.dir=/chemin/vers/Android/sdk" > local.properties

# 2. Fournir la/les clé(s) (hors du code source, non commité)
cp secrets.properties.example secrets.properties
#    puis éditer secrets.properties

# 3. Compiler
./gradlew :app:assembleDebug     # APK debug
./gradlew :app:assembleRelease   # APK release (R8)
```

APK produits dans `app/build/outputs/apk/`.

## Structure

```
app/src/main/java/com/izumih/flowreply/
├── FlowReplyApplication.kt
├── data/            modèles, PreferencesManager (DataStore)
│   └── remote/      DTOs Gemini + GeminiService (réseau sécurisé)
├── service/         AccessibilityService, FloatingBubbleService, BubbleView
├── ui/              MainActivity, navigation, ViewModel
│   ├── theme/       Material You (couleur dynamique, type, formes, spacing)
│   ├── screens/     Splash, Onboarding, Config
│   └── components/  PromptCard, AddPromptDialog, StatusCard
└── util/            NotificationHelper, PermissionHelper
```

## Avertissement conformité Google Play

Un service d'accessibilité qui lit le contenu d'autres apps + un overlay est
soumis à la **politique AccessibilityService** de Play (déclaration + vidéo de
démo requises, et usage probablement non éligible au label « outil
d'accessibilité »). Le design user-initiated + l'écran de consentement visent à
être le plus défendable possible, mais **l'acceptation sur le Play Store n'est
pas garantie**. Détails dans les rapports de recherche de la session.
