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
import com.example.history.presentation.HistoryScreen
import com.example.history.presentation.model.BookHistoryIntent
import com.example.history.presentation.model.BookHistoryUiState
import com.example.history.presentation.model.UiBookHistoryModel
import com.example.history.presentation.viewmodel.BookHistoryViewModel
import com.example.presentation.model.BookIntent
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
    val state  by viewModel.uiState.collectAsStateWithLifecycle()
    when (state){

        BookHistoryUiState.Loading -> {
            Column (
                verticalArrangement= Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxSize()
            ){
                CircularProgressIndicator()
            }
        }
        is BookHistoryUiState.Success -> {
            HistoryScreen(
                modifier = modifier,
                viewModel = viewModel,
                onBookClick = onBookClick
            )
        }
        is BookHistoryUiState.Error -> {
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
                        viewModel.onIntent(
                            BookHistoryIntent.LoadBooks
                        )
                    }
                ) {
                    Text("Try Again")
                }
            }
        }
    }

}