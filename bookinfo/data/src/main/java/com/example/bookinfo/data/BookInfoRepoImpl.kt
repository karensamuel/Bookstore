package com.example.bookinfo.data

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.core.domain.model.result.flatMap
import com.example.core.domain.model.result.map
import com.example.info.domain.BookInfoDataSource
import com.example.info.domain.BookInfoRepo
import com.example.info.domain.model.BookInfoModel


class BookInfoRepoImpl(
    private val remoteDataSource: BookInfoDataSource
) : BookInfoRepo {
    override suspend fun getBookDetails(bookId: String): Result<BookInfoModel, DataError> {
        return remoteDataSource.getBookDetails(bookId)
            .flatMap { book ->

                val authors = mutableListOf<String>()

                for (authorId in book.authors) {

                    when (val result = remoteDataSource.getAuthor(authorId)) {

                        is Result.Success -> {
                            println("AUTHOR RESULT karen: ${result.data}")
                            println("AUTHOR NAME karen : ${result.data.name}")
                            authors.add(result.data.name)
                        }

                        is Result.Error -> {
                            return@flatMap Result.Error(result.error)
                        }
                    }
                }

                Result.Success(
                    book.copy(
                        authors = authors
                    )
                )
            }

    }

}