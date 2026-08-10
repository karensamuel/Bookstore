package com.example.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.core.domain.model.Book
import com.example.presentation.components.BookItem
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier

@Composable
fun BookList(books: List<Book>, modifier: Modifier) {
    LazyColumn {
        items(books) { book ->
            BookItem(book)
        }
    }
}
