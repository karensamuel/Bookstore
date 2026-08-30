package com.example.info.domain

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.info.domain.model.AuthorId
import com.example.info.domain.model.AuthorModel
import com.example.info.domain.model.AuthorName
import com.example.info.domain.model.BookInfoFirstModel
import com.example.info.domain.model.BookInfoModel

interface BookInfoDataSource {
    suspend fun getBookDetails(bookId: String): Result<BookInfoFirstModel, DataError>

    suspend fun getAuthor(id: AuthorId): Result<AuthorModel, DataError>
}
