package com.example.pulsetrack.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.presentation.component.CardStatus
import com.example.pulsetrack.ui.theme.PulseTrackTheme

@OptIn(ExperimentalGridApi::class)
@Composable
fun GridStatus(modifier: Modifier = Modifier) {
    Grid(
        config = {
            repeat(2) {
                column(171.dp)
            }
            repeat(2) {
                row(96.dp)
            }
            gap(8.dp)
        }
    ) {
        CardStatus(
            modifier = Modifier.fillMaxWidth(),
            value = "124.5",
            label = "TOTAL DISTANCE",
            unitValue = "km",
            progress = 0.5f
        )
        CardStatus(
            modifier = Modifier.fillMaxWidth(),
            value = "24",
            label = "TOTAL RUNS",
            unitValue = "sessions",
            progress = 0.5f,
            progressColor = MaterialTheme.colorScheme.secondary
        )
        CardStatus(
            modifier = Modifier.fillMaxWidth(),
            value = "5:45",
            label = "AVG PACE",
            unitValue = "/km",
            progressCompose = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.xxs)
                ) {
                    Icon(
                        Icons.Default.ArrowCircleUp,
                        contentDescription = "",
                        modifier = Modifier.size(14.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        "Top 15%", style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                        )
                    )
                }
            }
        )
        CardStatus(
            modifier = Modifier.fillMaxWidth(),
            value = "12h 30m",
            label = "DURATION",
            unitValue = "",
            progressCompose = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.xxs)
                ) {
                    Icon(
                        Icons.Default.AccessTime,
                        contentDescription = "",
                        modifier = Modifier.size(14.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        "This month", style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        )
    }
}