package com.example.searchbook.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class BookSearchDto(
    val key: String? = null,
    val title: String? = null,
    val author_name: List<String>? = null,
    val cover_i: Int? = null,
)