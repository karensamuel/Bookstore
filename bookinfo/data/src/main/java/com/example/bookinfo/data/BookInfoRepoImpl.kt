package com.example.bookinfo.data

import com.example.info.domain.BookInfoRepo
import com.example.core.domain.model.error.DataError
import com.example.info.domain.model.BookInfoModel
import com.example.core.domain.model.result.Result


class BookInfoRepoImpl(
    private val remoteDataSource: BookInfoRemoteDataSource
): BookInfoRepo {
    override suspend fun getBookDetails(bookId: String):Result<BookInfoModel, DataError>{
        return remoteDataSource.getBookDetails(bookId)

    }

}