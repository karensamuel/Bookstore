package com.example.book.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class BookDto(
    val key: String,
    val title: String,
    val author_name: List<String>? = null,
    val cover_i: Int? = null,
)