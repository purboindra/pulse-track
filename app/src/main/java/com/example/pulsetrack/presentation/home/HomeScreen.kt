package com.example.pulsetrack.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulsetrack.presentation.component.AppButton
import com.example.pulsetrack.ui.theme.PulseTrackTheme

@OptIn(ExperimentalGridApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier.padding(
            PulseTrackTheme.spacing.md
        ), verticalArrangement = Arrangement.spacedBy(
            PulseTrackTheme.spacing.lg
        )
    ) {
        item {
            GridStatus()
        }
        item {
            AppButton(
                onClick = {}, label = "Start Run"
            )
        }
        item {
            WeeklyProgress(modifier = modifier.fillMaxWidth())
        }
        item {
            RecentRun(
                modifier = modifier.fillMaxWidth()
            )
        }

        item {
            Spacer(
                modifier = Modifier
                    .windowInsetsBottomHeight(WindowInsets.navigationBars)
                    .height(16.dp)
            )
        }
    }
}
