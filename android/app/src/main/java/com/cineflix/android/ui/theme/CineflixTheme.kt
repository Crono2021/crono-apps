package com.cineflix.android.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    primary          = CineflixRed,
    onPrimary        = TextPrimary,
    primaryContainer = CineflixRedDark,
    secondary        = AccentBlue,
    background       = Background,
    surface          = SurfaceDark,
    surfaceVariant   = SurfaceMid,
    onBackground     = TextPrimary,
    onSurface        = TextPrimary,
    onSurfaceVariant = TextSecondary,
    error            = Color(0xFFCF6679),
)

val CineflixTypography = Typography(
    displayLarge  = TextStyle(fontWeight = FontWeight.Bold,   fontSize = 32.sp, color = TextPrimary),
    displayMedium = TextStyle(fontWeight = FontWeight.Bold,   fontSize = 28.sp, color = TextPrimary),
    headlineLarge = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 24.sp, color = TextPrimary),
    headlineMedium= TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 20.sp, color = TextPrimary),
    titleLarge    = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp, color = TextPrimary),
    titleMedium   = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp, color = TextPrimary),
    bodyLarge     = TextStyle(fontWeight = FontWeight.Normal, fontSize = 15.sp, color = TextPrimary),
    bodyMedium    = TextStyle(fontWeight = FontWeight.Normal, fontSize = 14.sp, color = TextSecondary),
    bodySmall     = TextStyle(fontWeight = FontWeight.Normal, fontSize = 12.sp, color = TextMuted),
    labelLarge    = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = TextPrimary),
    labelMedium   = TextStyle(fontWeight = FontWeight.Medium, fontSize = 12.sp, color = TextSecondary),
)

@Composable
fun CineflixTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography  = CineflixTypography,
        content     = content,
    )
}
