package com.example.bookinfo.data.remote



import kotlinx.serialization.Serializable

@Serializable
data class BookInfoDto(
    val key: String,
    val title: String,
    val authors: List<WorkAuthorDto> = emptyList(),
    val covers: List<Int> = emptyList(),
    val first_publish_date: String? = null,
    val description: String? = null
)

@Serializable
data class WorkAuthorDto(
    val author: AuthorKeyDto
)

@Serializable
data class AuthorKeyDto(
    val key: String
)

@Serializable
data class AuthorDto(
    val key: String,
    val name: String
)