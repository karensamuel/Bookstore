package com.example.history.presentation.model

import com.example.history.domain.model.BookHistoryModel

interface BookHistoryIntent {
        data object LoadBooks : BookHistoryIntent
        data class AddBook(
                val book: BookHistoryModel
        ) : BookHistoryIntent
}