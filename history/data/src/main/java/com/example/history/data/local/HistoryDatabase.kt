package com.example.history.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HistoryBookEntity::class], version = 1)
abstract class HistoryAppDatabase: RoomDatabase()  {
    abstract fun historyBookDao(): HistoryBookDao

}