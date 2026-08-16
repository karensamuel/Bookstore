package com.example.bookinfo.data

import android.util.Log
import com.example.bookinfo.data.remote.AuthorDto
import com.example.bookinfo.data.remote.BookInfoDto
import com.example.bookinfo.data.remote.toDomain
import com.example.core.data.network.safeCall
import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.core.domain.model.result.map
import com.example.info.domain.model.BookInfoModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class BookInfoRemoteDataSource(
    private val client: HttpClient,
    private val bookInfoEndpoint: String
) {

    suspend fun getBookDetails(
        bookId: String
    ): Result<BookInfoModel, DataError> {

        val result: Result<BookInfoDto, DataError.Network> = safeCall {
            client.get("$bookInfoEndpoint$bookId.json")
        }

        return result.map { response ->

            val authorNames = response.authors.mapNotNull { authorReference ->

                when (val authorResult = getAuthor(authorReference.author.key)) {
                    is Result.Success -> authorResult.data.name
                    is Result.Error -> null
                }
            }

            response.toDomain(authorNames)
        }
    }

    private suspend fun getAuthor(
        authorKey: String
    ): Result<AuthorDto, DataError.Network> {

        return safeCall {
            client.get("$authorKey.json")
        }
    }
}