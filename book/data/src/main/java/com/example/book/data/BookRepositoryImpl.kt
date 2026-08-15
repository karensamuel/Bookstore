package com.example.book.data

import com.example.core.domain.model.error.DataError
import com.example.domain.repo.BookRepository
import com.example.domain.repo.modles.Book

import com.example.core.domain.model.result.Result
class BookRepositoryImpl(
    private val remoteDataSource: BookRemoteDataSource
) : BookRepository {

    override suspend fun getBooks(): Result<List<Book>, DataError> {
        return remoteDataSource.getBooks()
    }
}