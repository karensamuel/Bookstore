package com.example.book.data

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.domain.repo.BookDataSource
import com.example.domain.repo.BookRepository
import com.example.domain.repo.model.Book

class BookRepositoryImpl(
    private val remoteDataSource: BookDataSource
) : BookRepository {

    override suspend fun getBooks(): Result<List<Book>, DataError> {
        return remoteDataSource.getBooks()
    }
}