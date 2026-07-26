package com.example.pulsetrack.presentation.statistic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.ui.theme.PulseTrackTheme

@Composable
fun StatisticCardSection(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(
                vertical = PulseTrackTheme.spacing.base
            ),
        horizontalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.sm)
    ) {
        StatisticCard(
            modifier = Modifier.weight(1f),
            label = "Longest Run",
            value = "15km"
        )
        StatisticCard(
            modifier = Modifier.weight(1f),
            label = "Fastest Pace",
            value = "4:45/km"
        )
    }
}