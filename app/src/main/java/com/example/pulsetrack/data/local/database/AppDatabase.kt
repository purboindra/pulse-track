package com.example.pulsetrack.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pulsetrack.data.local.entity.RunEntity
import org.koin.core.annotation.Singleton

@Singleton
@Database(
    entities = [RunEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {}

fun createDatabase(context: Context): AppDatabase =
    Room.databaseBuilder(context, AppDatabase::class.java, "app-database").build()