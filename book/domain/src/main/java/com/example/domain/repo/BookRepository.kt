package com.example.domain.repo

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.domain.repo.model.Book

interface BookRepository {
    suspend fun getBooks(): Result<List<Book>, DataError>
}
