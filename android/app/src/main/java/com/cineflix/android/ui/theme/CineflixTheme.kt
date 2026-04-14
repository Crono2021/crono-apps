package com.cineflix.android.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val AppColorScheme = darkColorScheme(
    primary          = Purple,
    onPrimary        = TextPrimary,
    primaryContainer = PurpleDark,
    secondary        = Cyan,
    background       = AppBg,
    surface          = Surface1,
    surfaceVariant   = Surface2,
    onBackground     = TextPrimary,
    onSurface        = TextPrimary,
    onSurfaceVariant = TextFaint,
    error            = NetflixRed,
)

val AppTypography = Typography(
    displayMedium = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 28.sp, color = TextTitle),
    headlineLarge = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 22.sp, color = TextTitle),
    headlineMedium= TextStyle(fontWeight = FontWeight.Bold,      fontSize = 18.sp, color = TextTitle),
    titleLarge    = TextStyle(fontWeight = FontWeight.ExtraBold,  fontSize = 18.sp, color = TextTitle),
    titleMedium   = TextStyle(fontWeight = FontWeight.Bold,      fontSize = 15.sp, color = TextTitle),
    bodyLarge     = TextStyle(fontWeight = FontWeight.Normal,    fontSize = 15.sp, color = TextPrimary),
    bodyMedium    = TextStyle(fontWeight = FontWeight.Normal,    fontSize = 14.sp, color = TextFaint),
    bodySmall     = TextStyle(fontWeight = FontWeight.Normal,    fontSize = 12.sp, color = TextMuted),
    labelLarge    = TextStyle(fontWeight = FontWeight.SemiBold,  fontSize = 13.sp, color = TextPrimary),
    labelMedium   = TextStyle(fontWeight = FontWeight.Medium,    fontSize = 11.sp, color = TextFaint),
    labelSmall    = TextStyle(fontWeight = FontWeight.Medium,    fontSize = 10.sp, color = TextMuted),
)

@Composable
fun CineflixTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography  = AppTypography,
        content     = content,
    )
}
