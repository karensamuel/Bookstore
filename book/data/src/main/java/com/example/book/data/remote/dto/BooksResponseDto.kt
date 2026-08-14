package com.example.book.data.remote.dto
import kotlinx.serialization.Serializable
@Serializable
data class BooksResponseDto(
    val docs: List<BookDto>
)