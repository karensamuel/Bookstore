package com.example.searchbook.domain.models

data class Book(
    val id: String,
    val title: String,
    val authors: List<String>,
    val coverUrl: String?,

)
