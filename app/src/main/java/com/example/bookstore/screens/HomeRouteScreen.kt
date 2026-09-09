package com.example.bookstore.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.book.presentation.viewmodel.BookViewModel
import com.example.presentation.BookList
import com.example.presentation.model.BookIntent
import com.example.presentation.model.BookUiState
import com.example.presentation.model.SearchUiState
import com.example.presentation.model.UiBookModel
import com.example.presentation.viewmodel.SearchViewModel
import com.example.searchbook.presentation.SearchRoute
import kotlinx.collections.immutable.toImmutableList
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRouteScreen(
    modifier: Modifier = Modifier,
    onBookClick: (UiBookModel) -> Unit
) {
    val bookViewModel: BookViewModel = koinViewModel()
    val searchViewModel: SearchViewModel = koinViewModel()

    val bookState by bookViewModel.uiState.collectAsStateWithLifecycle()
    val searchState by searchViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        bookViewModel.onIntent(BookIntent.LoadBooks)
    }

    Column (
        modifier = modifier.fillMaxSize()
    ){

        SearchRoute(

            viewModel = searchViewModel
        )
        when (bookState) {
            is BookUiState.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Something went wrong"
                    )

                    Button(
                        onClick = {
                            bookViewModel.onIntent(
                                BookIntent.LoadBooks
                            )
                        }
                    ) {
                        Text("Try Again")
                    }
                }
            }
            BookUiState.Loading -> {
                Column (
                    verticalArrangement= Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.fillMaxSize()
                ){
                    CircularProgressIndicator()
                }
            }

            is BookUiState.Success -> {
                if (searchState.query.isBlank()) {

                    BookList(
                        bookModels = (bookState as BookUiState.Success).books,
                        onBookClick = onBookClick
                    )

                } else {
                    when (searchState) {
                        is SearchUiState.Error -> {}
                        is SearchUiState.Loading -> {
                            Column (
                                verticalArrangement= Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = modifier.fillMaxSize()
                            ){
                                CircularProgressIndicator()
                            }
                        }

                        is SearchUiState.Success -> {
                            val books = (searchState as SearchUiState.Success).books.map { book ->
                                UiBookModel(
                                    id = book.id,
                                    title = book.title,
                                    authors = book.authors.toImmutableList(),
                                    coverUrl = book.coverUrl
                                )
                            }.toImmutableList()

                            BookList(
                                bookModels = books.toImmutableList(),
                                onBookClick = onBookClick
                            )
                        }
                    }

                }
            }
        }

    }
}