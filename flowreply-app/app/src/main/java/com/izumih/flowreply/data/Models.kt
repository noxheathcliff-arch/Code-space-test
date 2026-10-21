package com.izumih.flowreply.data

import java.util.UUID

/**
 * A single message read from (or to be sent to) a conversation on screen.
 *
 * @param isFromUser true when the message was authored by the device owner
 *                   (determined by the accessibility bounds heuristic).
 */
data class Message(
    val sender: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis(),
    val isFromUser: Boolean = false,
)

/** A reusable instruction the user adds to steer the generated replies. */
data class Prompt(
    val id: String = UUID.randomUUID().toString(),
    val content: String,
    val isEnabled: Boolean = true,
    val createdAt: Long = System.currentTimeMillis(),
)

/** The user's saved configuration: the enabled prompts and a tonality hint. */
data class Configuration(
    val prompts: List<Prompt> = emptyList(),
    val tonality: String = "",
)

/** A snapshot of the conversation currently visible on screen. */
data class ConversationContext(
    val messages: List<Message>,
    val appPackage: String,
    val timestamp: Long = System.currentTimeMillis(),
)
