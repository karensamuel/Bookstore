package com.example.domain.repo

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.domain.repo.model.BookModel

interface BookDataSource {
    suspend fun getBooks(): Result<List<BookModel>, DataError>
}
