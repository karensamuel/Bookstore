package com.example.searchbook.data.remote

import com.example.searchbook.data.BuildConfig
import com.example.searchbook.domain.models.AuthorId
import com.example.searchbook.domain.models.BookSearch


fun BookSearchDto.toDomain(): BookSearch {
    return BookSearch(
        id = key ?: "",
        title = title ?: "",
        authors =todataSearchauthors(authorName),
        coverUrl = coverI?.let {
            "${BuildConfig.COVER_BASE_URL}${it}-${BuildConfig.COVER_SIZE}.jpg"
        }
    )
}
fun todataSearchauthors(authors: List<String>?): List<AuthorId>{
    return authors?.map { AuthorId(it) } ?: emptyList()

}