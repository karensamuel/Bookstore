package com.example.bookstore.navigation

import androidx.navigation3.runtime.NavKey
import com.example.history.presentation.model.UiBookHistoryModel
import com.example.presentation.model.UiBookModel
import kotlinx.serialization.Serializable

@Serializable
sealed interface BookstoreRoute : NavKey {
    @Serializable
    data object Home: BookstoreRoute
    @Serializable
    data class BookInfo (
        val bookId: String
    ): BookstoreRoute
    @Serializable
    data object History : BookstoreRoute

}