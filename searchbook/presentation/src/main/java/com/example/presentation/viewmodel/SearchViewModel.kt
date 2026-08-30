package com.example.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.result.onError
import com.example.core.domain.model.result.onSuccess
import com.example.presentation.model.SearchIntent
import com.example.presentation.model.SearchUiState
import com.example.presentation.model.toUiBook
import com.example.searchbook.domain.usecases.SearchBookUseCase
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class SearchViewModel(
    private val searchUseCase: SearchBookUseCase
) : ViewModel() {
    private var searchJob: Job? = null
    private val _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Loading(""))
    val uiState = _uiState.asStateFlow()

    fun onIntent(intent: SearchIntent) {
        when (intent) {
            is SearchIntent.OnQueryChange -> {
                _uiState.value = SearchUiState.Loading(intent.query)
                searchJob?.cancel()

                searchJob = viewModelScope.launch {
                    delay(400.milliseconds)

                    searchBooks(intent.query)
                }
            }
        }
    }
    private suspend fun searchBooks(query: String) {
        if (query.isBlank()) {

            _uiState.update {
                SearchUiState.Success(persistentListOf(), query)
            }
            return
        }

            _uiState.value = SearchUiState.Loading(query)
            val result =searchUseCase.invoke(query)
            result.onSuccess { books ->

                val uiBooks = books.map { book -> toUiBook(book) }
                _uiState.update {

                    SearchUiState.Success(uiBooks.toImmutableList(), query)
                }
            }
            result.onError { error ->
                _uiState.update {
                    SearchUiState.Error(error.toString(), query)
                }
            }


    }
}