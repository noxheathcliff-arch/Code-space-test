package com.izumih.flowreply.data.remote

import com.izumih.flowreply.data.ConversationContext
import com.izumih.flowreply.data.Prompt
import kotlin.math.pow
import kotlin.random.Random

/*
 * Pure (Android-free) logic used by [GeminiService].
 * Kept separate so it can be covered by plain JVM unit tests.
 */

internal const val MAX_CONTEXT_MESSAGES = 5
internal const val BASE_DELAY_MS = 1000L
internal const val MAX_JITTER_MS = 1000L

/** Splits the comma-separated `GEMINI_API_KEYS` build value into usable keys. */
internal fun parseApiKeys(raw: String): List<String> =
    raw.split(",").map { it.trim() }.filter { it.isNotEmpty() }

/**
 * Picks a key not yet tried during this request; once every key has been
 * used, falls back to the full list.
 */
internal fun pickApiKey(apiKeys: List<String>, used: Set<String>, random: Random = Random): String {
    require(apiKeys.isNotEmpty()) { "apiKeys must not be empty" }
    val available = apiKeys.filter { it !in used }
    return available.ifEmpty { apiKeys }.random(random)
}

/** Exponential backoff (1s, 2s, 4s…) plus up to [MAX_JITTER_MS] of jitter. */
internal fun backoffMillis(attempt: Int, random: Random = Random): Long =
    (2.0.pow(attempt) * BASE_DELAY_MS).toLong() + random.nextLong(0, MAX_JITTER_MS)

/** 400–403 will not be fixed by retrying or rotating keys; 429/5xx can be. */
internal fun isNonRetryableStatus(code: Int): Boolean = code in 400..403

internal fun buildConversationText(context: ConversationContext): String {
    if (context.messages.isEmpty()) return "Aucun message"
    return context.messages.takeLast(MAX_CONTEXT_MESSAGES).joinToString("\n") { message ->
        val who = if (message.isFromUser) "Moi" else message.sender
        "$who: ${message.content}"
    }
}

internal fun buildSystemPrompt(prompts: List<Prompt>, tonality: String): String {
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

/** Concatenates the parts of the first candidate, or null if there is no usable text. */
internal fun extractResponseText(response: GeminiResponse): String? =
    response.candidates
        .firstOrNull()
        ?.content
        ?.parts
        ?.joinToString("") { it.text }
        ?.trim()
        ?.takeIf { it.isNotBlank() }

internal fun truncate(s: String, max: Int = 200): String =
    if (s.length > max) s.take(max) + "…" else s
