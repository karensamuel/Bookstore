package com.example.bookinfo.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorDto(
    @SerialName("key")
    val key: String, @SerialName("name")
    val name: String
)