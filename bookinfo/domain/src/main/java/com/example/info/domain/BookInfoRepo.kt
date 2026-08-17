package com.example.info.domain

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.info.domain.model.BookInfoModel

interface BookInfoRepo {
    suspend fun getBookDetails(bookId: String): Result<BookInfoModel, DataError>
}