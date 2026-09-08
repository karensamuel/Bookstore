package com.example.history.domain

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.history.domain.model.BookHistoryModel

interface BookHistoryDataSource {
    suspend fun getBooks(): Result<List<BookHistoryModel>, DataError>
    suspend fun addBook(book: BookHistoryModel): Result<Unit, DataError>

}