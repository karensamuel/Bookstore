package com.example.domain.repo.model

data class Book(
    val id: String,
    val title: String,
    val authors: List<String>,
    val coverUrl: String?,

)