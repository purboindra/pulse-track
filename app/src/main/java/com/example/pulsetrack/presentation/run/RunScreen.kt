package com.example.pulsetrack.presentation.run

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pulsetrack.presentation.component.AppButton
import com.example.pulsetrack.presentation.component.OsmMapView
import com.example.pulsetrack.ui.theme.PulseTrackTheme

@OptIn(ExperimentalGridApi::class)
@Composable

fun RunScreen(modifier: Modifier = Modifier) {


  
    Column(
        modifier = modifier.padding(
            PulseTrackTheme.spacing.md
        ),
    ) {
        OsmMapView(
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(PulseTrackTheme.spacing.base))
        )
        Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.base))
        LazyColumn(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "DURATION", style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                    Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.xs))
                    Text(
                        "00:45:14", style = MaterialTheme.typography.headlineLarge.copy(
                            fontSize = 48.sp,
                        )
                    )
                }
                Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.lg))
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
                    StatusRunCard(
                        label = "DISTANCE",
                        value = "8.2",
                        unit = "km"
                    )
                    StatusRunCard(
                        label = "PACE",
                        value = "5:32",
                        unit = "/km"
                    )
                    StatusRunCard(
                        label = "AVG PACE",
                        value = "5:40",
                        unit = "/km"
                    )
                    StatusRunCard(
                        label = "CALORIES",
                        value = "450",
                        unit = "kcal"
                    )
                }
                Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.lg))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppButton(
                        onClick = {}, label = "PAUSE", modifier = Modifier
                            .weight(1f)
                            .height(72.dp),
                        shape = RoundedCornerShape(PulseTrackTheme.spacing.base)
                    )
                    Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.sm))
                    Box(
                        modifier = Modifier
                            .size((72.dp))
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                shape = RoundedCornerShape(PulseTrackTheme.spacing.base)
                            )
                            .clip(
                                RoundedCornerShape(PulseTrackTheme.spacing.base)
                            )
                            .background(
                                Color(0xffFFB3AD)
                            )
                            .clickable(
                                onClick = {}
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Pause,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                }
            }
        }
    }
}