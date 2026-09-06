package com.example.book.data

import com.example.domain.repo.BookDataSource
import com.example.domain.repo.model.BookModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import com.example.core.domain.model.result.Result
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import junit.framework.TestCase.assertTrue
import kotlinx.serialization.json.Json

class BookRemoteDataSourceUnitTest {
    private var client = mockk<HttpClient>()
    private lateinit var dataSource: BookDataSource

    @Test
    fun `successful response should return Result Success`() = runTest {
        val engine = MockEngine {
            respond(
                content = ByteReadChannel(
                    """
                         {
                        "works": [
                            {
                                "key": "123",
                                "title": "harry potter",
                                "author_name": ["J.K. Rowling"],
                                "cover_i": 207515
                            }
                        ]
                    }
                    """.trimIndent()
                ),
                status = HttpStatusCode.OK,
                headers = headersOf(
                    HttpHeaders.ContentType,
                    ContentType.Application.Json.toString()
                )

            )

        }
        client = HttpClient(engine){
            install(ContentNegotiation){

                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
        dataSource = BookRemoteDataSource(client)
        val expected = listOf(
            BookModel(
                title = "harry potter",
                id = "123",
                authors = listOf("J.K. Rowling"),
                coverUrl = "https://covers.openlibrary.org/b/id/207515-M.jpg"
            )
        )
        val result = dataSource.getBooks()
        assertEquals(
            expected,
            (result as Result.Success).data
        )

        client.close()
    }

    @Test
    fun `unsuccessful response should return Result Error`() = runTest {
        val engine = MockEngine {
            respond(
                content = ByteReadChannel(
                    """
                {
                    "message": "Something went wrong"
                }
                """.trimIndent()
                ),
                status = HttpStatusCode.InternalServerError,
                headers = headersOf(
                    HttpHeaders.ContentType,
                    ContentType.Application.Json.toString()
                )
            )
        }
        client = HttpClient(engine) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
        dataSource = BookRemoteDataSource(client)
        val result = dataSource.getBooks()
        assertTrue(result is Result.Error)
        client.close()
    }
    }
