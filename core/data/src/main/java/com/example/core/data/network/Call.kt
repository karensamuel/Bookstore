package com.example.core.data.network

import android.util.Log
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

        println("========== SAFE CALL START ==========")

        val response = block()

        println("HTTP STATUS: ${response.status}")
        println("HTTP URL: ${response.call.request.url}")

        if (response.status.isSuccess()) {

            println("========== HTTP SUCCESS ==========")

            Result.Success(response.body())

        } else {

            println("========== HTTP ERROR ==========")

            mapHttpErrorToResult(response)
        }

    } catch (e: UnknownHostException) {

        println("UNKNOWN HOST: ${e.message}")
        Result.Error(DataError.Network.NO_INTERNET)

    } catch (e: IOException) {

        println("IO EXCEPTION: ${e.message}")
        e.printStackTrace()

        Result.Error(DataError.Network.REQUEST_TIMEOUT)

    } catch (e: SerializationException) {

        println("SERIALIZATION ERROR: ${e.message}")
        Log.d("TAG", "safeCall: ${e.message}")
        e.printStackTrace()

        Result.Error(DataError.Network.SERIALIZATION)

    } catch (e: CancellationException) {

        throw e

    } catch (e: Exception) {

        println("========== UNKNOWN EXCEPTION ==========")
        println("TYPE: ${e::class.qualifiedName}")
        println("MESSAGE: ${e.message}")

        e.printStackTrace()

        println("======================================")

        coroutineContext.ensureActive()

        Result.Error(DataError.Network.UNKNOWN)
    }
}