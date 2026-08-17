package com.example.book.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookDto(
    @SerialName("key")
    val key: String,
    @SerialName("title")
    val title: String,
    @SerialName("author_name")
    val authorName: List<String>? = null,
    @SerialName("cover_i")
    val coverI: Int? = null,
)