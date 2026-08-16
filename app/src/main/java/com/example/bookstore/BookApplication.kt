package com.example.bookstore


import android.app.Application
import com.example.book.data.di.bookDataModule
import com.example.bookinfo.data.di.bookInfoModule
import com.example.core.data.network.di.coreDataModule
import com.example.searchbook.data.di.bookSearchModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BookApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BookApplication)

            modules(
                coreDataModule(
                    baseUrl = BuildConfig.BASE_URL
                ),
                bookDataModule(
                    bookEndpoint = BuildConfig.GET_BOOKS_ENDPOINT
                ),
                bookSearchModule(searchEndoint = BuildConfig.SEARCH_ENDPOINT),
                bookInfoModule(
                    bookInfoEndpoint = BuildConfig.BOOK_INFO_ENDPOINT
                )
            )
        }
    }
}