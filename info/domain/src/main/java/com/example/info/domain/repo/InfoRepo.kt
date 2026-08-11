package com.example.info.domain.repo

import java.awt.print.Book

interface InfoRepo {
    suspend fun getBookDetails(bookId: String): Result<Book>
}