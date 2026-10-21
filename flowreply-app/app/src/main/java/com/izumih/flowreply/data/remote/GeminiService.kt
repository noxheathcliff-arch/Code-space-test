package com.izumih.flowreply.data.remote

import android.util.Log
import com.izumih.flowreply.BuildConfig
import com.izumih.flowreply.data.ConversationContext
import com.izumih.flowreply.data.Prompt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.CertificatePinner
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.math.pow
import kotlin.random.Random

/** Result of a generation attempt — lets the UI distinguish failure kinds. */
sealed interface GenerationResult {
    data class Success(val text: String) : GenerationResult
    data class Error(val message: String, val cause: Throwable? = null) : GenerationResult
}

/**
 * Talks to the Gemini `generateContent` endpoint.
 *
 * Security notes (see SECURITY.md for the full picture):
 *  - The API key is NOT hardcoded in sources; it comes from [BuildConfig] which
 *    is fed from the git-ignored `secrets.properties` at build time.
 *  - The key is sent in the `x-goog-api-key` HTTP header, never in the URL query
 *    string, so it does not leak into URL logs / proxies / crash traces.
 *  - Optional certificate pinning (defense-in-depth) is gated behind a build flag.
 *  - None of this makes a key shipped inside the APK truly secret — only a server
 *    proxy / Firebase AI Logic can do that.
 */
class GeminiService(
    private val model: String = BuildConfig.GEMINI_MODEL,
) {
    private val apiKeys: List<String> =
        BuildConfig.GEMINI_API_KEYS
            .split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }

    private val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .apply {
            if (BuildConfig.ENABLE_CERT_PINNING) {
                // NOTE: these are PLACEHOLDER pins. Replace with the real
                // SubjectPublicKeyInfo SHA-256 of generativelanguage.googleapis.com
                // AND a backup pin before enabling, or the app will break when
                // Google rotates certificates. See SECURITY.md.
                certificatePinner(
                    CertificatePinner.Builder()
                        .add(HOST, "sha256/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=")
                        .add(HOST, "sha256/BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB=")
                        .build(),
                )
            }
        }
        .build()

    suspend fun generateResponse(
        context: ConversationContext,
        prompts: List<Prompt>,
        tonality: String,
    ): GenerationResult = withContext(Dispatchers.IO) {
        if (apiKeys.isEmpty()) {
            return@withContext GenerationResult.Error(
                "Aucune clé API configurée (secrets.properties / GEMINI_API_KEYS).",
            )
        }

        val systemPrompt = buildSystemPrompt(prompts, tonality)
        val conversationText = buildConversationText(context)
        val requestJson = json.encodeToString(
            GeminiRequest.serializer(),
            GeminiRequest(
                contents = listOf(Content(parts = listOf(Part(conversationText)), role = "user")),
                systemInstruction = Content(parts = listOf(Part(systemPrompt))),
                generationConfig = GenerationConfig(),
            ),
        )

        val usedKeys = mutableSetOf<String>()
        var lastError: String = "Échec inconnu"
        var lastCause: Throwable? = null

        repeat(MAX_RETRIES) { attempt ->
            val apiKey = pickApiKey(usedKeys)
            usedKeys += apiKey
            try {
                val request = Request.Builder()
                    .url("$BASE_URL/models/$model:generateContent")
                    // Key in a header, NOT in the URL query string.
                    .header("x-goog-api-key", apiKey)
                    .header("Content-Type", "application/json")
                    .post(requestJson.toRequestBody(JSON_MEDIA_TYPE))
                    .build()

                client.newCall(request).execute().use { response ->
                    val body = response.body?.string().orEmpty()
                    if (response.isSuccessful) {
                        val parsed = json.decodeFromString(GeminiResponse.serializer(), body)
                        val text = parsed.candidates
                            .firstOrNull()
                            ?.content
                            ?.parts
                            ?.joinToString("") { it.text }
                            ?.trim()
                        if (!text.isNullOrBlank()) {
                            return@withContext GenerationResult.Success(text)
                        }
                        parsed.promptFeedback?.blockReason?.let {
                            return@withContext GenerationResult.Error("Réponse bloquée: $it")
                        }
                        lastError = "Réponse vide du modèle"
                    } else {
                        lastError = "HTTP ${response.code}"
                        Log.w(TAG, "Attempt ${attempt + 1} failed: ${response.code} ${truncate(body)}")
                        // 400/401/403 won't be fixed by rotating keys/retry fast; 429/5xx can.
                        if (response.code in 400..403) {
                            return@withContext GenerationResult.Error("HTTP ${response.code}: clé/paramètre invalide")
                        }
                    }
                }
            } catch (e: IOException) {
                lastError = e.message ?: "Erreur réseau"
                lastCause = e
                Log.w(TAG, "Attempt ${attempt + 1} network error", e)
            }

            if (attempt < MAX_RETRIES - 1) delay(backoffMillis(attempt))
        }

        GenerationResult.Error(lastError, lastCause)
    }

    private fun pickApiKey(used: Set<String>): String {
        val available = apiKeys.filter { it !in used }
        return (available.ifEmpty { apiKeys }).random(Random)
    }

    private fun backoffMillis(attempt: Int): Long =
        (2.0.pow(attempt) * BASE_DELAY_MS).toLong() + Random.nextLong(0, 1000)

    private fun buildConversationText(context: ConversationContext): String {
        if (context.messages.isEmpty()) return "Aucun message"
        return context.messages.takeLast(MAX_CONTEXT_MESSAGES).joinToString("\n") { message ->
            val who = if (message.isFromUser) "Moi" else message.sender
            "$who: ${message.content}"
        }
    }

    private fun buildSystemPrompt(prompts: List<Prompt>, tonality: String): String {
        val enabled = prompts.filter { it.isEnabled }
        val builder = StringBuilder(
            "Tu es un assistant qui génère des réponses courtes et précises.",
        )
        if (enabled.isNotEmpty()) {
            builder.append("\n\nRÈGLES À RESPECTER:")
            enabled.forEach { builder.append("\n- ").append(it.content) }
        }
        if (tonality.isNotBlank()) {
            builder.append("\n\nTONALITÉ À ADOPTER: ").append(tonality)
        }
        return builder.toString()
    }

    private fun truncate(s: String, max: Int = 200) = if (s.length > max) s.take(max) + "…" else s

    companion object {
        private const val TAG = "GeminiService"
        const val HOST = "generativelanguage.googleapis.com"
        private const val BASE_URL = "https://$HOST/v1beta"
        private const val MAX_RETRIES = 3
        private const val BASE_DELAY_MS = 1000L
        private const val MAX_CONTEXT_MESSAGES = 5
        private val JSON_MEDIA_TYPE = "application/json; charset=utf-8".toMediaType()
    }
}
