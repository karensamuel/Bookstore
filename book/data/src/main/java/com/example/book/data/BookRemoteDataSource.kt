package com.example.book.data

import android.util.Log
import com.example.book.data.remote.dto.BooksResponseDto
import com.example.book.data.remote.dto.toDomain
import com.example.core.data.network.safeCall
import com.example.core.domain.model.error.DataError
import com.example.core.domain.model.result.Result
import com.example.core.domain.model.result.map
import com.example.domain.repo.BookDataSource
import com.example.domain.repo.model.Book
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class BookRemoteDataSource(
    private val client: HttpClient,

) : BookDataSource {

    override suspend fun getBooks(): Result<List<Book>, DataError> {
        Log.d("book endpoint karen", "${BuildConfig.GET_BOOKS_ENDPOINT}")
        val result: Result<BooksResponseDto, DataError.Network> = safeCall {
            client.get(BuildConfig.GET_BOOKS_ENDPOINT) {

            }
        }
        return result.map { response ->
            response.works.map { it.toDomain() }
        }

    }
}