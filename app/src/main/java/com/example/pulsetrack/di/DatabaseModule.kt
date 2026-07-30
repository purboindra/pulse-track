package com.example.pulsetrack.di

import com.example.pulsetrack.data.local.database.AppDatabase
import com.example.pulsetrack.data.local.database.createDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { createDatabase(get()) }
}