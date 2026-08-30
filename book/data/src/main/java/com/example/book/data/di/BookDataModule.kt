package com.example.book.data.di

import com.example.book.data.BookRemoteDataSource
import com.example.book.data.BookRepositoryImpl
import com.example.domain.repo.BookDataSource
import com.example.domain.repo.BookRepository
import com.example.domain.repo.usecases.BookUseCase
import org.koin.dsl.module


val bookDataModule = module {
    factory {
        BookUseCase(get())
    }

    single<BookDataSource> {
        BookRemoteDataSource(get())
    }

    single<BookRepository> {
        BookRepositoryImpl(get())
    }
}