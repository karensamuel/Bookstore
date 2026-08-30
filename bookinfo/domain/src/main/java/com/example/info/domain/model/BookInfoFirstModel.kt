package com.example.info.domain.model

import kotlinx.collections.immutable.ImmutableList

data class BookInfoFirstModel(
    val id: String,
    val title: String?,
    val authors: ImmutableList<AuthorId>,
    val coverUrl: String?,
    val firstPublishYear: Int?,
    val editionCount: Int,
)

@JvmInline
value class AuthorId(
    val name: String,
)
