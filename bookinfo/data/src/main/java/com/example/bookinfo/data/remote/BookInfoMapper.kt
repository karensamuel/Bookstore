package com.example.bookinfo.data.remote


import com.example.info.domain.model.BookInfoModel

fun BookInfoDto.toDomain(authorNames: List<String>): BookInfoModel {


    val firstPublishYear = first_publish_date
        ?.takeLast(4)
        ?.toIntOrNull()

    val coverUrl = covers.firstOrNull()?.let { coverId ->
        "https://covers.openlibrary.org/b/id/${coverId}-L.jpg"
    }

    return BookInfoModel(
        id = key.removePrefix("/works/"),
        title = title,
        authors = authorNames,
        coverUrl = coverUrl,
        firstPublishYear = firstPublishYear,
        editionCount = 0
    )
}