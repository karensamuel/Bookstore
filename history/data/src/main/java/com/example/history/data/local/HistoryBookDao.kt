package com.example.history.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryBookDao {
    @Query("SELECT * FROM historybookentity")
    suspend fun getAll(): List<HistoryBookEntity>

    @Insert
   suspend fun insertBook(book: HistoryBookEntity)

}