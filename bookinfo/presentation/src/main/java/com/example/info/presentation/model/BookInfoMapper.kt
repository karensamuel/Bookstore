package com.example.info.presentation.model

import com.example.info.domain.model.BookInfoModel
import kotlinx.collections.immutable.toImmutableList

fun bookInfoMapper(bookInfo: BookInfoModel): UiBookInfoModel {
    return UiBookInfoModel(
        id = bookInfo.id,
        title = bookInfo.title,
        authors = bookInfo.authors.toImmutableList(),
        coverUrl = bookInfo.coverUrl,
        firstPublishYear = bookInfo.firstPublishYear,
        editionCount = bookInfo.editionCount
    )
}
