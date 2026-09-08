package com.example.history.domain.model

import kotlinx.collections.immutable.ImmutableList

data class BookHistoryModel(
   val id: String,
   val title: String,
   val authors: ImmutableList<String>,
   val coverUrl: String?,
   val viewedAt: Long
)
