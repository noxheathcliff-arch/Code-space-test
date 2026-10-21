package com.izumih.flowreply.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "flowreply_prefs")

/**
 * Persists the user configuration with Jetpack DataStore (coroutines + Flow),
 * replacing the legacy SharedPreferences + Gson implementation.
 */
class PreferencesManager(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    @Serializable
    private data class PromptDto(
        val id: String,
        val content: String,
        val isEnabled: Boolean,
        val createdAt: Long,
    )

    /** Observable configuration. */
    val configurationFlow: Flow<Configuration> = context.dataStore.data.map { prefs ->
        Configuration(
            prompts = decodePrompts(prefs[KEY_PROMPTS]),
            tonality = prefs[KEY_TONALITY].orEmpty(),
        )
    }

    val onboardingCompletedFlow: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[KEY_ONBOARDING] ?: false
    }

    suspend fun getConfiguration(): Configuration = configurationFlow.first()

    suspend fun isOnboardingCompleted(): Boolean = onboardingCompletedFlow.first()

    suspend fun saveConfiguration(configuration: Configuration) {
        val cleaned = cleanAndValidatePrompts(configuration.prompts)
        val encoded = json.encodeToString(
            kotlinx.serialization.builtins.ListSerializer(PromptDto.serializer()),
            cleaned.map { PromptDto(it.id, it.content, it.isEnabled, it.createdAt) },
        )
        context.dataStore.edit { prefs ->
            prefs[KEY_PROMPTS] = encoded
            prefs[KEY_TONALITY] = configuration.tonality
        }
    }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { it[KEY_ONBOARDING] = completed }
    }

    suspend fun clearConfiguration() {
        context.dataStore.edit { prefs ->
            prefs.remove(KEY_PROMPTS)
            prefs.remove(KEY_TONALITY)
        }
    }

    private fun decodePrompts(raw: String?): List<Prompt> {
        if (raw.isNullOrBlank()) return emptyList()
        return runCatching {
            json.decodeFromString(
                kotlinx.serialization.builtins.ListSerializer(PromptDto.serializer()),
                raw,
            ).map { Prompt(it.id, it.content, it.isEnabled, it.createdAt) }
        }.getOrDefault(emptyList())
    }

    /** Drops blank prompts and de-duplicates by content, preserving order. */
    private fun cleanAndValidatePrompts(prompts: List<Prompt>): List<Prompt> {
        val seen = mutableSetOf<String>()
        return prompts
            .filter { it.content.isNotBlank() }
            .filter { seen.add(it.content.trim().lowercase()) }
    }

    companion object {
        private val KEY_PROMPTS = stringPreferencesKey("config_prompts")
        private val KEY_TONALITY = stringPreferencesKey("config_tonality")
        private val KEY_ONBOARDING = booleanPreferencesKey("onboarding_completed")
    }
}
