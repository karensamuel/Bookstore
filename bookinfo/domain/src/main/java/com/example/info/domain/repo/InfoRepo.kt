package com.example.bookinfo.domain.repo

import java.awt.print.Book

interface InfoRepo {
    suspend fun getBookDetails(bookId: String): Result<Book>
}