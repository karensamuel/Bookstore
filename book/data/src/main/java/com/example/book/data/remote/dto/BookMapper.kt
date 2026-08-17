package com.example.book.data.remote.dto


import com.example.book.data.BuildConfig
import com.example.domain.repo.model.BookModel

fun BookDto.toDomain(): BookModel {
    return BookModel(
        id = key,
        title = title,
        authors = authorName ?: emptyList(), coverUrl = coverI?.let {
            "${BuildConfig.COVER_BASE_URL}${it}-${BuildConfig.COVER_SIZE}.jpg"
        }

    )
}

