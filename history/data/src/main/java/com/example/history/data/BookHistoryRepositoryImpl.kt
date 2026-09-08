package com.example.history.data

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.history.domain.BookHistoryDataSource
import com.example.history.domain.BookHistoryRepo
import com.example.history.domain.model.BookHistoryModel

class BookHistoryRepositoryImpl(
    private val localDataSource: BookHistoryDataSource
) : BookHistoryRepo{
    override suspend fun getBooks(): Result<List<BookHistoryModel>, DataError> {
        return localDataSource.getBooks()
    }

    override suspend fun addBook(book: BookHistoryModel): Result<Unit, DataError> {
       return localDataSource.addBook(book)
    }

}