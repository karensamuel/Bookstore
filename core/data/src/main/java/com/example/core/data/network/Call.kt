package com.example.core.data.network

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import io.ktor.client.call.body

import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import java.io.IOException
import java.net.UnknownHostException
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.coroutineContext
suspend inline fun <reified T> safeCall(
    crossinline block: suspend () -> HttpResponse
): Result<T, DataError.Network> {

    return try {
        val response = block()

        if (response.status.isSuccess()) {
            Result.Success(response.body())
        } else {
            mapHttpErrorToResult(response)
        }
    } catch (e: UnknownHostException) {
       Result.Error(DataError.Network.NO_INTERNET)
    } catch (e: IOException) {
      Result.Error(DataError.Network.REQUEST_TIMEOUT)
    } catch (e: SerializationException) {
        e.printStackTrace()
       Result.Error(DataError.Network.SERIALIZATION)
    }catch (e: CancellationException) {
        throw e
    }
    catch (e: Exception) {
        coroutineContext.ensureActive()
        Result.Error(DataError.Network.UNKNOWN)
    }
}