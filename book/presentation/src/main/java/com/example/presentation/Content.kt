package com.example.book.presentation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.presentation.components.BookItem
import androidx.compose.ui.Modifier
import com.example.domain.repo.modles.Book
import com.example.presentation.books


@Composable
fun BookList(
    books: List<Book>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {



        LazyColumn {
            items(books) { book ->
                BookItem(book)
            }
        }
    }
}

@Composable
fun BookListRoute(modifier: Modifier = Modifier) {
    BookList(books = books, modifier = modifier)

}
