package com.example.bookinfo.data.remote


import com.example.bookinfo.data.BuildConfig
import com.example.info.domain.model.BookInfoModel

fun BookInfoDto.toDomain(authorNames: List<String>): BookInfoModel {


    val firstPublishYear = firstPublishDate
        ?.takeLast(4)
        ?.toIntOrNull()

    val coverUrl = covers.firstOrNull()?.let { coverId ->
        "${BuildConfig.COVER_BASE_URL}${coverId}-${BuildConfig.COVER_SIZE}.jpg"
    }

    return BookInfoModel(
        id = key?.removePrefix("/works/") ?: "",
        title = title,
        authors = authorNames,
        coverUrl = coverUrl,
        firstPublishYear = firstPublishYear,
        editionCount = 0
    )
}