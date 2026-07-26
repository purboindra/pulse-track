package com.example.pulsetrack.presentation.profile

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun UserInfo() {
    Text(
        "Alex Runner", style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold,
        )
    )
    Text(
        "Member since Jan 2024", style = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}