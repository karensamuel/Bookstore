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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InfoViewModel(
    private val infoBookUseCase: InfoBookUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<InfoUiState>(InfoUiState.Loading)
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
            _uiState.update {
                InfoUiState.Loading
            }
            val result = infoBookUseCase.invoke(bookId)

            result.onSuccess { book ->

                _uiState.update {
                    val uiBook = bookInfoMapper(book)
                    InfoUiState.Success(uiBook)
                }
            }
            result.onError { error ->
                _uiState.update {
                    InfoUiState.Error("$error")
                }
            }
        }
    }
}

