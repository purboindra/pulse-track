package com.example.pulsetrack.data.local.database

import androidx.room3.DaoReturnTypeConverter
import androidx.room3.OperationType
import com.example.pulsetrack.core.helpers.AsyncResult
import com.example.pulsetrack.core.helpers.LocalError
import com.example.pulsetrack.core.helpers.Success


class AsyncResultConverter {
    @DaoReturnTypeConverter([OperationType.READ, OperationType.WRITE])
    suspend fun <T> convert(
        executeAndConvert: suspend () -> T
    ): AsyncResult<T> = try {
        Success(executeAndConvert())
    } catch (e: Throwable) {
        LocalError(e)
    }
}
