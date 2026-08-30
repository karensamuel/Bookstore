package com.example.bookinfo.data

import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.core.domain.model.result.flatMap
import com.example.info.domain.BookInfoDataSource
import com.example.info.domain.BookInfoRepo
import com.example.info.domain.model.AuthorId
import com.example.info.domain.model.AuthorName
import com.example.info.domain.model.BookInfoModel
import com.example.info.domain.model.toBookInfo
import kotlinx.collections.immutable.persistentListOf


class BookInfoRepoImpl(
    private val remoteDataSource: BookInfoDataSource
) : BookInfoRepo {
    override suspend fun getBookDetails(bookId: String): Result<BookInfoModel, DataError> {


        return remoteDataSource.getBookDetails(bookId)
            .flatMap { book ->

                var authors = persistentListOf<AuthorName>()

                for (authorId in book.authors) {

                    when (val result = remoteDataSource.getAuthor(AuthorId(authorId.id))) {

                        is Result.Success -> {
                            authors = authors.add(
                                AuthorName(result.data.name)
                            )
                        }

                        is Result.Error -> {
                            return@flatMap Result.Error(result.error)
                        }
                    }
                }

                Result.Success(
                    toBookInfo(book,authors )
                )
            }
    }
}