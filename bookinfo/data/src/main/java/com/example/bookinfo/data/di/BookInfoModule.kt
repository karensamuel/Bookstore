package com.example.bookinfo.data.di


import com.example.bookinfo.data.BookInfoRemoteDataSource
import com.example.bookinfo.data.BookInfoRepoImpl
import com.example.bookinfo.domain.repo.BookInfoRepo
import com.example.core.data.network.service.createHttpClient

import io.ktor.client.HttpClient
import org.koin.dsl.module


val bookInfoModule = module {

    single<HttpClient> {
        createHttpClient()
    }

    single<BookInfoRemoteDataSource> {
        BookInfoRemoteDataSource(get())
    }

    single<BookInfoRepo> {
        BookInfoRepoImpl(get())
    }
}