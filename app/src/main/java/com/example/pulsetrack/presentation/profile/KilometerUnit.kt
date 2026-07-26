package com.example.pulsetrack.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pulsetrack.ui.theme.PulseTrackTheme
import com.example.pulsetrack.ui.theme.PureWhite

@Composable
fun KilometerUnit(
    modifier: Modifier = Modifier,
    isActive: Boolean,
    onClick: () -> Unit,
    label: String
) {
    Box(
        modifier = Modifier
            .padding(
                horizontal = PulseTrackTheme.spacing.xs
            )
            .clip(
                RoundedCornerShape(PulseTrackTheme.spacing.xs)
            )
            .background(color = if (isActive) PureWhite else Color(0xffEDEEEF))
            .clickable(
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            label,
            style = MaterialTheme.typography.labelSmall.copy(
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isActive) Color.Black else MaterialTheme.colorScheme.outline
            ),
            modifier = Modifier.padding(
                vertical = PulseTrackTheme.spacing.xs,
                horizontal = PulseTrackTheme.spacing.sm
            )
        )
    }
}