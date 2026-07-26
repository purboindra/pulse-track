package com.example.pulsetrack.presentation.statistic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.pulsetrack.ui.theme.PulseTrackTheme

private val activities = listOf(
    1,
    4,
    8,
    4, 1, 0,
    7,
    6, 0,
    9,
    2, 4, 0, 3, 5, 1, 0, 7, 8
)

@Composable
fun MonthlyActivity(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(

            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                "MONTHLY ACTIVITY", style = MaterialTheme.typography.labelSmall.copy(
                    color = MaterialTheme.colorScheme.outline
                )
            )
            Text(
                "October 2023", style = MaterialTheme.typography.labelSmall.copy(
                    color = MaterialTheme.colorScheme.outline,
                    fontSize = 11.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.base))
        ActivityHeatMap(
            activities
        )
    }
}