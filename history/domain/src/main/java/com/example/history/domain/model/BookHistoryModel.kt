package com.example.history.domain.model

 data class BookHistoryModel(
    val id: String,
    val title: String,
    val authors: List<String>,
    val coverUrl: String?,
    val viewedAt: Long
)
