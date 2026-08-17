package com.example.bookinfo.data.remote

import com.example.info.domain.model.AuthorModel

fun AuthorDto.toDomain(): AuthorModel {
    return AuthorModel(
        id = key,
        name = name
    )

}