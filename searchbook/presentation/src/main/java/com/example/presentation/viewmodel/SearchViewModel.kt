package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.presentation.model.SearchIntent
import com.example.presentation.model.SearchUiState
import com.example.searchbook.domain.SearchRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

import com.example.core.domain.model.result.onError
import com.example.core.domain.model.result.onSuccess
class SearchViewModel(
    private val searchRepo: SearchRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState = _uiState.asStateFlow()

    fun onIntent(intent: SearchIntent) {
        when (intent) {
            is SearchIntent.OnQueryChange -> {
                searchBooks(intent.query)
            }
        }
    }

    private fun searchBooks(query: String) {
        if (query.isBlank()) {
            _uiState.update {
                it.copy(
                    query = query,
                    books = emptyList(),
                    isLoading = false,
                    error = null
                )
            }
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(query = query, isLoading = true,error = null)
            val result =searchRepo.searchBooks(query)
            result.onSuccess { books ->
                _uiState.update {

                    Log.d("book search  view model karen", "search view model working")
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