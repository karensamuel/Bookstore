package com.example.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.presentation.components.BookItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.domain.repo.modles.Book
import com.example.presentation.components.SearchBar

@Composable
fun HomeRoute() {

    var query by remember { mutableStateOf("") }

    HomeScreen(
        books = books,
        query = query,
        onQueryChange = { query = it }
    )
}
@Composable
fun HomeScreen(
    books: List<Book>,
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {

        SearchBar(
            query = query,
            onQueryChange = onQueryChange
        )

        LazyColumn {
            items(books) { book ->
                BookItem(book)
            }
        }
    }
}
