package com.izumih.flowreply.util

import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.provider.Settings
import android.view.accessibility.AccessibilityManager
import androidx.core.content.getSystemService
import com.izumih.flowreply.service.FlowReplyAccessibilityService

/** Helpers to check the two sensitive permissions this app depends on. */
object PermissionHelper {

    /** Whether the user can draw the floating bubble over other apps. */
    fun canDrawOverlays(context: Context): Boolean =
        Settings.canDrawOverlays(context)

    /** Whether FlowReply's accessibility service is enabled by the user. */
    fun isAccessibilityServiceEnabled(context: Context): Boolean {
        val manager = context.getSystemService<AccessibilityManager>() ?: return false
        val expected = "${context.packageName}/${FlowReplyAccessibilityService::class.java.name}"
        return manager
            .getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
            .any { it.id == expected }
    }
}
