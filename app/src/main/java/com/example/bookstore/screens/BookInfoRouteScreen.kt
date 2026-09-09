package com.example.bookstore.navigation

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
import com.example.info.presentation.BookDetailsScreen
import com.example.info.presentation.model.InfoIntent
import com.example.info.presentation.model.InfoUiState
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
    val state  by infoViewModel.uiState.collectAsStateWithLifecycle()

    when (state) {
        is InfoUiState.Loading->{
            Column (
                verticalArrangement= Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CircularProgressIndicator()
            }

        }
        is InfoUiState.Success -> {
            BookDetailsScreen(
                book = (state as InfoUiState.Success).book
            )
        }
        is InfoUiState.Error -> {
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
                        infoViewModel.onIntent(
                            InfoIntent.onLoadPage(bookId)
                        )
                    }
                ) {
                    Text("Try Again")
                }
            }

        }
    }


}