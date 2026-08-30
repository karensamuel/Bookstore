package com.example.searchbook.domain.models

data class BookSearch(
    val id: String,
    val title: String,
    val authors: List<AuthorId>,
    val coverUrl: String?,
)

@JvmInline
value class AuthorId(
    val id: String,
)
