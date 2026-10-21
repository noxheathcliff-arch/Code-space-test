package com.izumih.flowreply.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Accessibility
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Layers
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.izumih.flowreply.FlowReplyApplication
import com.izumih.flowreply.ui.theme.LocalSpacing
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(onFinished: () -> Unit) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var consentGiven by remember { mutableStateOf(false) }

    Scaffold { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
                .padding(horizontal = spacing.space300)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(spacing.space200),
        ) {
            Spacer(Modifier.size(spacing.space300))
            Text(
                "Bienvenue sur FlowReply",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                "FlowReply vous aide à rédiger des réponses dans vos apps de messagerie, " +
                    "à votre demande.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            // Prominent disclosure (Play User Data policy).
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
            ) {
                Column(Modifier.padding(spacing.space200), verticalArrangement = Arrangement.spacedBy(spacing.space150)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.Shield, null, tint = MaterialTheme.colorScheme.onSecondaryContainer)
                        Spacer(Modifier.width(spacing.space100))
                        Text("Comment vos données sont utilisées", style = MaterialTheme.typography.titleMedium)
                    }
                    Text(
                        "Quand VOUS touchez la bulle, FlowReply lit le texte visible à l'écran " +
                            "de la conversation en cours et l'envoie à l'API Google Gemini pour " +
                            "générer une réponse. Les messages ne sont pas stockés par l'application. " +
                            "FlowReply n'agit jamais seul : rien n'est lu ni envoyé sans votre action.",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = consentGiven, onCheckedChange = { consentGiven = it })
                        Text("J'ai compris et j'accepte", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            PermissionCard(
                icon = { Icon(Icons.Rounded.Accessibility, null) },
                title = "Service d'accessibilité",
                description = "Nécessaire pour lire la conversation et insérer la réponse.",
                onClick = { context.open(Settings.ACTION_ACCESSIBILITY_SETTINGS) },
            )
            PermissionCard(
                icon = { Icon(Icons.Rounded.Layers, null) },
                title = "Affichage par-dessus les apps",
                description = "Nécessaire pour la bulle flottante.",
                onClick = {
                    context.open(
                        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:${context.packageName}"),
                    )
                },
            )

            Spacer(Modifier.size(spacing.space100))
            Button(
                onClick = {
                    scope.launch {
                        FlowReplyApplication.instance.preferencesManager.setOnboardingCompleted(true)
                        onFinished()
                    }
                },
                enabled = consentGiven,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(Icons.Rounded.CheckCircle, null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(spacing.space100))
                Text("Commencer")
            }
            Spacer(Modifier.size(spacing.space300))
        }
    }
}

@Composable
private fun PermissionCard(
    icon: @Composable () -> Unit,
    title: String,
    description: String,
    onClick: () -> Unit,
) {
    val spacing = LocalSpacing.current
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(spacing.space200),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(spacing.space200),
        ) {
            icon()
            Column(Modifier.weight(1f)) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            OutlinedButton(onClick = onClick) { Text("Activer") }
        }
    }
}

private fun Context.open(action: String, data: Uri? = null) {
    startActivity(Intent(action).apply {
        data?.let { this.data = it }
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    })
}
