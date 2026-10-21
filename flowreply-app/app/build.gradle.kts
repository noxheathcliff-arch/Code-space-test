import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

// --- Secrets injection ----------------------------------------------------
// The Gemini API key(s) are NOT hardcoded in Kotlin sources. They are read at
// build time from `secrets.properties` (git-ignored). This keeps the raw key
// out of version control.
//
// IMPORTANT / honest caveat: injecting the key via BuildConfig still ships the
// key inside the compiled APK. Anyone who decompiles the APK can recover it
// (exactly as was done to v1.7). BuildConfig + R8 only raise the bar slightly.
// The ONLY way to truly keep the key secret is to not ship it at all (server
// proxy / Firebase AI Logic). See SECURITY.md.
val secretsFile = rootProject.file("secrets.properties")
val secrets = Properties().apply {
    if (secretsFile.exists()) secretsFile.inputStream().use { load(it) }
}
fun secret(name: String, default: String = ""): String =
    (secrets.getProperty(name) ?: System.getenv(name) ?: default)

android {
    namespace = "com.izumih.flowreply"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.izumih.flowreply"
        minSdk = 26
        targetSdk = 36
        versionCode = 11
        versionName = "2.0"

        // Comma-separated list of Gemini API keys (rotated at runtime).
        buildConfigField(
            "String",
            "GEMINI_API_KEYS",
            "\"${secret("GEMINI_API_KEYS")}\"",
        )
        // Default Gemini model; override without touching code.
        buildConfigField(
            "String",
            "GEMINI_MODEL",
            "\"${secret("GEMINI_MODEL", "gemini-2.5-flash")}\"",
        )
        // Certificate pinning is OFF by default: a stale pin bricks the app in
        // production when Google rotates keys. Enable deliberately (see SECURITY.md).
        buildConfigField("boolean", "ENABLE_CERT_PINNING", "false")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.datastore.preferences)

    val composeBom = platform(libs.compose.bom)
    implementation(composeBom)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.material.icons.extended)
    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.okhttp)
}
