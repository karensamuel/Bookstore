package com.example.presentation.model

sealed interface BookIntent {
    data object LoadBooks : BookIntent
}