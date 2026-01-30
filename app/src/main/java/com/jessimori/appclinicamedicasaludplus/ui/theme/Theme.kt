package com.jessimori.appclinicamedicasaludplus.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = BluePrimary,
    secondary = GreenSecondary,
    background = BlueBackground,
    surface = WhiteSurface,
    onPrimary = WhiteSurface,
    onSecondary = WhiteSurface,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

@Composable
fun AppClinicaMedicaSaludplusTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}