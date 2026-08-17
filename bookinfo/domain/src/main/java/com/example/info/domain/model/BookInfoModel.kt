package com.example.info.domain.model

data class BookInfoModel(
    val id: String,
    val title: String?,
    val authors: List<String>,
    val coverUrl: String?,
    val firstPublishYear: Int?,
    val editionCount: Int,
)
