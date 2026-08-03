package com.example.pulsetrack.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.os.Looper
import androidx.core.app.NotificationCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.scope.serviceScope
import org.osmdroid.util.GeoPoint
import kotlin.time.Duration.Companion.milliseconds

class RunningTrackingService : Service() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_PAUSE = "ACTION_PAUSE"
        const val ACTION_STOP = "ACTION_STOP"

        const val NOTIFICATION_CHANNEL_ID = "running_track_channel"
        const val NOTIFICATION_ID = 1

        private val _pathPoints = MutableStateFlow<List<GeoPoint>>(emptyList())
        val pathPoints: StateFlow<List<GeoPoint>> = _pathPoints

        private val _durationSeconds = MutableStateFlow(0L)
        val durationSeconds = _durationSeconds.asStateFlow()
    }

    private val serviceJob = SupervisorJob()
    private val serviceScope = CoroutineScope(Dispatchers.IO + serviceJob)


    private var isTimerRunning = false
    private var startTimeMillis = 0L
    private var timeAccruedBeforePauseMillis = 0L

    private fun startTimer() {
        // Reset duration
        _durationSeconds.update {
            0
        }
        isTimerRunning = true
        startTimeMillis = System.currentTimeMillis()
        serviceScope.launch {
            while (isTimerRunning) {
                val now = System.currentTimeMillis()
                val timeDifference = now - startTimeMillis
                val totalElapsedMillis = timeAccruedBeforePauseMillis + timeDifference
                _durationSeconds.update {
                    totalElapsedMillis / 1000L
                }
                delay(1000L.milliseconds)
            }
        }
    }


    private fun pauseTimer() {
        isTimerRunning = false
        timeAccruedBeforePauseMillis += System.currentTimeMillis() - startTimeMillis
    }

    override fun onCreate() {
        super.onCreate()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> {
                startTracking()
                startTimer()
            }

            ACTION_PAUSE -> {
                pauseTracking()
            }

            ACTION_STOP -> {
                stopTracking()
            }
        }
        return START_STICKY
    }

    private fun pauseTracking() {
        pauseTimer()
        fusedLocationClient.removeLocationUpdates(locationCallBack)
    }

    private fun startTracking() {
        createNotificationChannel()
        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setContentTitle("PulseTrack Running")
            .setContentText("Tracking your run...")
            .setSmallIcon(android.R.drawable.ic_menu_compass)
            .setOngoing(true)
            .build()
        startForeground(NOTIFICATION_ID, notification)
        requestLocationUpdates()
    }

    private fun requestLocationUpdates() {
        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 2000L)
            .setMinUpdateIntervalMillis(1000L).build()

        try {
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallBack,
                Looper.getMainLooper()
            )
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    private val locationCallBack = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            result.locations.forEach { location ->
                val newPoint = GeoPoint(location.latitude, location.longitude)
                _pathPoints.update {
                    _pathPoints.value + newPoint
                }
            }
        }
    }

    private fun stopTracking() {
        pauseTimer()
        fusedLocationClient.removeLocationUpdates(locationCallBack)
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "Running Service",
                NotificationManager.IMPORTANCE_HIGH
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

}