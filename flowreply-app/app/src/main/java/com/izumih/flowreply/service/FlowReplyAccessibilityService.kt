package com.izumih.flowreply.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.ClipData
import android.content.ClipboardManager
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import androidx.core.content.getSystemService
import com.izumih.flowreply.FlowReplyApplication
import com.izumih.flowreply.data.ConversationContext
import com.izumih.flowreply.data.GenerationResultListener
import com.izumih.flowreply.data.Message
import com.izumih.flowreply.data.remote.GeminiService
import com.izumih.flowreply.data.remote.GenerationResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * Reads the conversation currently on screen and inserts an AI-generated reply
 * into the input field. The generation is ALWAYS user-initiated (triggered from
 * the floating bubble) — never autonomous — which is the only defensible posture
 * under Google Play's AccessibilityService policy.
 */
class FlowReplyAccessibilityService : AccessibilityService() {

    private val geminiService = GeminiService()
    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())
    private var lastPackage: String = ""

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
        serviceInfo = AccessibilityServiceInfo().apply {
            eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED or
                AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            flags = AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS or
                AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS
            notificationTimeout = 100L
        }
        Log.d(TAG, "FlowReply Accessibility Service connected")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // We only track the foreground package so the bubble knows the context.
        event?.packageName?.let { lastPackage = it.toString() }
    }

    override fun onInterrupt() {
        Log.d(TAG, "Service interrupted")
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
        scope.cancel()
    }

    /** Entry point called by the floating bubble. */
    fun analyzeAndGenerateResponse(listener: GenerationResultListener) {
        scope.launch {
            val messages = extractMessagesFromScreen()
            if (messages.isEmpty()) {
                listener.onResult(GenerationResult.Error("Aucun message détecté à l'écran."))
                return@launch
            }
            val app = FlowReplyApplication.instance
            val config = app.preferencesManager.getConfiguration()
            val context = ConversationContext(messages, lastPackage)
            when (val result = geminiService.generateResponse(context, config.prompts, config.tonality)) {
                is GenerationResult.Success -> {
                    insertTextIntoInputField(result.text)
                    listener.onResult(result)
                }
                is GenerationResult.Error -> listener.onResult(result)
            }
        }
    }

    // --- Screen reading ----------------------------------------------------

    private fun extractMessagesFromScreen(): List<Message> {
        val root = rootInActiveWindow ?: run {
            Log.w(TAG, "No root window available")
            return emptyList()
        }
        val messages = mutableListOf<Message>()
        try {
            extractMessagesRecursively(root, messages)
        } catch (e: Exception) {
            Log.e(TAG, "Error extracting messages", e)
        }
        // Keep only the most recent messages to bound the context size.
        return messages.takeLast(MAX_MESSAGES)
    }

    private fun extractMessagesRecursively(node: AccessibilityNodeInfo?, out: MutableList<Message>) {
        node ?: return
        val text = node.text?.toString()?.trim()
        if (!text.isNullOrEmpty() && text.length in MIN_LEN..MAX_LEN && node.className?.contains("EditText") != true) {
            out += Message(
                sender = if (isUserMessage(node)) "Moi" else "Contact",
                content = text,
                isFromUser = isUserMessage(node),
            )
        }
        for (i in 0 until node.childCount) {
            extractMessagesRecursively(node.getChild(i), out)
        }
    }

    /** Heuristic: a bubble whose right edge sits past 60% of the width is "mine". */
    private fun isUserMessage(node: AccessibilityNodeInfo): Boolean = try {
        val bounds = Rect().also { node.getBoundsInScreen(it) }
        bounds.right > resources.displayMetrics.widthPixels * 0.6
    } catch (e: Exception) {
        false
    }

    // --- Writing the reply -------------------------------------------------

    private fun insertTextIntoInputField(text: String) {
        val root = rootInActiveWindow ?: run {
            Log.e(TAG, "No root node for inserting text")
            return
        }
        val field = findInputField(root)
        if (field == null) {
            Log.w(TAG, "No input field found on screen")
            return
        }
        val args = Bundle().apply {
            putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text)
        }
        if (!field.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, args)) {
            // Fallback: focus + paste from clipboard.
            field.performAction(AccessibilityNodeInfo.ACTION_FOCUS)
            getSystemService<ClipboardManager>()
                ?.setPrimaryClip(ClipData.newPlainText("flowreply", text))
            field.performAction(AccessibilityNodeInfo.ACTION_PASTE)
        }
    }

    private fun findInputField(node: AccessibilityNodeInfo?): AccessibilityNodeInfo? {
        node ?: return null
        if (node.isEditable || node.className?.contains("EditText") == true) return node
        for (i in 0 until node.childCount) {
            findInputField(node.getChild(i))?.let { return it }
        }
        return null
    }

    companion object {
        private const val TAG = "FlowReplyAccess"
        private const val MAX_MESSAGES = 15
        private const val MIN_LEN = 1
        private const val MAX_LEN = 2000

        @Volatile
        var instance: FlowReplyAccessibilityService? = null
            private set
    }
}
