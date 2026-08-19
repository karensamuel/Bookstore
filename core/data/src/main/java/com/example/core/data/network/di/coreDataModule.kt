package com.example.core.data.network.di

import com.example.core.data.network.service.createHttpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

val coreDataModule = module {

    single<HttpClient> {
        createHttpClient()
    }
}