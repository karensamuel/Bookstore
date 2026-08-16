package com.example.book.data

import com.example.book.data.remote.dto.BooksResponseDto
import com.example.book.data.remote.dto.toDomain
import com.example.core.data.network.safeCall
import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.core.domain.model.result.map
import com.example.domain.repo.model.Book
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class BookRemoteDataSource(
    private val client: HttpClient
) {

    suspend fun getBooks(): Result<List<Book>, DataError> {
        val result: Result<BooksResponseDto, DataError.Network> = safeCall {
            client.get("trending/now.json") {

            }
        }
        return result.map { response ->
            response.works.map { it.toDomain() }
        }

    }
}