package com.example.presentation.model

import com.example.domain.repo.model.BookModel
import kotlinx.collections.immutable.toImmutableList


fun toUiBook(book: BookModel): UiBookModel {
    return UiBookModel(
        id = book.id,
        title = book.title,
        authors = book.authors.toImmutableList(),
        coverUrl = book.coverUrl,
    )

}