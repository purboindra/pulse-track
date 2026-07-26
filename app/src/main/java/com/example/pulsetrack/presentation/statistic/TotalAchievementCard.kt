package com.example.pulsetrack.presentation.statistic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.ui.theme.PulseTrackTheme

@Composable
fun TotalAchievementCard(modifier: Modifier = Modifier) {
    val achievementGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF1C1C1E),
            Color(0xFF0F3D2E)
        ),
        start = Offset(0f, Float.POSITIVE_INFINITY),
        end = Offset(Float.POSITIVE_INFINITY, 0f)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(205.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(achievementGradient)
            .padding(
                PulseTrackTheme.spacing.lg
            ),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        "Total Distance",
                        color = Color.Gray,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            "124.5",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "km",
                            color = Color.White,
                            modifier = Modifier.padding(bottom = 6.dp, start = 4.dp)
                        )
                    }
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        "Total Time",
                        color = Color.Gray,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        "12h 42m",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(color = Color.White.copy(alpha = 0.1f), thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .width(72.dp)
                        .height(32.dp)
                ) {
                    BadgeCircle(
                        color = Color(0xFF006D35),
                        icon = Icons.Default.MilitaryTech,
                        modifier = Modifier.offset(x = 0.dp)
                    )
                    BadgeCircle(
                        color = Color(0xFF004FC4),
                        icon = Icons.Default.Stars,
                        modifier = Modifier.offset(x = 20.dp)
                    )
                    BadgeCircle(
                        color = Color(0xFF9B101C),
                        icon = Icons.Default.EmojiEvents,
                        modifier = Modifier.offset(x = 40.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "12 Badges Earned",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun BadgeCircle(
    color: Color,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(18.dp)
        )
    }
}
