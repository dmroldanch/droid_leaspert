package com.iteneum.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = Snow,
    onPrimary = JuneBud,
    secondary = Drab,
    background = EerieBlack,
    error = RedSalsa,
    tertiary = Boulder
)

private val LightColorPalette = lightColorScheme(
    primary = Snow,
    onPrimary = JuneBud,
    secondary = Drab,
    background = EerieBlack,
    error = RedSalsa,
    tertiary = Boulder
)

@Composable
fun LeasePertTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme){
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = LPTypography,
        content = content
    )
}