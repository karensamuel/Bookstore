package com.example.book.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.repo.model.BookModel
import com.example.presentation.components.BookItem


@Composable
fun BookList(
    bookModels: List<BookModel>, modifier: Modifier = Modifier, onBookClick: (String) -> Unit
) {
    Column(modifier = modifier) {
        LazyColumn {
            items(bookModels) { book ->
                BookItem(
                    book, onClick = {
                        onBookClick(book.id)
                    })
            }
        }
    }
}

@Composable
fun BookListRoute(bookModels: List<BookModel>, modifier: Modifier = Modifier, onBookClick: (String) -> Unit) {
    BookList(bookModels = bookModels, modifier = modifier, onBookClick = onBookClick)
}
