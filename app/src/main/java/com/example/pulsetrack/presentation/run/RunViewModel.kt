package com.example.pulsetrack.presentation.run

import androidx.lifecycle.ViewModel
import com.example.pulsetrack.presentation.state.RunState
import com.example.pulsetrack.service.RunningServiceController
import com.example.pulsetrack.service.RunningTrackingService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.osmdroid.util.GeoPoint

class RunViewModel(
    private val runningServiceController: RunningServiceController
) : ViewModel() {
    val pathPoints: StateFlow<List<GeoPoint>> = RunningTrackingService.pathPoints

    private val _runState = MutableStateFlow(RunState())
    val runState = _runState.asStateFlow()

    fun onStartRunClicked() {
        runningServiceController.startTracking()
        _runState.update {
            it.copy(
                isTracking = true
            )
        }
    }

    fun onStopRunClicked() {
        runningServiceController.stopTracking()
        _runState.update {
            it.copy(
                isPaused = true,
                isTracking = false
            )
        }
    }
}