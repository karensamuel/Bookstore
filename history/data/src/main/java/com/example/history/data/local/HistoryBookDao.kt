package com.example.history.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryBookDao {
    @Query("SELECT * FROM historybookentity")
    fun getAll(): List<HistoryBookEntity>

    @Insert
    fun insertBook(book: HistoryBookEntity)

}