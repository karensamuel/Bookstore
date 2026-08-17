package com.example.info.domain

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.info.domain.model.AuthorModel
import com.example.info.domain.model.BookInfoModel

interface BookInfoDataSource {
    suspend fun getBookDetails(
        bookId: String
    ): Result<BookInfoModel, DataError>


    suspend fun getAuthor(id: String): Result<AuthorModel, DataError>
}