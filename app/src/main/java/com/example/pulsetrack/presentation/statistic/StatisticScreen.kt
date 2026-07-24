package com.example.pulsetrack.presentation.statistic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.ui.theme.PulseTrackTheme

@Composable
fun StatisticScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(
            PulseTrackTheme.spacing.md
        ),
    ) {
        item {
            Column() {
                Text(
                    "Weekly Progress", style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.outline
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row {
                        Text("15Km", style = MaterialTheme.typography.titleMedium)
                        Text(
                            " / 30km goal", style = MaterialTheme.typography.titleMedium.copy(
                                color = MaterialTheme.colorScheme.outline
                            )
                        )
                    }
                    Text(
                        "50% Complete", style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                }
                Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.sm))
                Card(
                    modifier = Modifier.height(230.dp).fillMaxWidth(),

                ) { }
            }
        }
    }
}