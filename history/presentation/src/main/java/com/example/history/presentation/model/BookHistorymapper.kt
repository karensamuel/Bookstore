package com.example.history.presentation.model

import com.example.history.domain.model.BookHistoryModel
import kotlinx.collections.immutable.toImmutableList

fun toUiBookHistory(book: BookHistoryModel): UiBookHistoryModel {
    return UiBookHistoryModel(
        id = book.id,
        title = book.title,
        authors = book.authors.toImmutableList(),
        coverUrl = book.coverUrl,
        viewedAt = book.viewedAt
    )
}
