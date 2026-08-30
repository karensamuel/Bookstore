package com.example.book.presentation.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.result.onError
import com.example.core.domain.model.result.onSuccess
import com.example.domain.repo.usecases.BookUseCase
import com.example.presentation.model.BookIntent
import com.example.presentation.model.BookUiState
import com.example.presentation.model.toUiBook
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookViewModel(
    private val bookUseCase: BookUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<BookUiState>(BookUiState.Loading)
    val uiState: StateFlow<BookUiState> = _uiState.asStateFlow()

    fun onIntent(intent: BookIntent) {
        when (intent) {
            BookIntent.LoadBooks -> loadBooks()
        }
    }

    private fun loadBooks() {
        viewModelScope.launch {
            _uiState.update {
                BookUiState.Loading
            }

            val result = bookUseCase()

            result.onSuccess { books ->
                _uiState.update {
                    val uiBooks = books.map { book -> toUiBook(book) }
                    BookUiState.Success(uiBooks.toImmutableList())
                }
            }

            result.onError { error ->
                _uiState.update {
                    BookUiState.Error("$error")
                }
            }
        }
    }
}