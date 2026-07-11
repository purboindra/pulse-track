package com.example.pulsetrack.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class PulseTrackElevations(
    val level0: Dp = 0.dp,
    val level1: Dp = 2.dp,
    val level2: Dp = 6.dp
)

val LocalPulseTrackElevations = staticCompositionLocalOf { PulseTrackElevations() }