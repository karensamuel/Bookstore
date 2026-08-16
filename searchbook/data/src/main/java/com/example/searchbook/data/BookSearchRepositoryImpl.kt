package com.example.searchbook.data

import com.example.core.domain.model.error.DataError


import com.example.core.domain.model.result.Result
import com.example.searchbook.domain.SearchRepo
import com.example.searchbook.domain.models.BookSearch

class BookSearchRepositoryImpl(
    private val remoteDataSource: BookRemoteDataSource
) : SearchRepo {


    override suspend fun searchBooks(query: String): Result<List<BookSearch>, DataError> {
        return remoteDataSource.getBooks(query)
    }
}