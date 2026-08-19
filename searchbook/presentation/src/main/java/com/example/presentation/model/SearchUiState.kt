package com.example.presentation.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class SearchUiState(
    val query: String = "",
    val books: ImmutableList<UiBookSearch> = persistentListOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)