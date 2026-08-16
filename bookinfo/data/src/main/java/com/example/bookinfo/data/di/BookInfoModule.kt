package com.example.bookinfo.data.di


import com.example.bookinfo.data.BookInfoRemoteDataSource
import com.example.bookinfo.data.BookInfoRepoImpl
import com.example.bookinfo.domain.repo.BookInfoRepo
import com.example.core.data.network.service.createHttpClient

import io.ktor.client.HttpClient
import org.koin.dsl.module


fun bookInfoModule(
    bookInfoEndpoint: String
) = module {

    single<BookInfoRemoteDataSource> {
        BookInfoRemoteDataSource(
            client = get(),
            bookInfoEndpoint = bookInfoEndpoint
        )
    }

    single<BookInfoRepo> {
        BookInfoRepoImpl(get())
    }
}