package com.izumih.flowreply.service

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.ServiceInfo
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat
import androidx.core.content.getSystemService
import com.izumih.flowreply.R
import com.izumih.flowreply.data.remote.GenerationResult
import com.izumih.flowreply.service.bubble.BubbleView
import com.izumih.flowreply.util.NotificationHelper
import kotlin.math.abs

/**
 * Hosts the draggable floating bubble. Tapping the bubble asks the accessibility
 * service to read the screen and generate a reply (user-initiated only).
 */
class FloatingBubbleService : android.app.Service() {

    private lateinit var windowManager: WindowManager
    private var bubbleContainer: FrameLayout? = null
    private lateinit var layoutParams: WindowManager.LayoutParams

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        windowManager = getSystemService()!!
        startAsForeground()
        addBubble()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int = START_STICKY

    private fun startAsForeground() {
        val launch = packageManager.getLaunchIntentForPackage(packageName)
        val pending = PendingIntent.getActivity(
            this, 0, launch, PendingIntent.FLAG_IMMUTABLE,
        )
        val notification: Notification = NotificationCompat.Builder(this, NotificationHelper.CHANNEL_BUBBLE)
            .setContentTitle(getString(R.string.bubble_notification_title))
            .setContentText(getString(R.string.bubble_notification_text))
            .setSmallIcon(R.drawable.ic_bubble)
            .setContentIntent(pending)
            .setOngoing(true)
            .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            ServiceCompat.startForeground(
                this, NOTIF_ID, notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE,
            )
        } else {
            startForeground(NOTIF_ID, notification)
        }
    }

    private fun addBubble() {
        if (bubbleContainer != null) return
        val bubble = BubbleView(this)
        val container = FrameLayout(this).apply { addView(bubble) }

        layoutParams = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT,
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            x = 0
            y = 300
        }

        bubble.setOnTouchListener(DragTapListener(
            params = layoutParams,
            onMove = { windowManager.updateViewLayout(container, layoutParams) },
            onTap = { onBubbleTapped() },
        ))

        windowManager.addView(container, layoutParams)
        bubbleContainer = container
    }

    private fun onBubbleTapped() {
        val service = FlowReplyAccessibilityService.instance
        if (service == null) {
            Toast.makeText(this, R.string.error_accessibility_off, Toast.LENGTH_LONG).show()
            return
        }
        Toast.makeText(this, R.string.generating, Toast.LENGTH_SHORT).show()
        service.analyzeAndGenerateResponse { result ->
            val msg = when (result) {
                is GenerationResult.Success -> getString(R.string.reply_inserted)
                is GenerationResult.Error -> getString(R.string.generation_failed, result.message)
            }
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bubbleContainer?.let { windowManager.removeView(it) }
        bubbleContainer = null
    }

    /** Distinguishes a tap from a drag and moves the overlay while dragging. */
    private class DragTapListener(
        private val params: WindowManager.LayoutParams,
        private val onMove: () -> Unit,
        private val onTap: () -> Unit,
    ) : View.OnTouchListener {
        private var initialX = 0
        private var initialY = 0
        private var touchX = 0f
        private var touchY = 0f

        override fun onTouch(v: View, event: MotionEvent): Boolean {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    initialX = params.x
                    initialY = params.y
                    touchX = event.rawX
                    touchY = event.rawY
                }
                MotionEvent.ACTION_MOVE -> {
                    params.x = initialX + (event.rawX - touchX).toInt()
                    params.y = initialY + (event.rawY - touchY).toInt()
                    onMove()
                }
                MotionEvent.ACTION_UP -> {
                    if (abs(event.rawX - touchX) < TAP_SLOP && abs(event.rawY - touchY) < TAP_SLOP) {
                        v.performClick()
                        onTap()
                    }
                }
            }
            return true
        }

        companion object {
            private const val TAP_SLOP = 16f
        }
    }

    companion object {
        private const val NOTIF_ID = 1001
    }
}
