package com.example.book.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.book.presentation.model.BookIntent
import com.example.book.presentation.viewmodel.BookViewModel
import com.example.domain.repo.model.BookModel
import com.example.presentation.components.BookItem
import com.example.presentation.model.UiBookModel
import kotlinx.collections.immutable.ImmutableList
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookList(
    modifier: Modifier = Modifier,
    bookModels: ImmutableList<UiBookModel>,
    onBookClick: (String) -> Unit
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
fun BookListRoute(viewModel: BookViewModel = koinViewModel(), modifier: Modifier = Modifier, onBookClick: (String) -> Unit) {

    val state = viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.onIntent(BookIntent.LoadBooks)
    }
    BookList(bookModels = state.value.books, modifier = modifier, onBookClick = onBookClick)
}
