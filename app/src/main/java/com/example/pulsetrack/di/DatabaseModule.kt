package com.example.pulsetrack.di

import com.example.pulsetrack.data.local.database.AppDatabase
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

val databaseModule = module {
    single<AppDatabase>()
}