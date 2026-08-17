package com.example.bookinfo.data

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.info.domain.BookInfoRepo
import com.example.info.domain.model.BookInfoModel


class BookInfoRepoImpl(
    private val remoteDataSource: BookInfoRemoteDataSource
) : BookInfoRepo {
    override suspend fun getBookDetails(bookId: String): Result<BookInfoModel, DataError> {
        return remoteDataSource.getBookDetails(bookId)

    }

}