package com.izumih.flowreply.ui.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.izumih.flowreply.service.FloatingBubbleService
import com.izumih.flowreply.ui.ConfigViewModel
import com.izumih.flowreply.ui.components.AddPromptDialog
import com.izumih.flowreply.ui.components.PromptCard
import com.izumih.flowreply.ui.components.StatusCard
import com.izumih.flowreply.ui.theme.LocalSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigScreen(viewModel: ConfigViewModel) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    var showAddDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = { Text("FlowReply", fontWeight = FontWeight.SemiBold) },
                scrollBehavior = scrollBehavior,
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { showAddDialog = true },
                icon = { Icon(Icons.Rounded.Add, null) },
                text = { Text("Prompt") },
            )
        },
    ) { inner ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(inner).padding(horizontal = spacing.space300),
            verticalArrangement = Arrangement.spacedBy(spacing.space200),
        ) {
            item {
                StatusCard(
                    onStartBubble = {
                        context.startService(Intent(context, FloatingBubbleService::class.java))
                        Toast.makeText(context, "Bulle activée", Toast.LENGTH_SHORT).show()
                    },
                )
            }

            item {
                Text(
                    "Tonalité",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = spacing.space100),
                )
            }
            item {
                OutlinedTextField(
                    value = state.tonality,
                    onValueChange = viewModel::setTonality,
                    placeholder = { Text("ex. amical, professionnel, humoristique…") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 1,
                )
            }

            item {
                Row(modifier = Modifier.fillMaxWidth().padding(top = spacing.space100)) {
                    Text("Prompts (${state.prompts.count { it.isEnabled }}/${state.prompts.size})", style = MaterialTheme.typography.titleMedium)
                }
            }

            if (state.prompts.isEmpty() && !state.loading) {
                item {
                    Text(
                        "Aucun prompt. Ajoutez-en pour guider les réponses générées.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }

            items(state.prompts, key = { it.id }) { prompt ->
                PromptCard(
                    prompt = prompt,
                    onToggle = { viewModel.togglePrompt(prompt.id) },
                    onEdit = { viewModel.updatePrompt(prompt.id, it) },
                    onDelete = { viewModel.deletePrompt(prompt.id) },
                )
            }

            item {
                Spacer(Modifier.size(spacing.space100))
                androidx.compose.material3.Button(
                    onClick = {
                        viewModel.save()
                        Toast.makeText(context, "Configuration enregistrée", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Icon(Icons.Rounded.PlayArrow, null)
                    Spacer(Modifier.width(spacing.space100))
                    Text("Enregistrer")
                }
                Spacer(Modifier.size(spacing.space600))
            }
        }
    }

    if (showAddDialog) {
        AddPromptDialog(
            onDismiss = { showAddDialog = false },
            onConfirm = {
                viewModel.addPrompt(it)
                showAddDialog = false
            },
        )
    }
}
