package com.example.bookinfo.domain.repo

import com.example.core.domain.model.error.DataError
import com.example.info.domain.model.BookInfoModel
import com.example.core.domain.model.result.Result


interface BookInfoRepo {
    suspend fun getBookDetails(bookId: String): Result<BookInfoModel, DataError>
}