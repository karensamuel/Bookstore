package com.example.book.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.repo.model.Book
import com.example.presentation.components.BookItem


@Composable
fun BookList(
    books: List<Book>, modifier: Modifier = Modifier, onBookClick: (String) -> Unit
) {
    Column(modifier = modifier) {
        LazyColumn {
            items(books) { book ->
                BookItem(
                    book, onClick = {
                        onBookClick(book.id)
                    })
            }
        }
    }
}

@Composable
fun BookListRoute(books: List<Book>, modifier: Modifier = Modifier, onBookClick: (String) -> Unit) {
    BookList(books = books, modifier = modifier, onBookClick = onBookClick)
}
