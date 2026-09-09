package com.example.info.presentation.model

sealed interface InfoUiState {
    object Loading : InfoUiState
    data class Success(val book: UiBookInfoModel) : InfoUiState
    data class Error(val message: String) : InfoUiState
}

