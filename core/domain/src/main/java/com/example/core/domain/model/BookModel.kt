package com.example.core.domain.model

data class Book(
    val id: String,
    val title: String,
    val authors: List<String>,
    val coverUrl: String?,
    val firstPublishYear: Int?,
    val editionCount: Int
)