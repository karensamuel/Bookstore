package com.example.book.presentation.model

sealed interface BookIntent {
    data object LoadBooks : BookIntent
}