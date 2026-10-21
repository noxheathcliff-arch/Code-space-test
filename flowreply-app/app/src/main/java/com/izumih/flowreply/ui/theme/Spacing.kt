package com.izumih.flowreply.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Material 3 system spacing tokens (base unit = 8dp). Exposed through a
 * CompositionLocal so screens reference tokens instead of magic numbers.
 */
data class Spacing(
    val space0: Dp = 0.dp,
    val space050: Dp = 4.dp,
    val space100: Dp = 8.dp,
    val space150: Dp = 12.dp,
    val space200: Dp = 16.dp,
    val space300: Dp = 24.dp,
    val space400: Dp = 32.dp,
    val space500: Dp = 40.dp,
    val space600: Dp = 48.dp,
)

val LocalSpacing = staticCompositionLocalOf { Spacing() }
