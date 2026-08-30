package com.example.presentation.model

import kotlinx.collections.immutable.ImmutableList

data class UiBookModel(
    val id: String,
    val title: String,
    val authors: ImmutableList<String>,
    val coverUrl: String?,
)