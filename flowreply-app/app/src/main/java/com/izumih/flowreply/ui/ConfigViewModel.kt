package com.izumih.flowreply.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.izumih.flowreply.data.Configuration
import com.izumih.flowreply.data.PreferencesManager
import com.izumih.flowreply.data.Prompt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ConfigUiState(
    val prompts: List<Prompt> = emptyList(),
    val tonality: String = "",
    val loading: Boolean = true,
    val saved: Boolean = false,
)

class ConfigViewModel(private val prefs: PreferencesManager) : ViewModel() {

    private val _state = MutableStateFlow(ConfigUiState())
    val state: StateFlow<ConfigUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val config = prefs.getConfiguration()
            _state.update { it.copy(prompts = config.prompts, tonality = config.tonality, loading = false) }
        }
    }

    fun addPrompt(content: String) {
        if (content.isBlank()) return
        _state.update { it.copy(prompts = it.prompts + Prompt(content = content.trim()), saved = false) }
    }

    fun updatePrompt(id: String, content: String) = _state.update { s ->
        s.copy(prompts = s.prompts.map { if (it.id == id) it.copy(content = content) else it }, saved = false)
    }

    fun togglePrompt(id: String) = _state.update { s ->
        s.copy(prompts = s.prompts.map { if (it.id == id) it.copy(isEnabled = !it.isEnabled) else it }, saved = false)
    }

    fun deletePrompt(id: String) = _state.update { s ->
        s.copy(prompts = s.prompts.filterNot { it.id == id }, saved = false)
    }

    fun setTonality(value: String) = _state.update { it.copy(tonality = value, saved = false) }

    fun save() {
        viewModelScope.launch {
            val current = _state.value
            prefs.saveConfiguration(Configuration(current.prompts, current.tonality))
            _state.update { it.copy(saved = true) }
        }
    }

    class Factory(private val prefs: PreferencesManager) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            ConfigViewModel(prefs) as T
    }
}
