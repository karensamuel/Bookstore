package com.example.domain.repo

import com.example.core.domain.model.Book

interface BookRepo {
    suspend fun getBooks(): Result<List<Book>>

    suspend fun searchBooks(
        query: String
    ): Result<List<Book>>
}
