package com.example.info.presentation.model

import kotlinx.collections.immutable.ImmutableList

data class UiBookInfoModel(
    val id: String,
    val title: String?,
    val authors: ImmutableList<String>,
    val coverUrl: String?,
    val firstPublishYear: Int?,
    val editionCount: Int,
)
