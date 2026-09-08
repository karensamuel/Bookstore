package com.example.history.domain.usecases

import com.example.core.domain.model.error.DataError
import com.example.history.domain.BookHistoryRepo
import com.example.history.domain.model.BookHistoryModel
import com.example.core.domain.model.result.Result


class BookGetHistoryUseCase(
    private val repository: BookHistoryRepo,
) {
    suspend operator fun invoke(): Result<List<BookHistoryModel>, DataError> = repository.getBooks()
}
