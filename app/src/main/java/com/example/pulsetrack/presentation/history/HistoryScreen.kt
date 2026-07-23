package com.example.pulsetrack.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.ui.theme.PulseTrackTheme

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
    }
}