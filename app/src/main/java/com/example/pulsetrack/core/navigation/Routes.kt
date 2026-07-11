package com.example.pulsetrack.core.navigation

import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
sealed interface Routes {
    data object Splash : Routes
    data object OnBoarding : Routes
    data object Main : Routes
    data object Run : Routes
    data object History : Routes
    data object Stats : Routes
    data object Profile : Routes
}


sealed class BottomNavbar(val route: Routes, val icon: ImageVector, val label: String) {
    object Home : BottomNavbar(Routes.Main, Icons.Default.Home, "Home")
    object Run : BottomNavbar(Routes.Run, Icons.Default.PlayArrow, "Run")
    object History :
        BottomNavbar(Routes.History, Icons.Default.History, "History")
    object Stats : BottomNavbar(Routes.Stats, Icons.Default.BarChart, "Stats")
    object Profile : BottomNavbar(Routes.Profile, Icons.Default.Person, "Profile")
}