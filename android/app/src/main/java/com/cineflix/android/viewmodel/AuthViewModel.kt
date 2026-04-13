package com.cineflix.android.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.cineflix.android.TelegramEngine
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AuthViewModel(private val engine: TelegramEngine) : ViewModel() {

    val authState = engine.authState

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _userName = MutableStateFlow<String?>(null)
    val userName: StateFlow<String?> = _userName.asStateFlow()

    init {
        viewModelScope.launch {
            authState.collect { state ->
                if (state is TelegramEngine.AuthState.Ready) {
                    fetchUserName()
                }
                _isLoading.value = false
            }
        }
    }

    private fun fetchUserName() {
        engine.getMe { user ->
            _userName.value = user?.let { u ->
                    listOf(u.firstName, u.lastName)
                        .filter { n -> n.isNotBlank() }
                        .joinToString(" ")
                        .ifEmpty { u.usernames?.activeUsernames?.firstOrNull()?.let { "@$it" } ?: "" }
                }
        }
    }

    fun sendPhone(phone: String) {
        _isLoading.value = true
        _errorMessage.value = null
        engine.sendPhone(phone) { err ->
            _isLoading.value = false
            _errorMessage.value = err
        }
    }

    fun verifyCode(code: String) {
        _isLoading.value = true
        _errorMessage.value = null
        engine.sendCode(code) { err ->
            _isLoading.value = false
            _errorMessage.value = err
        }
    }

    fun verify2FA(password: String) {
        _isLoading.value = true
        _errorMessage.value = null
        engine.sendPassword(password) { err ->
            _isLoading.value = false
            _errorMessage.value = err
        }
    }

    fun logout(onDone: () -> Unit) {
        engine.logout(onDone)
    }

    fun clearError() { _errorMessage.value = null }

    class Factory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(TelegramEngine.getInstance(context)) as T
        }
    }
}
