package com.example.searchbook.data.di


import com.example.core.data.network.service.createHttpClient
import com.example.searchbook.data.BookRemoteDataSource
import com.example.searchbook.data.BookSearchRepositoryImpl
import com.example.searchbook.domain.SearchRepo
import io.ktor.client.HttpClient
import org.koin.dsl.module


val bookSearchModule = module {

    single<HttpClient> {
        createHttpClient()
    }

    single<BookRemoteDataSource> {
        BookRemoteDataSource(get())
    }

    single<SearchRepo> {
        BookSearchRepositoryImpl(get())
    }
}