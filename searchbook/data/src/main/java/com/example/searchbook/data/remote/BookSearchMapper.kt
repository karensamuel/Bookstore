package com.example.searchbook.data.remote

import com.example.searchbook.domain.models.BookSearch


fun BookSearchDto.toDomain(): BookSearch {
    return BookSearch(
        id = key ?: "",
        title = title ?: "",
        authors = author_name ?: emptyList(),
        coverUrl = cover_i?.let {
            "https://covers.openlibrary.org/b/id/${it}-M.jpg"
        }
    )
}