package com.example.bookinfo.data

import com.example.bookinfo.data.remote.AuthorDto
import com.example.bookinfo.data.remote.BookInfoDto
import com.example.bookinfo.data.remote.toDomain
import com.example.core.data.network.safeCall
import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.core.domain.model.result.flatMap
import com.example.core.domain.model.result.map
import com.example.info.domain.BookInfoDataSource
import com.example.info.domain.model.AuthorModel
import com.example.info.domain.model.BookInfoModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class BookInfoRemoteDataSource(
    private val client: HttpClient) : BookInfoDataSource {

    override suspend fun getBookDetails(
        bookId: String
    ): Result<BookInfoModel, DataError> {
        return safeCall {
                client.get("${BuildConfig.BOOK_INFO_ENDPOINT}$bookId.json")
        }
    }


    override suspend fun getAuthor(
        id: String
    ): Result<AuthorModel, DataError.Network> {
        val result: Result<AuthorDto, DataError.Network> = safeCall {
            client.get("$id.json")
        }
        return result.map { authorDto ->
            authorDto.toDomain()
        }
    }
}
