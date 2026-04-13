package com.cineflix.android.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.cineflix.android.TelegramEngine
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class EpisodesViewModel(private val engine: TelegramEngine) : ViewModel() {

    data class UiState(
        val loading: Boolean = false,
        val title: String = "",
        val seasons: List<TelegramEngine.SeasonButton> = emptyList(),
        val episodes: List<TelegramEngine.VideoInfo> = emptyList(),
        val error: String? = null,
        val activeSeason: String? = null,
        val currentBotMsgId: Long = 0L,
        val botChatId: Long = 0L,
    )

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    /** Send /start <payload> to bot to discover seasons (series flow) */
    fun openSeries(title: String, payload: String, isMovie: Boolean = false) {
        viewModelScope.launch {
            _state.value = UiState(loading = true, title = title)
            try {
                if (isMovie) {
                    // Movies: /peli <title> → bot sends video files directly (no keyboard)
                    // Equivalent to web's searchMovieByPayload(searchTitle)
                    val searchTitle = title.replace(Regex("\\s*\\(\\d{4}\\)\\s*$"), "").trim()
                    val videos = engine.searchMovieByPayload(searchTitle)
                    val sorted = videos.sortedBy { it.date }
                    _state.value = _state.value.copy(
                        loading  = false,
                        episodes = sorted,
                        error    = if (sorted.isEmpty()) "El bot no encontró ningún archivo para esta película." else null,
                    )
                } else {
                    // Series: /start <payload> → bot sends inline keyboard with seasons
                    val response = engine.sendBotCommand(payload)
                    if (response != null && response.buttons.isNotEmpty()) {
                        _state.value = _state.value.copy(
                            loading         = false,
                            seasons         = response.buttons,
                            currentBotMsgId = response.messageId,
                            botChatId       = response.chatId,
                        )
                        // Pre-open first season automatically
                        openSeason(response.buttons.first(), response.messageId, response.chatId)
                    } else {
                        _state.value = _state.value.copy(
                            loading         = false,
                            currentBotMsgId = response?.messageId ?: 0L,
                            botChatId       = response?.chatId ?: 0L,
                            error           = if (response?.buttons?.isEmpty() == true) "No se encontraron temporadas" else null,
                        )
                    }
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(loading = false, error = e.message)
            }
        }
    }


    /** Click a season button and collect episodes */
    fun openSeason(button: TelegramEngine.SeasonButton, msgId: Long, botChatId: Long = _state.value.botChatId) {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                loading      = true,
                activeSeason = button.text,
                episodes     = emptyList(),
            )
            try {
                val videos = engine.clickInlineButton(
                    chatId     = botChatId,
                    msgId      = msgId,
                    dataBase64 = button.dataBase64,
                )
                val sorted = videos.sortedBy { it.date }
                _state.value = _state.value.copy(
                    loading  = false,
                    episodes = sorted,
                    error    = if (sorted.isEmpty()) "No se encontraron episodios" else null,
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(loading = false, error = e.message)
            }
        }
    }


    fun clearError() {
        _state.value = _state.value.copy(error = null)
    }

    class Factory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return EpisodesViewModel(TelegramEngine.getInstance(context)) as T
        }
    }
}
