package com.example.pulsetrack.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material.icons.filled.Radar
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pulsetrack.ui.theme.PulseTrackTheme
import com.example.pulsetrack.ui.theme.PureWhite

private val kmUnits = listOf("KM", "MI")

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {

    var unit by remember { mutableStateOf(kmUnits.first()) }
    var allowNotification by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .padding(
                PulseTrackTheme.spacing.md
            ), verticalArrangement = Arrangement.spacedBy(
            PulseTrackTheme.spacing.lg
        )
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UserAvatar()
                UserInfo()
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = PulseTrackTheme.spacing.xl),
                verticalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.base)
            ) {
                CardSetting(
                    label = "RUNNING GOAL",
                    value = "30 km per week",
                    backgroundIconColor = MaterialTheme.colorScheme.primary,
                    icon = Icons.Default.Radar,
                    iconColor = MaterialTheme.colorScheme.primaryContainer
                )
                CardSetting(
                    label = "UNIT",
                    value = "Kilometers",
                    backgroundIconColor = Color(0xffDBE1FF),
                    icon = Icons.Default.HorizontalRule,
                    iconColor = Color(0xff003EA8),
                    rightCompose = {
                        Box(
                            modifier = Modifier
                                .height(32.dp)
                                .width(88.dp)
                                .clip(RoundedCornerShape(PulseTrackTheme.spacing.xs))
                                .background(
                                    Color(0xffEDEEEF)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                kmUnits.forEach { item ->
                                    KilometerUnit(
                                        label = item,
                                        isActive = unit == item,
                                        onClick = {
                                            unit = item
                                        }
                                    )
                                }
                            }
                        }
                    }
                )
                CardSetting(
                    label = "NOTIFICATIONS",
                    value = "On",
                    backgroundIconColor = Color(0xffFFDAD7),
                    icon = Icons.Default.Radar,
                    iconColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    rightCompose = {
                        Switch(
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = PureWhite,
                                uncheckedBorderColor = Color.Transparent,
                                checkedBorderColor = Color.Transparent,

                                ),
                            checked = allowNotification,
                            onCheckedChange = { value -> allowNotification = value }
                        )
                    }
                )
                CardSetting(
                    label = "CONNECTED APPS",
                    value = "Google Fit",
                    backgroundIconColor = MaterialTheme.colorScheme.surfaceVariant,
                    icon = Icons.Default.Apps,
                    iconColor = MaterialTheme.colorScheme.onBackground
                )
                CardSetting(
                    label = "SYSTEM",
                    value = "About PulseTrack",
                    backgroundIconColor = MaterialTheme.colorScheme.surfaceVariant,
                    icon = Icons.Outlined.Info,
                    iconColor = MaterialTheme.colorScheme.onBackground
                )
            }
        }
        item {
            TextButton(onClick = {}) {
                Text("Sign Out")
            }
        }
    }
}