package com.example.book.data

import com.example.book.data.remote.dto.BookDto
import com.example.book.data.remote.dto.toDomain
import com.example.domain.repo.model.BookModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class BookMapperUnitTest {
    @Test
    fun `BookDto should map correctly to BookModel`() {
       val bookDto= BookDto(
            key = "123",
            title = "harry potter",
            authorName= listOf("J.K. Rowling") ,
            coverI = 207515
        )
        val bookModel = BookModel(
            id = "123",
            title = "harry potter",
            authors = listOf("J.K. Rowling"),
            coverUrl = "https://covers.openlibrary.org/b/id/207515-M.jpg"
        )
        assertEquals(bookModel,bookDto.toDomain())
    }
    @Test
    fun  `BookDto without cover should map coverUrl to null`(){
        val bookDto = BookDto(
            key = "123",
            title = "harry potter",
            authorName = listOf("J.K. Rowling"),
            coverI = null
        )

        val actual = bookDto.toDomain()

        assertEquals(null, actual.coverUrl)
    }
    @Test
    fun `BookDto with no authors should map empty authors list`() {
        val bookDto = BookDto(
            key = "123",
            title = "harry potter",
            authorName = emptyList(),
            coverI = 207515
        )

        val actual = bookDto.toDomain()

        assertEquals(emptyList<String>(), actual.authors)
    }
}