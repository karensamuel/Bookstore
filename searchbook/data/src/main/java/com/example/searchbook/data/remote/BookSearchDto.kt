package com.example.searchbook.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookSearchDto(
    @SerialName("key")
    val key: String? = " ",
    @SerialName("title")
    val title: String? = " ",
    @SerialName("author_name")
    val authorName: List<String>? = emptyList(),
    @SerialName("cover_i")
    val coverI: Int? = 0,
)