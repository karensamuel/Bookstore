package com.example.searchbook.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class BooksSearchResponseDto(
    val docs: List<BookSearchDto>,

    )