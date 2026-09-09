package com.example.history.presentation.model

import kotlinx.collections.immutable.ImmutableList

data class UiBookHistoryModel (
    val id: String,
    val title: String,
    val authors: ImmutableList<String>,
    val coverUrl: String?,
    val viewedAt: Long
)