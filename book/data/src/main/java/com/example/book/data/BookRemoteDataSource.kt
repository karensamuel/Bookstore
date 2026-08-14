package com.example.book.data

import com.example.book.data.remote.dto.BooksResponseDto
import com.example.book.data.remote.dto.toDomain
import com.example.core.data.network.safeCall
import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.core.domain.model.result.map
import com.example.domain.repo.BookDataSource
import com.example.domain.repo.modles.Book
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class BookRemoteDataSource(
    private val client: HttpClient
) : BookDataSource {

    override suspend fun getBooks():  Result<List<Book>, DataError> {
        val result :  Result<BooksResponseDto, DataError.Network> = safeCall {
            client.get("search.json") {
                parameter("q","android")
            }
        }
        return result.map { response ->
            response.docs.map { it.toDomain() }
        }

    }
}