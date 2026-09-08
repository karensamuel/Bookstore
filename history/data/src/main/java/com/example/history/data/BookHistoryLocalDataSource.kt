package com.example.history.data

import com.example.core.data.local.safeLocalCall
import com.example.core.data.network.safeCall
import com.example.core.domain.model.error.DataError
import com.example.history.data.local.HistoryBookDao
import com.example.history.domain.model.BookHistoryModel
import com.example.core.domain.model.result.Result
import com.example.history.data.local.toDomain
import com.example.history.data.local.toEntity
import com.example.history.domain.BookHistoryDataSource

class BookHistoryLocalDataSource(
    private val historyBookDao: HistoryBookDao
): BookHistoryDataSource
{
    override suspend fun getBooks(): Result<List<BookHistoryModel>, DataError.Local> {
        return safeLocalCall {
            historyBookDao
                .getAll()
                .map { it.toDomain() }
        }

    }

    override suspend fun addBook(book: BookHistoryModel): Result<Unit, DataError.Local> {
        return safeLocalCall {
            historyBookDao.insertBook(book.toEntity())
        }
    }



}
