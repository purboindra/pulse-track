package com.example.pulsetrack.service

import android.content.Context
import android.content.Intent

class RunningServiceController(private val context: Context) {
    fun startTracking() {
        Intent(context, RunningTrackingService::class.java).also { intent ->
            intent.action = RunningTrackingService.ACTION_START
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }
    }

    fun stopTracking() {
        Intent(context, RunningTrackingService::class.java).also { intent ->
            intent.action = RunningTrackingService.ACTION_STOP
            context.startService(intent)
        }
    }
}