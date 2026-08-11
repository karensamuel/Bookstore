package com.example.bookstore

import com.example.core.domain.model.Book

val books = listOf(
    Book(
        id = "1",
        title = "The Great Gatsby",
        authors = listOf("F. Scott Fitzgerald"),
        coverUrl = null,
        firstPublishYear = 1925,
        editionCount = 10
    ),
    Book(
        id = "2",
        title = "1984",
        authors = listOf("George Orwell"),
        coverUrl = null,
        firstPublishYear = 1949,
        editionCount = 20
    ),
    Book(
        id = "3",
        title = "To Kill a Mockingbird",
        authors = listOf("Harper Lee"),
        coverUrl = null,
        firstPublishYear = 1960,
        editionCount = 15
    ),
    Book(
        id = "4",
        title = "The Hobbit",
        authors = listOf("J.R.R. Tolkien"),
        coverUrl = null,
        firstPublishYear = 1937,
        editionCount = 30
    )
)