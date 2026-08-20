package com.example.bookinfo.data.remote


import com.example.bookinfo.data.BuildConfig
import com.example.info.domain.model.BookInfoModel

fun BookInfoDto.toDomain(): BookInfoModel {


    val firstPublishYear = firstPublishDate
        ?.takeLast(4)
        ?.toIntOrNull()

    val coverUrl = covers.firstOrNull()?.let { coverId ->
        "${BuildConfig.COVER_BASE_URL}${coverId}-${BuildConfig.COVER_SIZE}.jpg"
    }

    return BookInfoModel(
        id = key?.removePrefix("/works/") ?: "",
        title = title,
        authors = authors.map { it.author.key },
        coverUrl = coverUrl,
        firstPublishYear = firstPublishYear,
        editionCount = 0
    )
}