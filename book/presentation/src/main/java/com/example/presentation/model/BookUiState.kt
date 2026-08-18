package com.example.book.presentation.model

import com.example.domain.repo.model.BookModel

data class BookUiState(
    val books: List<BookModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)