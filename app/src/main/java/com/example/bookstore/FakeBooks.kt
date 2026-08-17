package com.example.bookstore

import com.example.domain.repo.model.BookModel

val bookModels = listOf(
    BookModel(
        id = "1",
        title = "The Great Gatsby",
        authors = listOf("F. Scott Fitzgerald"),
        coverUrl = null,

        ),
    BookModel(
        id = "2",
        title = "1984",
        authors = listOf("George Orwell"),
        coverUrl = null,
    ),
    BookModel(
        id = "3",
        title = "To Kill a Mockingbird",
        authors = listOf("Harper Lee"),
        coverUrl = null,

        ),
    BookModel(
        id = "4",
        title = "The Hobbit",
        authors = listOf("J.R.R. Tolkien"),
        coverUrl = null,

        )
)