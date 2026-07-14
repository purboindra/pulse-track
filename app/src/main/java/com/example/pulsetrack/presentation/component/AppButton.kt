package com.example.pulsetrack.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pulsetrack.ui.theme.PulseTrackTheme

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    label: String
) {
    ElevatedButton(
        enabled = enabled,
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(PulseTrackTheme.spacing.md),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
    ) {
        Text(
            label,
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.surface
            )
        )
    }
}