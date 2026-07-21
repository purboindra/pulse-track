package com.example.pulsetrack.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.presentation.component.RowTextWithIcon
import com.example.pulsetrack.ui.theme.PulseTrackTheme
import com.example.pulsetrack.ui.theme.PureWhite

@Composable
fun RecentRun(modifier: Modifier = Modifier) {

    val items = listOf<String>("1", "")

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Recent Run", style = MaterialTheme.typography.titleMedium)
            Text(
                "View History", style = MaterialTheme.typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.clickable(onClick = {})
            )
        }
        Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.base))
        Column(
            verticalArrangement = Arrangement.spacedBy(
                PulseTrackTheme.spacing.sm
            )
        ) {
            items.forEach { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(112.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = PureWhite,
                    )
                ) {
                    Row() {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(120.dp)
                                .background(Color.Blue)
                        )
                        Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.base))
                        Column(
                            modifier = Modifier.padding(
                                PulseTrackTheme.spacing.sm
                            )
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        "October 12, 2026",
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    )
                                    Text(
                                        "Evening Forest Trail",
                                        style = MaterialTheme.typography.titleMedium,
                                    )
                                }
                                Icon(
                                    Icons.Default.ChevronRight,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Row(horizontalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.base)) {
                                RowTextWithIcon(
                                    icon = Icons.Outlined.LocationOn,
                                    contentDescription = "Distance",
                                    label = "8.2 km"
                                )
                                RowTextWithIcon(
                                    icon = Icons.Outlined.Timer,
                                    contentDescription = "Time",
                                    label = "48:12"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}