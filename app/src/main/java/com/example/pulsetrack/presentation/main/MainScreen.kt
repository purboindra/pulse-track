package com.example.pulsetrack.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.pulsetrack.core.navigation.BottomNavbar
import com.example.pulsetrack.presentation.component.AppBar
import com.example.pulsetrack.presentation.history.HistoryScreen
import com.example.pulsetrack.presentation.home.HomeScreen
import com.example.pulsetrack.presentation.statistic.StatisticScreen
import kotlinx.coroutines.launch
import kotlin.collections.mutableSetOf


private val bottomNavbarItems = listOf(
    BottomNavbar.Home,
    BottomNavbar.Run,
    BottomNavbar.History,
    BottomNavbar.Stats,
    BottomNavbar.Profile
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    var selectedItem by remember { mutableStateOf<BottomNavbar>(BottomNavbar.Home) }
    val backStack = remember(selectedItem) { mutableStateListOf(selectedItem) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    AppBar()
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.background
            ) {
                bottomNavbarItems.forEach { item ->
                    NavigationBarItem(
                        onClick = {
                            selectedItem = item
                        },
                        selected = selectedItem == item,
                        icon = {
                            Icon(item.icon, contentDescription = item.label)
                        },
                        label = {
                            Text(item.label)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.background,
                            selectedTextColor = MaterialTheme.colorScheme.secondaryContainer,
                            indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        NavDisplay(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            backStack = backStack,
            onBack = {},
            entryProvider = { key ->
                when (key) {
                    is BottomNavbar.Home -> NavEntry(key) {
                        HomeScreen()
                    }

                    is BottomNavbar.Run -> NavEntry(key) {
                        Text("Run Screen")
                    }

                    is BottomNavbar.Profile -> NavEntry(key) {
                        Text("Profile Screen")
                    }


                    is BottomNavbar.History -> NavEntry(key) {
                        HistoryScreen(modifier = Modifier.fillMaxSize())
                    }


                    is BottomNavbar.Stats -> NavEntry(key) {
                        StatisticScreen(modifier = Modifier.fillMaxSize())
                    }
                }
            }
        )
    }
}