package com.example.searchbook.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.presentation.components.SearchBar
import com.example.presentation.model.SearchIntent
import com.example.presentation.viewmodel.SearchViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchRoute(
    viewModel: SearchViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    SearchBar(
        query = state.query,
        onQueryChange = {
            viewModel.onIntent(
                SearchIntent.OnQueryChange(it)
            )
        }
    )
}