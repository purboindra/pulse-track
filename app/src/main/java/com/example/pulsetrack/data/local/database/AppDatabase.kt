package com.example.pulsetrack.data.local.database

import android.content.Context
import androidx.room3.DaoReturnTypeConverters
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.example.pulsetrack.data.local.entity.RunEntity

@Database(
    entities = [RunEntity::class],
    version = 1,
//    exportSchema = false
)
@DaoReturnTypeConverters(AsyncResultConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun runDao(): RunDao
}

fun createDatabase(context: Context): AppDatabase =
    Room.databaseBuilder(context, AppDatabase::class.java, "app-database").build()