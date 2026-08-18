package com.example.book.presentation.viewmodel



import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.book.presentation.model.BookIntent
import com.example.book.presentation.model.BookUiState
import com.example.core.domain.model.result.onError
import com.example.core.domain.model.result.onSuccess
import com.example.domain.repo.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(BookUiState())
    val uiState: StateFlow<BookUiState> = _uiState.asStateFlow()

    fun onIntent(intent: BookIntent) {
        when (intent) {
            BookIntent.LoadBooks -> loadBooks()
        }
    }

    private fun loadBooks() {
        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            val result = bookRepository.getBooks()

            result.onSuccess { books ->
                _uiState.update {

                    Log.d("book view model karen", "view model working")
                    it.copy(
                        books = books,
                        isLoading = false,
                        error = null
                    )
                }
            }

            result.onError { error ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = error.toString()
                    )
                }
            }
        }
    }
}