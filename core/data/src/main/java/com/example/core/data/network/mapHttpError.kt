package com.example.core.data.network

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result

import io.ktor.client.statement.HttpResponse
inline fun <reified T> mapHttpErrorToResult(
    response: HttpResponse
): Result<T, DataError.Network> {

    return when (response.status.value) {

        408         -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
        429         -> Result.Error(DataError.Network.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(DataError.Network.SERVER_ERROR)
        else        -> Result.Error(DataError.Network.UNKNOWN)
    }
}