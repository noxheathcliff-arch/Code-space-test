package com.izumih.flowreply.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
 * Wire DTOs for the Gemini `generateContent` REST endpoint.
 * Serialized with kotlinx.serialization (replaces the old Gson usage).
 */

@Serializable
data class GeminiRequest(
    val contents: List<Content>,
    val generationConfig: GenerationConfig = GenerationConfig(),
    val systemInstruction: Content? = null,
    val tools: List<Tool>? = null,
)

@Serializable
data class Content(
    val parts: List<Part>,
    val role: String? = null,
)

@Serializable
data class Part(
    val text: String,
)

@Serializable
data class GenerationConfig(
    val temperature: Double = 0.9,
    val topK: Int = 40,
    val topP: Double = 0.95,
    val maxOutputTokens: Int = 1024,
    val stopSequences: List<String> = emptyList(),
)

@Serializable
data class Tool(
    @SerialName("google_search") val googleSearch: GoogleSearch? = null,
)

@Serializable
class GoogleSearch

@Serializable
data class GeminiResponse(
    val candidates: List<Candidate> = emptyList(),
    val usageMetadata: UsageMetadata? = null,
    val promptFeedback: PromptFeedback? = null,
)

@Serializable
data class Candidate(
    val content: Content? = null,
    val finishReason: String? = null,
)

@Serializable
data class UsageMetadata(
    val promptTokenCount: Int = 0,
    val candidatesTokenCount: Int = 0,
    val totalTokenCount: Int = 0,
)

@Serializable
data class PromptFeedback(
    val blockReason: String? = null,
)
