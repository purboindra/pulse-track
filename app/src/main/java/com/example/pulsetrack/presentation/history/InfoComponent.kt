package com.example.pulsetrack.presentation.history

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun InfoComponent(title: String, value: String) {
    Column(
    ) {
        Text(
            title,
            style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.outline
            )
        )
        Text(
            value,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.SemiBold
            ),
        )
    }
}