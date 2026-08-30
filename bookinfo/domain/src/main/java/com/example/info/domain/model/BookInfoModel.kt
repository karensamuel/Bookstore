package com.example.info.domain.model

import kotlinx.collections.immutable.ImmutableList

data class BookInfoModel(
    val id: String,
    val title: String?,
    val authors: ImmutableList<AuthorName>,
    val coverUrl: String?,
    val firstPublishYear: Int?,
    val editionCount: Int,
)

@JvmInline
value class AuthorName(val name: String)