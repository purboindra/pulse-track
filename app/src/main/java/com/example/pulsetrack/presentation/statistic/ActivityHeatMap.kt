package com.example.pulsetrack.presentation.statistic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pulsetrack.ui.theme.PulseTrackTheme
import com.example.pulsetrack.ui.theme.PureWhite


@Composable
fun ActivityHeatMap(activityData: List<Int>) {
    val days = listOf("S", "M", "T", "W", "T", "F", "S")

    Card(
        colors = CardDefaults.cardColors(containerColor = PureWhite),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                days.forEach { day ->
                    Text(day, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.sm))

            LazyVerticalGrid(
                columns = GridCells.Fixed(7),
                verticalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.sm),
                horizontalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.sm),
                modifier = Modifier.height(180.dp),
                userScrollEnabled = false
            ) {
                items(activityData) { activityLevel ->
                    Box(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(androidx.compose.foundation.shape.RoundedCornerShape(2.dp))
                            .background(getHeatmapColor(activityLevel))
                    )
                }
            }
            Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.sm))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    "Less", style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                )
                Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.sm))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.xxs)
                ) {
                    listOf(0, 2, 4).forEach { it ->
                        Box(
                            modifier = Modifier
                                .size(PulseTrackTheme.spacing.base)
                                .clip(
                                    RoundedCornerShape(2.dp)
                                )
                                .background(
                                    getHeatmapColor(it)
                                )
                        )
                    }
                }
                Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.sm))
                Text(
                    "More", style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                )
            }
        }
    }
}

fun getHeatmapColor(level: Int): Color {
    return when {
        level == 0 -> Color(0xFFEBEDF0) // Empty
        level < 3 -> Color(0xFF9BE9A8)  // Light Green
        level < 6 -> Color(0xFF40C463)  // Medium Green
        else -> Color(0xFF216E39)       // Dark Green
    }
}