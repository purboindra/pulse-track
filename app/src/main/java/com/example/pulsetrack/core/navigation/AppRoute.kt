package com.example.pulsetrack.core.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.pulsetrack.presentation.main.MainScreen
import com.example.pulsetrack.presentation.onboarding.OnBoardingScreen

@Composable
fun AppRoute() {

    val backStack = remember { mutableStateListOf<Routes>(Routes.OnBoarding) }

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeAt(backStack.size - 1)
            }
        },
        entryProvider = { key ->
            when (key) {
                is Routes.OnBoarding -> NavEntry(key) {
                    OnBoardingScreen(
                        onClick = {
                            backStack.add(Routes.Main)
                            backStack.remove(Routes.OnBoarding)
                        }
                    )
                }

                is Routes.Main -> NavEntry(key) {
                    MainScreen()
                }

                else -> NavEntry(key) {
                    Text("Else Screen")
                }
            }
        }
    )
}