package com.example.core.data.network.service

import android.util.Log
import com.example.core.data.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createHttpClient(): HttpClient {
    return HttpClient(Android) {

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    coerceInputValues = true
                }
            )
        }

        defaultRequest {
            Log.d("Base URL karen", "createHttpClient: ${BuildConfig.BASE_URL}")
            url(BuildConfig.BASE_URL)
            contentType(ContentType.Application.Json)
        }
    }
}