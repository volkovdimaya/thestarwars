package com.dima.thestarwars.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Content<T>(val data: T) : UiState<T>()
    object NoData : UiState<Nothing>()
}

abstract class CommonViewModel<T> : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<T>>(UiState.Loading)
    val uiState: StateFlow<UiState<T>> = _uiState.asStateFlow()

    fun setLoading() {
        _uiState.value = UiState.Loading
    }

    fun setContent(data: T) {
        _uiState.value = UiState.Content(data)
    }
    fun setNoData() {
        _uiState.value = UiState.NoData
    }

    fun loadContent(loader: suspend () -> T) {
        viewModelScope.launch {
            setLoading()
            val result = loader()
            _uiState.value = UiState.Content(result)
        }
    }
}