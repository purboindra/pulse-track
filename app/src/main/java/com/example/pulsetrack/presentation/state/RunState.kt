package com.example.pulsetrack.presentation.state

data class RunState(
    val isTracking: Boolean = false,
    val isPaused: Boolean = false,
    val durationSeconds: Long = 0L,
    val distanceMeters: Float = 0f,
    val currentPaceSecPerKm: Long = 0L,
    val currentCalories: Int = 0,
    val pathPoints: List<Any> = emptyList(),
    val currentPosition: Any? = null
)