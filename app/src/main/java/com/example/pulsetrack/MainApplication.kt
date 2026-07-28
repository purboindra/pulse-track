package com.example.pulsetrack

import android.app.Application
import android.preference.PreferenceManager
import com.example.pulsetrack.di.databaseModule
import org.koin.core.context.startKoin
import org.osmdroid.config.Configuration

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        Configuration.getInstance().userAgentValue = "PulseTrackApp/1.0 (com.example.pulsetrack)"

        startKoin {
            modules(
                databaseModule,
            )
        }
    }
}