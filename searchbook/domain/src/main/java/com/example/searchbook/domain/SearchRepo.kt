package com.example.searchbook.domain

import com.example.searchbook.domain.models.Book

interface SearchRepo {
    suspend fun searchBooks(
        query: String
    ): Result<List<Book>>
}