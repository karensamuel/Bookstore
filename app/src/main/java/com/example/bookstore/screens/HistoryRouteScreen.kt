package com.example.bookstore.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.history.presentation.HistoryScreen
import com.example.history.presentation.model.BookHistoryIntent
import com.example.history.presentation.model.UiBookHistoryModel
import com.example.history.presentation.viewmodel.BookHistoryViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HistoryRouteScreen(
    modifier: Modifier = Modifier,
    onBookClick: (UiBookHistoryModel) -> Unit
){
    val viewModel: BookHistoryViewModel = koinViewModel()
    LaunchedEffect(Unit) {
        viewModel.onIntent(BookHistoryIntent.LoadBooks)
    }
    HistoryScreen(
        modifier = modifier,
        viewModel = viewModel,
        onBookClick = onBookClick
    )
}