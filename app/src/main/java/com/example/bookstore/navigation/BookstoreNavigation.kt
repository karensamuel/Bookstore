package com.example.bookstore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.bookstore.screens.HistoryRouteScreen
import com.example.bookstore.screens.HomeRouteScreen
import com.example.history.domain.model.BookHistoryModel
import com.example.history.presentation.model.BookHistoryIntent
import com.example.history.presentation.viewmodel.BookHistoryViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookstoreNavigation(modifier: Modifier, backStack: NavBackStack<NavKey>) {
    val viewModel: BookHistoryViewModel = koinViewModel()

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<BookstoreRoute.Home> {
                HomeRouteScreen(
                    modifier = modifier,
                    onBookClick = { book ->
                        val historyBook = BookHistoryModel(
                            id = book.id,
                            title = book.title,
                            authors = book.authors,
                            coverUrl = book.coverUrl,
                            viewedAt = System.currentTimeMillis()
                        )

                        viewModel.onIntent(BookHistoryIntent.AddBook(historyBook))
                        val normalizedId =
                            book.id.removePrefix("/works/")
                        //navigate to info screen
                        backStack.add(BookstoreRoute.BookInfo(normalizedId))

                    }
                )
            }
            entry<BookstoreRoute.History> {
                HistoryRouteScreen(
                    modifier = modifier,
                    onBookClick = { book ->
                        val historyBook = BookHistoryModel(
                            id = book.id,
                            title = book.title,
                            authors = book.authors,
                            coverUrl = book.coverUrl,
                            viewedAt = System.currentTimeMillis()
                        )

                        viewModel.onIntent(BookHistoryIntent.AddBook(historyBook))
                        val normalizedId =
                            book.id.removePrefix("/works/")

                        //navigate to bookinfo
                        backStack.add(BookstoreRoute.BookInfo(normalizedId))
                    }
                )
            }
            entry<BookstoreRoute.BookInfo> {
                BookInfoRouteScreen(
                    modifier = modifier,
                    bookId = it.bookId
                )
            }

        },
        modifier = Modifier
    )

}