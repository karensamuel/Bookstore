package com.example.domain.repo.usecases

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.domain.repo.BookRepository
import com.example.domain.repo.model.BookModel

class BookUseCase(private val repository: BookRepository) {
    suspend operator fun invoke(): Result<List<BookModel>, DataError> {
        return repository.getBooks()
    }
}