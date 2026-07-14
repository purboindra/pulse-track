package com.example.pulsetrack.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.ui.theme.PulseTrackTheme
import com.example.pulsetrack.ui.theme.PureWhite

@Composable
fun CardStatus(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    unitValue: String,
    progress: Float? = null,
    progressColor: Color? = null,
    progressCompose: (@Composable () -> Unit)? = null
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = PureWhite,
        )
    ) {
        Column(
            modifier = Modifier.padding(PulseTrackTheme.spacing.md),
            verticalArrangement = Arrangement.spacedBy(PulseTrackTheme.spacing.xs)
        ) {
            Text(
                label, style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    value, style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.xxs))
                Text(
                    unitValue, style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            if (progressCompose != null) {
                progressCompose()
            } else {
                LinearProgressIndicator(
                    progress = { progress ?: 0f },
                    trackColor = Color.Gray,
                    modifier = Modifier
                        .height(4.dp),
                    color = progressColor ?: MaterialTheme.colorScheme.primaryContainer,
                    strokeCap = StrokeCap.Round,
                    gapSize = (-15).dp,
                    drawStopIndicator = {}
                )
            }
        }
    }
}
