package com.example.presentation.model

import com.example.searchbook.domain.models.BookSearch

data class SearchUiState(
    val query: String = "",
    val books: List<BookSearch> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)