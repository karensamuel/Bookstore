package com.example.searchbook.data.remote

import com.example.searchbook.data.BuildConfig
import com.example.searchbook.domain.models.BookSearch


fun BookSearchDto.toDomain(): BookSearch {
    return BookSearch(
        id = key ?: "",
        title = title ?: "",
        authors = authorName ?: emptyList(),
        coverUrl = coverI?.let {
            "${BuildConfig.COVER_BASE_URL}${it}-${BuildConfig.COVER_SIZE}.jpg"
        }
    )
}