package com.example.book.data.remote.dto


import com.example.domain.repo.model.Book

fun BookDto.toDomain(): Book {
    return Book(
        id = key,
        title = title,
        authors = authorName ?: emptyList(),
        coverUrl = cover_i?.let {
            "https://covers.openlibrary.org/b/id/${it}-M.jpg"
        }
    )
}

