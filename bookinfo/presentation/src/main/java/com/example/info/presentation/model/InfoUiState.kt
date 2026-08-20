package com.example.info.presentation.model

data class InfoUiState(
    val book: UiBookInfoModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null

)