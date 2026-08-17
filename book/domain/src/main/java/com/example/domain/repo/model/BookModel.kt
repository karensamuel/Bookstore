package com.example.domain.repo.model

data class BookModel(
    val id: String,
    val title: String,
    val authors: List<String>,
    val coverUrl: String?,
)
