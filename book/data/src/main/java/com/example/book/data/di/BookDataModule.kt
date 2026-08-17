package com.example.book.data.di

import com.example.book.data.BookRemoteDataSource
import com.example.book.data.BookRepositoryImpl
import com.example.domain.repo.BookDataSource
import com.example.domain.repo.BookRepository
import org.koin.dsl.module


fun bookDataModule() = module {


    single<BookDataSource> {
        BookRemoteDataSource(get())
    }

    single<BookRepository> {
        BookRepositoryImpl(get())
    }
}