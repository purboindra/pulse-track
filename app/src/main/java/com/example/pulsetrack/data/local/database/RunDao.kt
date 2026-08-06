package com.example.pulsetrack.data.local.database

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import com.example.pulsetrack.core.helpers.AsyncResult
import com.example.pulsetrack.data.local.entity.RunEntity
import com.example.pulsetrack.data.params.InsertRunParams


@Dao
interface RunDao {
    @Query("SELECT * FROM run")
    suspend fun getAll(): AsyncResult<List<RunEntity>>

    @Query("SELECT * FROM run WHERE id = :id")
    suspend fun getRunById(id: Int): AsyncResult<RunEntity>

    @Insert(entity = RunEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(vararg runs: InsertRunParams): AsyncResult<Unit>
}
