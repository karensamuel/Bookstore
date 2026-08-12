package com.example.domain.repo.modles

data class Book(
    val id: String,
    val title: String,
    val authors: List<String>,
    val coverUrl: String?,

)