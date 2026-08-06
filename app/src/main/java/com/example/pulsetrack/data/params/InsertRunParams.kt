package com.example.pulsetrack.data.params

data class InsertRunParams(
    val startTimeMillis: Long,
    val endTimeMillis: Long,
    val timestamp: Long = 0L,
    val avgPace: Float = 0f,
    val distanceInMeters: Int = 0,
    val pace: Long = 0L,
    val caloriesBurned: Int = 0
)