package com.izumih.flowreply.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.content.getSystemService

object NotificationHelper {
    const val CHANNEL_BUBBLE = "flowreply_bubble"

    fun createChannels(context: Context) {
        val manager = context.getSystemService<NotificationManager>() ?: return
        val bubble = NotificationChannel(
            CHANNEL_BUBBLE,
            "Assistant FlowReply",
            NotificationManager.IMPORTANCE_LOW,
        ).apply {
            description = "Bulle flottante et génération de réponses"
            setShowBadge(false)
        }
        manager.createNotificationChannel(bubble)
    }
}
