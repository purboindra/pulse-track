package com.example.pulsetrack

import android.app.Application
import com.example.pulsetrack.di.databaseModule
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                databaseModule,
            )
        }
    }
}