package com.example.searchbook.domain.usecases

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.searchbook.domain.SearchRepo
import com.example.searchbook.domain.models.BookSearch

class SearchBookUseCase(
    private val repository: SearchRepo,
) {
    suspend operator fun invoke(query: String): Result<List<BookSearch>, DataError> = repository.searchBooks(query)
}
