package com.example.bookinfo.data.remote


import com.example.bookinfo.data.BuildConfig
import com.example.info.domain.model.AuthorId
import com.example.info.domain.model.AuthorName
import com.example.info.domain.model.BookInfoFirstModel
import com.example.info.domain.model.BookInfoModel
import kotlinx.collections.immutable.ImmutableList

fun BookInfoDto.toDomain(): BookInfoFirstModel {


    val firstPublishYear = firstPublishDate
        ?.takeLast(4)
        ?.toIntOrNull()

    val coverUrl = covers.firstOrNull()?.let { coverId ->
        "${BuildConfig.COVER_BASE_URL}${coverId}-${BuildConfig.COVER_SIZE}.jpg"
    }

    return BookInfoFirstModel(
        id = key?.removePrefix("/works/") ?: "",
        title = title,
        authors = changeToAuthorId(authors),
        coverUrl = coverUrl,
        firstPublishYear = firstPublishYear,
        editionCount = 0
    )
}
fun changeToAuthorId(authors: List<WorkAuthorDto>): ImmutableList<AuthorId> {
    val authorIds = authors.map { it.author.key }
    return authorIds.map {  AuthorId(it) } as ImmutableList<AuthorId>

}