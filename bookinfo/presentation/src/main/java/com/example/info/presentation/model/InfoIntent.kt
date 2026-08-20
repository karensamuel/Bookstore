package com.example.info.presentation.model

sealed interface InfoIntent {
    data class onLoadPage(val bookId: String) : InfoIntent
}
