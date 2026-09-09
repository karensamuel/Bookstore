package com.example.history.presentation.model

import kotlinx.collections.immutable.ImmutableList

sealed interface  BookHistoryUiState {
    object Loading : BookHistoryUiState
    data class Success(val books: ImmutableList<UiBookHistoryModel>) : BookHistoryUiState
    data class Error(val message: String) : BookHistoryUiState
}