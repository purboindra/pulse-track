package com.example.pulsetrack.presentation.run

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pulsetrack.presentation.state.RunState
import com.example.pulsetrack.service.RunningServiceController
import com.example.pulsetrack.service.RunningTrackingService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import org.osmdroid.util.GeoPoint

class RunViewModel(
    private val runningServiceController: RunningServiceController
) : ViewModel() {
    val pathPoints: StateFlow<List<GeoPoint>> = RunningTrackingService.pathPoints

    // TODO: THIS SHOULD BE DYNAMIC
    private val userWeight: Double = 70.0

    private val _runState = MutableStateFlow(RunState())
    val runState = _runState.asStateFlow()


    val distanceInMeters: StateFlow<Double> = pathPoints.map { points ->
        calculateDistanceInMeters(points)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(
            5000
        ),
        0.0
    )

    val caloriesBurnedGoal: StateFlow<Int> = distanceInMeters.map { meters ->
        val distanceInKm = meters / 1000.0
        val calories = userWeight * distanceInKm * 1036
        calories.toInt()
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        0
    )

    @SuppressLint("DefaultLocale")
    val formattedDistanceInKm: StateFlow<String> = distanceInMeters.map { meters ->
        String.format("%.2f", meters / 1000.0)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        "0.00"
    )

    private fun calculateDistanceInMeters(points: List<GeoPoint>): Double {
        var totalMeters = 0.0
        for (i in 0 until points.size - 1) {
            val p1 = points[i]
            val p2 = points[i + 1]
            totalMeters += p1.distanceToAsDouble(p2)
        }
        return totalMeters
    }

    val formattedPace: StateFlow<String> = combine(
        distanceInMeters,
        runState
    ) { meters, state ->
        calculatePace(meters, state.durationSeconds)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        "",
    )

    val currentPace: StateFlow<String> = pathPoints.map { points ->
        if (points.size < 2) return@map "0:00"
        val recentPoints = points.takeLast(6)
        val recentDistanceMeters = calculateDistanceInMeters(recentPoints)
        val estimateRecentSeconds = (recentPoints.size - 1) * 2L
        calculatePace(
            recentDistanceMeters,
            estimateRecentSeconds
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        "0:00"
    )

    val avgPace: StateFlow<String> = combine(
        distanceInMeters,
        runState
    ) { meters, state ->
        calculatePace(meters, state.durationSeconds)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "0:00")

    @SuppressLint("DefaultLocale")
    private fun calculatePace(distanceInMeters: Double, durationSeconds: Long): String {
        val distanceInKm = distanceInMeters / 1000.0

        if (distanceInKm <= 0.0 || durationSeconds <= 0) {
            return "0:00"
        }
        val paceInSecondsPerKm = (durationSeconds / distanceInKm).toLong()
        val minutes = paceInSecondsPerKm / 60
        val seconds = paceInSecondsPerKm % 60
        if (minutes > 99) return "--:--"
        return String.format("%d:%02d", minutes, seconds)
    }

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