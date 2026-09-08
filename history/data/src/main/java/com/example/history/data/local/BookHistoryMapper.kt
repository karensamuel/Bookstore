package com.example.history.data.local

import com.example.history.domain.model.BookHistoryModel
import kotlinx.collections.immutable.toImmutableList
import kotlin.collections.emptyList

fun HistoryBookEntity.toDomain(): BookHistoryModel {
    return BookHistoryModel(
        id = uid,
        title = title.orEmpty(),
        authors = authors
            ?.split(",")
            ?.map { it.trim() }
            ?.filter { it.isNotEmpty() }
            ?.toImmutableList()
            ?: emptyList<String>().toImmutableList(),
        coverUrl = coverUrl,
        viewedAt = viewedAt
    )
}
fun BookHistoryModel.toEntity(): HistoryBookEntity {
    return HistoryBookEntity(
        uid = id,
        title = title,
        authors = authors.joinToString(","),
        coverUrl = coverUrl,
        viewedAt = viewedAt
    )
}