package com.example.pulsetrack.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// --- Color Primitives ---
val FitnessGreen = Color(0xFF00D166)
val FitnessGreenDark = Color(0xFF006D32)
val ElectricBlue = Color(0xFF2563EB)
val ElectricBlueLight = Color(0xFFDBEAFE)

val CharcoalDark = Color(0xFF191C1D)
val CharcoalVariant = Color(0xFF3C4A3D)
val OffWhite = Color(0xFFF8F9FA)
val PureWhite = Color(0xFFFFFFFF)

// --- Color Schemes ---
val LightColorScheme = lightColorScheme(
    primary = FitnessGreenDark,
    onPrimary = Color.White,
    primaryContainer = FitnessGreen,
    onPrimaryContainer = Color(0xFF005324),

    secondary = Color(0xFF0051d5),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF316bf3),
    onSecondaryContainer = Color(0xFFFEFCFF),

    tertiary = Color(0xFFB91A24),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFF9A93),
    onTertiaryContainer = Color(0xFF930013),

    background = OffWhite,
    onBackground = CharcoalDark,

    surface = OffWhite,
    onSurface = CharcoalDark,
    surfaceVariant = Color(0xFFE1E3E4),
    onSurfaceVariant = CharcoalVariant,

    outline = Color(0xFF6C7B6C),
    outlineVariant = Color(0xFFBBCBB9),

    error = Color(0xFFBA1A1A),
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF93000A)
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF30E375),
    onPrimary = Color(0xFF003916),
    primaryContainer = Color(0xFF005224),
    onPrimaryContainer = Color(0xFF64FF92),
)