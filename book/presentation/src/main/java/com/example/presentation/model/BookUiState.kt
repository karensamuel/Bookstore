package com.example.presentation.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf



sealed interface BookUiState{
    object Loading : BookUiState
    data class Success(val books: ImmutableList<UiBookModel>) : BookUiState
    data class Error(val message: String) : BookUiState
}