package com.example.pulsetrack.presentation.run

import androidx.lifecycle.ViewModel
import com.example.pulsetrack.service.RunningServiceController
import com.example.pulsetrack.service.RunningTrackingService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.osmdroid.util.GeoPoint

class RunViewModel(
    private val runningServiceController: RunningServiceController
) : ViewModel() {
    val pathPoints: StateFlow<List<GeoPoint>> = RunningTrackingService.pathPoints

    fun onStartRunClicked() {
        runningServiceController.startTracking()
    }

    fun onStopRunClicked() {
        runningServiceController.stopTracking()
    }
}