package com.example.info.domain.model

import kotlinx.collections.immutable.ImmutableList

fun toBookInfo(
    firstModel: BookInfoFirstModel,
    authors: ImmutableList<AuthorName>,
): BookInfoModel =
    BookInfoModel(
        id = firstModel.id,
        title = firstModel.title,
        authors = authors,
        coverUrl = firstModel.coverUrl,
        firstPublishYear = firstModel.firstPublishYear,
        editionCount = firstModel.editionCount,
    )
