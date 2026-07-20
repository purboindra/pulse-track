package com.example.pulsetrack.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.ui.theme.PulseTrackTheme
import com.example.pulsetrack.ui.theme.PureWhite

@Composable
fun WeeklyProgress(modifier: Modifier = Modifier) {
    val progress = listOf<Float>(
        0.9f, 0.3f, 0.5f, 0.8f, 0.1f, 0.4f
    )

    Card(
        modifier = modifier, colors = CardDefaults.cardColors(
            containerColor = PureWhite,
        )
    ) {
        Column(
            modifier = Modifier.padding(PulseTrackTheme.spacing.md),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Weekly Progress", style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                    )
                )
                Text(
                    "32.4 km total", style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
            Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.base))
            LazyRow(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(
                        horizontal = PulseTrackTheme.spacing.base
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(progress) { progress ->
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.weight(1f - progress))
                        Box(
                            modifier = Modifier
                                .width(14.dp)
                                .weight(progress)
                                .clip(
                                    RoundedCornerShape(100)
                                )
                                .background(
                                    MaterialTheme.colorScheme.primary
                                )
                        )
                        Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.sm))

                        Text("M")
                    }
                }
            }
        }
    }
}