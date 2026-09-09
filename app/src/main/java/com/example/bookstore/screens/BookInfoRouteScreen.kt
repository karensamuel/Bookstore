package com.example.bookstore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.info.presentation.BookDetailsScreen
import com.example.info.presentation.model.InfoIntent
import com.example.info.presentation.viewmodel.InfoViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookInfoRouteScreen(
    bookId: String,
) {
    val infoViewModel: InfoViewModel = koinViewModel()
    LaunchedEffect(bookId) {
        bookId.let {
            infoViewModel.onIntent(InfoIntent.onLoadPage(it))
        }
    }
    BookDetailsScreen(
        bookViewModel = infoViewModel
    )

}