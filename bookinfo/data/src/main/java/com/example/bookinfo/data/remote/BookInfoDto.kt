package com.example.bookinfo.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookInfoDto(
    @SerialName("key") val key: String? = "",
    @SerialName("title") val title: String? = "",
    @SerialName("authors")
    val authors: List<WorkAuthorDto> = emptyList(),
    @SerialName("covers")
    val covers: List<Int> = emptyList(),
    @SerialName("first_publish_year") val firstPublishDate: String? = "",
    @SerialName("description") val description: String? = ""
)

@Serializable
data class WorkAuthorDto(
    @SerialName("author")
    val author: AuthorKeyDto
)

@Serializable
data class AuthorKeyDto(
    @SerialName("key")
    val key: String
)

