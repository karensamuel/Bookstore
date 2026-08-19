package com.example.searchbook.data.di


import com.example.searchbook.data.BookSearchRemoteDataSource
import com.example.searchbook.data.BookSearchRepositoryImpl
import com.example.searchbook.domain.BookSearchDataSource
import com.example.searchbook.domain.SearchRepo
import com.example.searchbook.domain.usecases.SearchBookUseCase
import org.koin.core.scope.get
import org.koin.dsl.module


val bookSearchModule= module {
    factory {
        SearchBookUseCase(get())
    }

    single<BookSearchDataSource> {
        BookSearchRemoteDataSource(get())
    }

    single<SearchRepo> {
        BookSearchRepositoryImpl(get())
    }
}