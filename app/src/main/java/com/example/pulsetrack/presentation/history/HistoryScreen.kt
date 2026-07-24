package com.example.pulsetrack.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pulsetrack.ui.theme.PulseTrackTheme
import com.example.pulsetrack.ui.theme.PureWhite

data class RunHistory(
    val id: Number,
    val date: String,
    val title: String,
    val distance: Double,
    val time: String,
    val pace: String
)


private val histories: List<RunHistory> = listOf(
    RunHistory(
        id = 1,
        date = "Oct 12, 2026",
        title = "Morning Run",
        distance = 5.2,
        time = "25:12",
        pace = "4:51/km"
    ),
    RunHistory(
        id = 2,
        date = "Oct 10, 2026",
        title = "Evening Trail",
        distance = 8.4,
        time = "45:30",
        pace = "5:25/km"
    ),
    RunHistory(
        id = 3,
        date = "Oct 08, 2026",
        title = "Interval Training",
        distance = 3.5,
        time = "18:45",
        pace = "5:21/km"
    ),
    RunHistory(
        id = 4,
        date = "Oct 05, 2026",
        title = "City Run",
        distance = 10.0,
        time = "52:10",
        pace = "5:13/km"
    ),
    RunHistory(
        id = 5,
        date = "Oct 06, 2026",
        title = "City Run",
        distance = 8.2,
        time = "52:10",
        pace = "5:13/km"
    ),

    RunHistory(
        id = 6,
        date = "Oct 07, 2026",
        title = "City Run",
        distance = 8.2,
        time = "52:10",
        pace = "5:13/km"
    )
)

private val tabs = listOf(
    "This Week",
    "This Month",
    "All"
)

@Composable
fun HistoryScreen(modifier: Modifier = Modifier) {

    var selectedText by remember { mutableStateOf(tabs.first()) }

    Column(
        modifier = modifier.padding(
            PulseTrackTheme.spacing.md
        ), verticalArrangement = Arrangement.spacedBy(
            PulseTrackTheme.spacing.lg
        )
    ) {
        Box(
            modifier = Modifier
                .height(32.dp)
                .fillMaxWidth()
        ) {
            LazyRow(
                modifier = Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.sm)
            ) {
                items(tabs, key = { tab ->
                    tab
                }) { tab ->
                    val hasSelect = selectedText == tab
                    Box(
                        modifier = Modifier
                            .height(32.dp)
                            .border(
                                width = 1.dp,
                                color = if (hasSelect) Color.Transparent else MaterialTheme.colorScheme.outlineVariant,
                                shape = RoundedCornerShape(100),
                            )
                            .clip(
                                RoundedCornerShape(100),
                            )
                            .background(
                                color = if (hasSelect) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
                            )
                            .clickable(
                                onClick = {
                                    selectedText = tab
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            tab, style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = if (hasSelect) MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            modifier = Modifier.padding(
                                horizontal = PulseTrackTheme.spacing.lg,
                                vertical = PulseTrackTheme.spacing.sm
                            )
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.base))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.sm)
        ) {
            items(histories, key = {
                it.id
            }) { item ->
                Card(
                    modifier = Modifier
                        .height(135.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = PureWhite,
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(PulseTrackTheme.spacing.base),
                        verticalAlignment = Alignment.Top
                    ) {
                        Box(
                            modifier = Modifier
                                .size(96.dp)
                                .clip(
                                    RoundedCornerShape(PulseTrackTheme.spacing.xs)
                                )
                                .background(
                                    Color.Gray
                                )
                        )
                        Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.base))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                item.date, style = MaterialTheme.typography.labelSmall.copy(
                                    color = MaterialTheme.colorScheme.outline
                                )
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                item.title, style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.SemiBold
                                ),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                InfoComponent(
                                    title = "Distance",
                                    value = "${item.distance} km"
                                )
                                InfoComponent(
                                    title = "Time",
                                    value = item.time
                                )
                                InfoComponent(
                                    title = "Pace",
                                    value = item.pace
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.xxs))
                        Icon(
                            Icons.Default.ChevronRight,
                            contentDescription = "",
                            modifier = Modifier.size(PulseTrackTheme.spacing.base),
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
        }
    }
}