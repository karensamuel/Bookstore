package com.example.history.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.result.onError
import com.example.core.domain.model.result.onSuccess
import com.example.history.domain.model.BookHistoryModel
import com.example.history.domain.usecases.BookAddHistoryUseCase
import com.example.history.domain.usecases.BookGetHistoryUseCase
import com.example.history.presentation.model.BookHistoryIntent
import com.example.history.presentation.model.BookHistoryUiState
import com.example.history.presentation.model.toUiBookHistory
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookHistoryViewModel(
    private val bookGetHistoryUseCase: BookGetHistoryUseCase,
    private val bookAddHistoryUseCase: BookAddHistoryUseCase
): ViewModel()  {
    private val _uiState = MutableStateFlow<BookHistoryUiState>(BookHistoryUiState.Loading)
    val uiState: StateFlow<BookHistoryUiState> = _uiState.asStateFlow()
    fun onIntent(intent: BookHistoryIntent) {
        when (intent) {
            BookHistoryIntent.LoadBooks -> loadBooks()
            is BookHistoryIntent.AddBook -> addBook(intent.book)
        }
    }
    private fun loadBooks() {
        viewModelScope.launch {
            _uiState.update {
                BookHistoryUiState.Loading
            }

            val result = bookGetHistoryUseCase()

            result.onSuccess { books ->
                _uiState.update {
                    val uiBooks = books.map { book -> toUiBookHistory(book) }
                    BookHistoryUiState.Success(uiBooks.toImmutableList())
                }
            }

            result.onError { error ->
                _uiState.update {
                    BookHistoryUiState.Error("$error")
                }
            }
        }
    }
    private fun addBook(book: BookHistoryModel) {
        viewModelScope.launch {

            val result = bookAddHistoryUseCase(book)

            result.onSuccess {
                _uiState.update {
                    val uiBook = toUiBookHistory(book)
                    BookHistoryUiState.Success( listOf(uiBook).toImmutableList())
                }
            }

            result.onError { error ->
                _uiState.update {
                    BookHistoryUiState.Error("$error")
                }
            }
    }
    }


}