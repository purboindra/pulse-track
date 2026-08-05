package com.example.pulsetrack.data.local.entity

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "runs")
data class RunEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val startTimeMillis: Long,
    val endTimeMillis: Long,
    val timestamp: Long = 0L,
    val avgPace: Float = 0f,
    val distanceInMeters: Int = 0,
    val pace: Long = 0L,
    val caloriesBurned: Int = 0
)
