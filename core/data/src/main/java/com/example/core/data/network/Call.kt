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

        println("========== SAFE CALL START karen ==========")

        val response = block()

        println("HTTP STATUS karen : ${response.status}")
        println("HTTP URL karen : ${response.call.request.url}")

        if (response.status.isSuccess()) {

            println("========== HTTP SUCCESS karen ==========")

            Result.Success(response.body())

        } else {

            println("========== HTTP ERROR karen  ==========")

            mapHttpErrorToResult(response)
        }

    } catch (e: UnknownHostException) {

        println("UNKNOWN HOST karen : ${e.message}")
        Result.Error(DataError.Network.NO_INTERNET)

    } catch (e: IOException) {

        println("IO EXCEPTION karen : ${e.message}")
        e.printStackTrace()

        Result.Error(DataError.Network.REQUEST_TIMEOUT)

    } catch (e: SerializationException) {

        println("SERIALIZATION ERROR karen : ${e.message}")
        Log.d("TAG", "safeCall: ${e.message}")
        e.printStackTrace()

        Result.Error(DataError.Network.SERIALIZATION)

    } catch (e: CancellationException) {

        throw e

    } catch (e: Exception) {

        Log.e(
            "SAFE_CALL karen ",
            "Request failed: ${e::class.qualifiedName}: ${e.message}",
            e
        )

        coroutineContext.ensureActive()

        Result.Error(DataError.Network.UNKNOWN)
    }
}