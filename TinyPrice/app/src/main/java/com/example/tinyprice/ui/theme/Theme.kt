package com.example.tinyprice.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Ocean,
    onPrimary = Color.White,
    primaryContainer = SeaFoam,
    onPrimaryContainer = OceanDark,
    secondary = Color(0xFF166582),
    secondaryContainer = Color(0xFFE0F5FC),
    tertiary = Color(0xFF0F766E),
    background = Mist,
    onBackground = Ink,
    surface = Color.White,
    onSurface = Ink,
    surfaceVariant = Color(0xFFEAF4F7),
    onSurfaceVariant = Color(0xFF52616B),
    outlineVariant = Color(0xFFC9D9DE)
)

private val DarkColorScheme = darkColorScheme(
    primary = SeaFoam,
    onPrimary = OceanDark,
    background = Ink,
    onBackground = Mist,
    surface = Ink,
    onSurface = Mist
)

@Composable
fun TinyPriceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val scheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = scheme,
        typography = Typography,
        content = content
    )
}