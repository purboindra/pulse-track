package com.example.pulsetrack.data.local.database

import androidx.room3.Dao
import androidx.room3.Query

@Dao
interface RunDao {
    @Query("SELECT * FROM run")
    suspend fun getAll(): List<Any>
}