package com.example.info.domain.model

data class BookModel (
    val id: String,
    val title: String,
    val authors: List<String>,
    val coverUrl: String?,
    val firstPublishYear: Int?,
    val editionCount: Int

)

