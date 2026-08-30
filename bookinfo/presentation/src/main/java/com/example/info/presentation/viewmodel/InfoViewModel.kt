package com.example.info.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.result.onError
import com.example.core.domain.model.result.onSuccess
import com.example.info.domain.usecases.InfoBookUseCase
import com.example.info.presentation.model.InfoIntent
import com.example.info.presentation.model.InfoUiState
import com.example.info.presentation.model.bookInfoMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InfoViewModel(
    private val infoBookUseCase: InfoBookUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(InfoUiState())
    val uiState: StateFlow<InfoUiState> = _uiState.asStateFlow()
    fun onIntent(intent: InfoIntent) {
        when (intent) {
            is InfoIntent.onLoadPage -> {
                loadPage(intent.bookId)

            }
        }
    }

    fun loadPage(bookId: String) {
        viewModelScope.launch {
            val result = infoBookUseCase.invoke(bookId)

            result.onSuccess { book ->
                val uiBook = bookInfoMapper(book)
                _uiState.value = _uiState.value.copy(book = uiBook, isLoading = false, error = null)
            }
            result.onError { error ->
                _uiState.value = _uiState.value.copy(isLoading = false, error = error.toString())
            }
        }
    }
}

