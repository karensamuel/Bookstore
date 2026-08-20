package com.example.info.domain.usecases

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.info.domain.BookInfoRepo
import com.example.info.domain.model.BookInfoModel

class InfoBookUseCase(private val repository: BookInfoRepo) {
    suspend operator fun invoke(bookId: String): Result<BookInfoModel, DataError> {
        return repository.getBookDetails(bookId)
    }
}

