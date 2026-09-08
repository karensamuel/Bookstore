package com.example.history.domain.usecases

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.history.domain.BookHistoryRepo
import com.example.history.domain.model.BookHistoryModel

class BookAddHistoryUseCase(
    private val repository: BookHistoryRepo,

    ) {
    suspend operator fun invoke(book: BookHistoryModel): Result<Unit, DataError> =
        repository.addBook(book)
}