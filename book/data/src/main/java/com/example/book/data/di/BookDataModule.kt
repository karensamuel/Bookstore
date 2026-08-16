package com.example.book.data.di

import com.example.book.data.BookRemoteDataSource
import com.example.book.data.BookRepositoryImpl
import com.example.core.data.network.service.createHttpClient
import com.example.domain.repo.BookRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module


val bookDataModule = module {

    single<HttpClient> {
        createHttpClient()
    }

    single<BookRemoteDataSource> {
        BookRemoteDataSource(get())
    }

    single<BookRepository> {
        BookRepositoryImpl(get())
    }
}