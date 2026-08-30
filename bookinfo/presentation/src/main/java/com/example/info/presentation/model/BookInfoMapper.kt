package com.example.info.presentation.model

import android.util.Log
import com.example.info.domain.model.AuthorName
import com.example.info.domain.model.BookInfoModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

fun bookInfoMapper(bookInfo: BookInfoModel): UiBookInfoModel {
    Log.d("bookInfoMapperkaren", "bookInfoMapper: $bookInfo")
    return UiBookInfoModel(
        id = bookInfo.id,
        title = bookInfo.title,
        authors = authorMapper(bookInfo.authors),
        coverUrl = bookInfo.coverUrl,
        firstPublishYear = bookInfo.firstPublishYear,
        editionCount = bookInfo.editionCount
    )
}
fun authorMapper(authors: ImmutableList<AuthorName>):  ImmutableList<String> {
    return authors.map {
        Log.d("authorMapperkaren", "authorMapper: $it")

        it.name
    }.toImmutableList()
}
