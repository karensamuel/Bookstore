package com.example.bookstore


import android.app.Application
import com.example.book.data.di.bookDataModule
import com.example.book.presentation.di.bookSearchPresentationModule
import com.example.bookinfo.data.di.bookInfoModule
import com.example.core.data.network.di.coreRemoteDataModule
import com.example.history.data.di.bookHistoryDataModule
import com.example.info.presentation.di.bookInfoPresentationModule
import com.example.presentation.di.bookPresentationModule
import com.example.searchbook.data.di.bookSearchModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BookApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BookApplication)

            modules(
                coreRemoteDataModule,
                bookDataModule,
                bookSearchModule,
                bookInfoModule,
                bookPresentationModule,
                bookSearchPresentationModule,
                bookInfoPresentationModule,
                bookHistoryDataModule
            )
        }
    }
}