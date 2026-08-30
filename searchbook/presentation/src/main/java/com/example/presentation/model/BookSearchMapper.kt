package com.example.presentation.model

import com.example.searchbook.domain.models.AuthorId
import com.example.searchbook.domain.models.BookSearch
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList


fun toUiBook(book: BookSearch): UiBookSearch {
    return UiBookSearch(
        id = book.id,
        title = book.title,
        authors = toUiSearchAuther(book.authors),
        coverUrl = book.coverUrl,
    )

}

fun toUiSearchAuther(authors: List<AuthorId>): ImmutableList<String> {
    return authors.map { it.id }.toImmutableList()
}
