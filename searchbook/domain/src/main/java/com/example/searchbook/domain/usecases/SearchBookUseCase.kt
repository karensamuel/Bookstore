package com.example.searchbook.domain.usecases

import com.example.core.domain.model.error.DataError
import com.example.searchbook.domain.SearchRepo
import com.example.searchbook.domain.models.BookSearch
import com.example.core.domain.model.result.Result

class SearchBookUseCase(private val repository: SearchRepo) {
    suspend operator fun invoke(query: String): Result<List<BookSearch>, DataError> {
        return repository.searchBooks(query)
    }
}

