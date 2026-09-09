package com.example.history.presentation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.history.presentation.components.HistoryBookCard
import com.example.history.presentation.model.BookHistoryUiState
import com.example.history.presentation.model.UiBookHistoryModel
import com.example.history.presentation.viewmodel.BookHistoryViewModel
import kotlinx.collections.immutable.persistentListOf
import org.koin.androidx.compose.koinViewModel

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: BookHistoryViewModel = koinViewModel(),
    onBookClick: (UiBookHistoryModel) -> Unit,

) {


    val state = viewModel.uiState.collectAsStateWithLifecycle()
    val books =  (state.value as? BookHistoryUiState.Success)?.books
        ?: persistentListOf()


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        Text(
            text = "History",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 16.dp
            )
        )

        if (books.isEmpty()) {

            Text(
                text = "No books viewed yet.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

        } else {
            val listState = rememberLazyListState()

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp),
                state = listState

            ) {
                items(
                    items = books,
                    key = { it.id }
                ) { book ->

                    HistoryBookCard(
                        book = book,
                        onClick = {
                            onBookClick(book)
                        }
                    )
                }
            }
        }
    }
}