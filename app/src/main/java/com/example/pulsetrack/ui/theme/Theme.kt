package com.example.pulsetrack.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

@Composable
fun PulseTrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val customTypography = CustomTypography(
        displayMetrics = TextStyle(
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 56.sp,
            letterSpacing = (-0.02).sp
        )
    )

    val view = LocalView.current
    if (!view.isInEditMode) {
        val window = (view.context as? Activity)?.window
        window?.let {
            WindowCompat.setDecorFitsSystemWindows(it, false)
            it.statusBarColor = android.graphics.Color.TRANSPARENT
            WindowCompat.getInsetsController(it, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalPulseTrackSpacing provides PulseTrackSpacing(),
        LocalPulseTrackElevations provides PulseTrackElevations(),
        LocalCustomTypography provides customTypography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            shapes = PulseTrackShapes,
            typography = M3Typography,
            content = content
        )
    }
}

object PulseTrackTheme {
    val spacing: PulseTrackSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalPulseTrackSpacing.current

    val elevations: PulseTrackElevations
        @Composable
        @ReadOnlyComposable
        get() = LocalPulseTrackElevations.current

    val customTypography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomTypography.current
}