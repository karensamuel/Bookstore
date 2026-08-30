package com.example.core.data.network

import android.util.Log
import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException
import okhttp3.Dispatcher
import java.io.IOException
import java.net.UnknownHostException
import kotlin.coroutines.cancellation.CancellationException

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
    } catch (_: UnknownHostException) {
        Result.Error(DataError.Network.NO_INTERNET)
    } catch (e: IOException) {
        e.printStackTrace()
        Result.Error(DataError.Network.REQUEST_TIMEOUT)
    } catch (_: SerializationException) {
        Result.Error(DataError.Network.SERIALIZATION)
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Log.d("safeCallkaren", "Request failed", e)
        currentCoroutineContext().ensureActive()
        Result.Error(DataError.Network.UNKNOWN)
    }
}

