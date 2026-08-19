package com.example.presentation.model

import com.example.searchbook.domain.models.BookSearch
import kotlinx.collections.immutable.toImmutableList


fun toUiBook(book: BookSearch): UiBookSearch {
    return UiBookSearch(
        id = book.id,
        title = book.title,
        authors = book.authors.toImmutableList(),
        coverUrl = book.coverUrl,
    )

}