package com.example.pulsetrack.presentation.run

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.pulsetrack.core.helpers.DurationHelper
import com.example.pulsetrack.presentation.component.AppButton
import com.example.pulsetrack.presentation.component.OsmMapView
import com.example.pulsetrack.ui.theme.PulseTrackTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalGridApi::class)
@Composable

fun RunScreen(modifier: Modifier = Modifier, viewModel: RunViewModel = koinViewModel()) {

    val runState by viewModel.runState.collectAsStateWithLifecycle()
    val distance by viewModel.formattedDistanceInKm.collectAsStateWithLifecycle()
    val pace by viewModel.currentPace.collectAsStateWithLifecycle()
    val avgPace by viewModel.avgPace.collectAsStateWithLifecycle()
    val caloriesBurned by viewModel.caloriesBurnedGoal.collectAsStateWithLifecycle()
    val durationText by viewModel.formattedDuration.collectAsStateWithLifecycle()

    val context = LocalContext.current
    var hasLocationPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        hasLocationPermission = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
    }

    LaunchedEffect(Unit) {
        if (!hasLocationPermission) {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                )
            )
        }
    }

    Column(
        modifier = modifier.padding(
            PulseTrackTheme.spacing.md
        ),
    ) {
        OsmMapView(
            modifier = Modifier
                .height(240.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(PulseTrackTheme.spacing.base))
        )
        Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.base))
        LazyColumn(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "DURATION", style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                    Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.xs))
                    Text(
                        durationText, style = MaterialTheme.typography.headlineLarge.copy(
                            fontSize = 48.sp,
                        )
                    )
                }
                Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.lg))
                Grid(
                    config = {
                        repeat(2) {
                            column(171.dp)
                        }
                        repeat(2) {
                            row(96.dp)
                        }
                        gap(8.dp)
                    }
                ) {
                    StatusRunCard(
                        label = "DISTANCE",
                        value = distance,
                        unit = "km"
                    )
                    StatusRunCard(
                        label = "PACE",
                        value = pace,
                        unit = "/km"
                    )
                    StatusRunCard(
                        label = "AVG PACE",
                        value = avgPace,
                        unit = "/km"
                    )
                    StatusRunCard(
                        label = "CALORIES",
                        value = "$caloriesBurned",
                        unit = "kcal"
                    )
                }
                Spacer(modifier = Modifier.height(PulseTrackTheme.spacing.lg))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppButton(
                        onClick = if (runState.isTracking) viewModel::onStopRunClicked else viewModel::onStartRunClicked,
                        label = if (runState.isTracking) "STOP" else "START",
                        modifier = Modifier
                            .weight(1f)
                            .height(72.dp),
                        shape = RoundedCornerShape(PulseTrackTheme.spacing.base)
                    )
                    Spacer(modifier = Modifier.width(PulseTrackTheme.spacing.sm))
                    Box(
                        modifier = Modifier
                            .size((72.dp))
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                shape = RoundedCornerShape(PulseTrackTheme.spacing.base)
                            )
                            .clip(
                                RoundedCornerShape(PulseTrackTheme.spacing.base)
                            )
                            .background(
                                Color(0xffFFB3AD)
                            )
                            .clickable(
                                onClick = viewModel::onPauseRunClicked
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            if (runState.isPaused) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                }
            }
        }
    }
}