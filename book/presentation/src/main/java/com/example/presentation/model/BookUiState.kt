package com.example.book.presentation.model

import com.example.domain.repo.model.BookModel
import com.example.presentation.model.UiBookModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf


data class BookUiState(
    val books: ImmutableList<UiBookModel> = persistentListOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)