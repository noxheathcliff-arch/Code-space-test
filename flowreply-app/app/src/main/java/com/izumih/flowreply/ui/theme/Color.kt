package com.izumih.flowreply.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/*
 * Baseline (static) color scheme used as a fallback when Material You dynamic
 * color is unavailable (pre-Android 12). Source color: a warm indigo/violet,
 * tones generated to satisfy the 26 Material 3 color roles.
 */

private val Primary = Color(0xFF5B5BD6)
private val OnPrimary = Color(0xFFFFFFFF)
private val PrimaryContainer = Color(0xFFE3E0FF)
private val OnPrimaryContainer = Color(0xFF14005B)

private val Secondary = Color(0xFF5D5C72)
private val OnSecondary = Color(0xFFFFFFFF)
private val SecondaryContainer = Color(0xFFE3E0F9)
private val OnSecondaryContainer = Color(0xFF1A1A2C)

private val Tertiary = Color(0xFF79536A)
private val OnTertiary = Color(0xFFFFFFFF)
private val TertiaryContainer = Color(0xFFFFD8EC)
private val OnTertiaryContainer = Color(0xFF2E1125)

private val Error = Color(0xFFBA1A1A)
private val OnError = Color(0xFFFFFFFF)
private val ErrorContainer = Color(0xFFFFDAD6)
private val OnErrorContainer = Color(0xFF410002)

val LightColors = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    primaryContainer = PrimaryContainer,
    onPrimaryContainer = OnPrimaryContainer,
    secondary = Secondary,
    onSecondary = OnSecondary,
    secondaryContainer = SecondaryContainer,
    onSecondaryContainer = OnSecondaryContainer,
    tertiary = Tertiary,
    onTertiary = OnTertiary,
    tertiaryContainer = TertiaryContainer,
    onTertiaryContainer = OnTertiaryContainer,
    error = Error,
    onError = OnError,
    errorContainer = ErrorContainer,
    onErrorContainer = OnErrorContainer,
    background = Color(0xFFFBF8FF),
    onBackground = Color(0xFF1B1B21),
    surface = Color(0xFFFBF8FF),
    onSurface = Color(0xFF1B1B21),
    surfaceVariant = Color(0xFFE4E1EC),
    onSurfaceVariant = Color(0xFF47464F),
    outline = Color(0xFF777680),
    outlineVariant = Color(0xFFC8C5D0),
)

val DarkColors = darkColorScheme(
    primary = Color(0xFFC3C0FF),
    onPrimary = Color(0xFF270090),
    primaryContainer = Color(0xFF4140BD),
    onPrimaryContainer = Color(0xFFE3E0FF),
    secondary = Color(0xFFC6C4DD),
    onSecondary = Color(0xFF2F2F42),
    secondaryContainer = Color(0xFF454559),
    onSecondaryContainer = Color(0xFFE3E0F9),
    tertiary = Color(0xFFE9B9D3),
    onTertiary = Color(0xFF46263A),
    tertiaryContainer = Color(0xFF5F3C51),
    onTertiaryContainer = Color(0xFFFFD8EC),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    background = Color(0xFF131318),
    onBackground = Color(0xFFE4E1E9),
    surface = Color(0xFF131318),
    onSurface = Color(0xFFE4E1E9),
    surfaceVariant = Color(0xFF47464F),
    onSurfaceVariant = Color(0xFFC8C5D0),
    outline = Color(0xFF918F9A),
    outlineVariant = Color(0xFF47464F),
)
