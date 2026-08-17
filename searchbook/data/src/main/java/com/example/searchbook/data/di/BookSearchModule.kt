package com.example.searchbook.data.di



import com.example.searchbook.data.BookSearchRemoteDataSource
import com.example.searchbook.data.BookSearchRepositoryImpl
import com.example.searchbook.domain.BookSearchDataSource
import com.example.searchbook.domain.SearchRepo
import org.koin.dsl.module


fun bookSearchModule() = module {



    single<BookSearchDataSource> {
        BookSearchRemoteDataSource(get())
    }

    single<SearchRepo> {
        BookSearchRepositoryImpl(get())
    }
}