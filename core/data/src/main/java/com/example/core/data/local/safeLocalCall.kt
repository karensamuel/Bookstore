

package com.example.core.data.local

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import kotlin.coroutines.cancellation.CancellationException

suspend inline fun <T> safeLocalCall(
    crossinline block: suspend () -> T
): Result<T, DataError.Local> {
    return try {
        Result.Success(block())
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.Error(DataError.Local.UNKNOWN)
    }
}