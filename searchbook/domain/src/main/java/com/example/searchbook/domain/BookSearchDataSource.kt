package com.example.searchbook.domain

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.searchbook.domain.models.BookSearch

interface BookSearchDataSource {
    suspend fun getBooks(q: String): Result<List<BookSearch>, DataError>
}
