package com.example.pulsetrack

import android.app.Application
import android.preference.PreferenceManager
import com.example.pulsetrack.di.databaseModule
import com.example.pulsetrack.di.serviceModule
import com.example.pulsetrack.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.osmdroid.config.Configuration

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        Configuration.getInstance().userAgentValue = packageName

        startKoin {
            androidContext(this@MainApplication)
            androidLogger(Level.DEBUG)
            modules(
                databaseModule,
                serviceModule,
                viewModelModule
            )
        }
    }
}