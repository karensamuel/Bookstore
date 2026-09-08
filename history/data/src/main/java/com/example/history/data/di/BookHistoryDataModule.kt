package com.example.history.data.di

import androidx.room.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import com.example.history.data.BookHistoryLocalDataSource
import com.example.history.data.BookHistoryRepositoryImpl
import com.example.history.data.local.HistoryAppDatabase
import com.example.history.data.local.HistoryBookDao
import com.example.history.domain.BookHistoryDataSource
import com.example.history.domain.BookHistoryRepo
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val bookHistoryDataModule = module{

    single<HistoryAppDatabase> {
        Room.databaseBuilder<HistoryAppDatabase>(
            androidContext(),
            "database-name"
        )
            .setDriver(AndroidSQLiteDriver())
            .build()
    }

    single<HistoryBookDao> {
        get<HistoryAppDatabase>().historyBookDao()
    }

    single<BookHistoryDataSource> {
        BookHistoryLocalDataSource(get())
    }

    single< BookHistoryRepo> {
        BookHistoryRepositoryImpl(get())
    }
}