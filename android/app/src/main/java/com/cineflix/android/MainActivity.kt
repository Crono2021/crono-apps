package com.cineflix.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import com.cineflix.android.TelegramEngine
import com.cineflix.android.ui.player.PlayerActivity
import com.cineflix.android.ui.screens.EpisodesScreen
import com.cineflix.android.ui.screens.HomeScreen
import com.cineflix.android.ui.screens.LoginScreen
import com.cineflix.android.ui.theme.CineflixTheme
import com.cineflix.android.viewmodel.AuthViewModel
import com.cineflix.android.viewmodel.EpisodesViewModel
import com.cineflix.android.viewmodel.HomeViewModel

/**
 * MainActivity — single-Activity Compose app.
 * Navigation mirrors the web app's view stack:
 *   login → catalog/home → episodes (series detail) → player (launched as activity)
 */
class MainActivity : ComponentActivity() {

    private val authVm  by viewModels<AuthViewModel>  { AuthViewModel.Factory(this) }
    private val homeVm  by viewModels<HomeViewModel>  { HomeViewModel.Factory(this) }
    private val epVm    by viewModels<EpisodesViewModel> { EpisodesViewModel.Factory(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CineflixTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    private fun AppNavigation() {
        val authState by authVm.authState.collectAsState()
        val userName  by authVm.userName.collectAsState()

        // Simple enum-based navigation (matches web app's showView logic)
        var screen by remember { mutableStateOf<Screen>(Screen.Login) }

        // Auto-navigate when auth state changes
        LaunchedEffect(authState) {
            when (authState) {
                is TelegramEngine.AuthState.Ready -> {
                    if (screen == Screen.Login) screen = Screen.Home
                }
                is TelegramEngine.AuthState.WaitPhone,
                is TelegramEngine.AuthState.Unknown -> {
                    // stay on login
                }
                else -> {}
            }
        }

        when (screen) {
            Screen.Login -> LoginScreen(
                viewModel = authVm,
                onLoggedIn = { screen = Screen.Home },
            )

            Screen.Home -> HomeScreen(
                viewModel    = homeVm,
                userName     = userName,
                onSeriesClick = { item ->
                    epVm.openSeries(item.title, item.payload, isMovie = false)
                    screen = Screen.Episodes
                },
                onMovieClick  = { item ->
                    epVm.openSeries(item.title, item.payload, isMovie = true)
                    screen = Screen.Episodes
                },
                onLogout = {
                    authVm.logout {
                        screen = Screen.Login
                    }
                },
            )

            Screen.Episodes -> EpisodesScreen(
                viewModel = epVm,
                onBack    = { screen = Screen.Home },
                onPlayEpisode = { episode, _ ->
                    val intent = Intent(this, PlayerActivity::class.java).apply {
                        putExtra(PlayerActivity.EXTRA_FILE_ID,   episode.fileId)
                        putExtra(PlayerActivity.EXTRA_TITLE,     episode.fileName.ifEmpty { episode.caption })
                        putExtra(PlayerActivity.EXTRA_CHAT_ID,   episode.chatId)
                        putExtra(PlayerActivity.EXTRA_MSG_ID,    episode.msgId)
                    }
                    startActivity(intent)
                },
            )
        }
    }

    enum class Screen { Login, Home, Episodes }

    // System back button support
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // We can't read Compose state directly here, but PlayerActivity handles its own back
        super.onBackPressed()
    }
}
