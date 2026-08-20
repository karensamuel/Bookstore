package com.example.bookinfo.data.di


import com.example.bookinfo.data.BookInfoRemoteDataSource
import com.example.bookinfo.data.BookInfoRepoImpl
import com.example.info.domain.BookInfoDataSource
import com.example.info.domain.BookInfoRepo
import com.example.info.domain.usecases.InfoBookUseCase
import org.koin.dsl.module


val bookInfoModule= module {
    factory {
        InfoBookUseCase(get())
    }

    single<BookInfoDataSource> {
        BookInfoRemoteDataSource(
            client = get(),

            )
    }

    single<BookInfoRepo> {
        BookInfoRepoImpl(get())
    }
}