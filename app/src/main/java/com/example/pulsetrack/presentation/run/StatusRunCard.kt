package com.example.pulsetrack.presentation.run

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pulsetrack.ui.theme.PulseTrackTheme

@Composable
fun StatusRunCard(
    label: String,
    value: String,
    unit: String,
    modifier: Modifier = Modifier
) {
    Card(
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xffBBCBB9).copy(
                alpha = 0.20f
            )
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xffF8F9FA)
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = PulseTrackTheme.spacing.base
                )
        ) {
            Text(
                label, style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    value, style = MaterialTheme.typography.headlineMedium,
                )
                Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.xs))
                Text(
                    unit, style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }
        }
    }
}