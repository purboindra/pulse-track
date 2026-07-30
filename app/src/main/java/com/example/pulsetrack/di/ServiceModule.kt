package com.example.pulsetrack.di

import com.example.pulsetrack.service.RunningServiceController
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val serviceModule = module {
    single {
        RunningServiceController(androidContext())
    }
}