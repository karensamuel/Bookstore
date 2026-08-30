package com.example.bookinfo.data

import com.example.bookinfo.data.remote.AuthorDto
import com.example.bookinfo.data.remote.BookInfoDto
import com.example.bookinfo.data.remote.toDomain
import com.example.core.data.network.safeCall
import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.core.domain.model.result.map
import com.example.info.domain.BookInfoDataSource
import com.example.info.domain.model.AuthorId
import com.example.info.domain.model.AuthorModel
import com.example.info.domain.model.AuthorName
import com.example.info.domain.model.BookInfoFirstModel
import com.example.info.domain.model.BookInfoModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class BookInfoRemoteDataSource(
    private val client: HttpClient
) : BookInfoDataSource {

    override suspend fun getBookDetails(
        bookId: String
    ): Result<BookInfoFirstModel, DataError> {
        val result: Result<BookInfoDto, DataError.Network> = safeCall {
            client.get("${BuildConfig.BOOK_INFO_ENDPOINT}$bookId.json")
        }
        return result.map { bookInfoDto ->
            bookInfoDto.toDomain()
        }
    }




    override suspend fun getAuthor(
        id: AuthorId
    ): Result<AuthorModel, DataError> {
        val result: Result<AuthorDto, DataError.Network> = safeCall {
            client.get("authors/${id.id}.json")
        }

        return result.map { authorDto ->
            authorDto.toDomain()
        }
    }
}
