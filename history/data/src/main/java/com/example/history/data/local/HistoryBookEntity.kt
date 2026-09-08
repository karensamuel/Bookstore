package com.example.history.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryBookEntity (
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "authors") val authors: String?,
    @ColumnInfo(name = "cover_url") val coverUrl: String?,
    @ColumnInfo(name = "viewed_at") val viewedAt: Long
)