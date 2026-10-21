package com.izumih.flowreply.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BubbleChart
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.compose.material3.Text
import com.izumih.flowreply.util.PermissionHelper

/** Shows live permission status and a button to start the floating bubble. */
@Composable
fun StatusCard(onStartBubble: () -> Unit) {
    val context = LocalContext.current
    var accessibilityOn by remember { mutableStateOf(false) }
    var overlayOn by remember { mutableStateOf(false) }

    // Re-check permissions whenever the screen resumes (user may have toggled them in Settings).
    LifecycleResumeEffect(Unit) {
        accessibilityOn = PermissionHelper.isAccessibilityServiceEnabled(context)
        overlayOn = PermissionHelper.canDrawOverlays(context)
        onPauseOrDispose { }
    }

    ElevatedCard(modifier = Modifier.fillMaxWidth().padding(top = 16.dp)) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("État", style = MaterialTheme.typography.titleMedium)
            StatusRow("Service d'accessibilité", accessibilityOn)
            StatusRow("Affichage par-dessus les apps", overlayOn)
            Button(
                onClick = onStartBubble,
                enabled = accessibilityOn && overlayOn,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(Icons.Rounded.BubbleChart, null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text("Activer la bulle")
            }
        }
    }
}

@Composable
private fun StatusRow(label: String, ok: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            if (ok) Icons.Rounded.CheckCircle else Icons.Rounded.Cancel,
            contentDescription = null,
            tint = if (ok) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
            modifier = Modifier.size(20.dp),
        )
        Spacer(Modifier.width(8.dp))
        Text(label, style = MaterialTheme.typography.bodyMedium)
    }
}
