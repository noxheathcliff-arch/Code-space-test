# Keep kotlinx.serialization generated serializers for the Gemini DTOs.
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.**

-keepclassmembers class com.izumih.flowreply.data.remote.** {
    *** Companion;
}
-keepclasseswithmembers class com.izumih.flowreply.data.remote.** {
    kotlinx.serialization.KSerializer serializer(...);
}
-keep,includedescriptorclasses class com.izumih.flowreply.data.remote.**$$serializer { *; }

# OkHttp / Okio
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn org.conscrypt.**

# Keep accessibility service name (referenced from XML/manifest).
-keep class com.izumih.flowreply.service.** { *; }

# NOTE: R8/obfuscation does NOT hide the embedded API key. See SECURITY.md.
