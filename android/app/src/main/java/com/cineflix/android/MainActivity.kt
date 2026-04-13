package com.cineflix.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cineflix.android.TelegramEngine
import com.cineflix.android.ui.player.PlayerActivity
import com.cineflix.android.ui.screens.*
import com.cineflix.android.ui.theme.CineflixTheme
import com.cineflix.android.viewmodel.*

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels { AuthViewModel.Factory(this) }
    private val homeViewModel: HomeViewModel by viewModels { HomeViewModel.Factory(this) }
    private val epsViewModel:  EpisodesViewModel by viewModels { EpisodesViewModel.Factory(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        // Initialize TDLib engine singleton
        TelegramEngine.getInstance(applicationContext)

        setContent {
            CineflixTheme {
                CineflixApp(
                    authViewModel = authViewModel,
                    homeViewModel = homeViewModel,
                    epsViewModel  = epsViewModel,
                    onPlayEpisode = { episode ->
                        PlayerActivity.start(
                            context  = this,
                            fileId   = episode.fileId,
                            chatId   = episode.chatId,
                            msgId    = episode.msgId,
                            title    = episode.caption.ifEmpty { episode.fileName },
                        )
                    }
                )
            }
        }
    }

    override fun onBackPressed() {
        // delegated to Compose navigation
        super.onBackPressed()
    }
}

@Composable
private fun CineflixApp(
    authViewModel: AuthViewModel,
    homeViewModel: HomeViewModel,
    epsViewModel: EpisodesViewModel,
    onPlayEpisode: (TelegramEngine.VideoInfo) -> Unit,
) {
    val navController = rememberNavController()
    val authState by authViewModel.authState.collectAsState()
    val userName  by authViewModel.userName.collectAsState()

    // Determine start destination based on auth state
    val startDest = when (authState) {
        is TelegramEngine.AuthState.Ready -> "home"
        else                              -> "login"
    }

    // Remember last selected catalog item for episodes screen
    var selectedSeries by remember { mutableStateOf<CatalogItem?>(null) }
    var selectedPoster  by remember { mutableStateOf<String?>(null) }

    NavHost(navController = navController, startDestination = startDest) {

        composable("login") {
            LoginScreen(
                viewModel  = authViewModel,
                onLoggedIn = { navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }},
            )
        }

        composable("home") {
            HomeScreen(
                viewModel    = homeViewModel,
                userName     = userName,
                onSeriesClick = { item ->
                    selectedSeries = item
                    selectedPoster = homeViewModel.posterUrl(item.posterPath)
                    navController.navigate("episodes")
                },
                onMovieClick = { movie ->
                    // Movies treated as series for now (bot payload)
                    selectedSeries = CatalogItem(
                        id      = movie.id,
                        title   = movie.title,
                        payload = movie.payload,
                        type    = "movie",
                        posterPath = movie.posterPath,
                        overview   = movie.overview,
                    )
                    selectedPoster = homeViewModel.posterUrl(movie.posterPath)
                    navController.navigate("episodes")
                },
                onLogout = {
                    authViewModel.logout {
                        navController.navigate("login") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                },
            )
        }

        composable("episodes") {
            val item = selectedSeries ?: return@composable
            EpisodesScreen(
                item          = item,
                posterUrl     = selectedPoster,
                viewModel     = epsViewModel,
                onPlayEpisode = onPlayEpisode,
                onBack        = { navController.navigateUp() },
            )
        }
    }
}
