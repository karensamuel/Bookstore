package com.example.presentation.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

sealed interface SearchUiState{
    val query: String

 data class  Loading(override val query: String) : SearchUiState
    data class Success(val books: ImmutableList<UiBookSearch>, override val query: String) : SearchUiState
    data class Error(val message: String, override val query: String) : SearchUiState
}
