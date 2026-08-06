package com.example.pulsetrack.core.helpers

sealed interface AsyncResult<out T>
data class Success<T>(val data: T) : AsyncResult<T>
data class LocalError(val cause: Throwable) : AsyncResult<Nothing>