package com.example.presentation.model

sealed interface SearchIntent {
    data class OnQueryChange(val query: String) : SearchIntent
}