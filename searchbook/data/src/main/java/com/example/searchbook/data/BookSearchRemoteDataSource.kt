package com.example.searchbook.data


import com.example.core.data.network.safeCall
import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.core.domain.model.result.map
import com.example.searchbook.data.remote.BooksSearchResponseDto
import com.example.searchbook.data.remote.toDomain
import com.example.searchbook.domain.BookSearchDataSource
import com.example.searchbook.domain.models.BookSearch
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class BookSearchRemoteDataSource(
    private val client: HttpClient
) : BookSearchDataSource {

    override suspend fun getBooks(q: String): Result<List<BookSearch>, DataError> {
        val result: Result<BooksSearchResponseDto, DataError.Network> = safeCall {
            client.get(BuildConfig.SEARCH_ENDPOINT) {
                parameter("q", q)
            }


        }
        return result.map { response ->
            response.docs.map { it.toDomain() }
        }

    }
}