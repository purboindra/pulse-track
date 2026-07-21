package com.example.pulsetrack.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.ui.theme.PulseTrackTheme

@Composable
fun RowTextWithIcon(
    icon: ImageVector,
    label: String,
    contentDescription: String = "",
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(12.dp)
        )
        Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.xxs))
        Text(label, style = MaterialTheme.typography.labelLarge)
    }
}