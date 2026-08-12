package com.example.domain.repo

import com.example.domain.repo.modles.Book

interface BookRepo {
    suspend fun getBooks(): Result<List<Book>>

    suspend fun searchBooks(
        query: String
    ): Result<List<Book>>
}
