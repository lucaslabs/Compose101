package com.example.compose101.presentation.feature.firstcomposable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose101.presentation.feature.firstcomposable.mvi.Intent
import com.example.compose101.presentation.feature.firstcomposable.mvi.State
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MyFirstComposableViewModel : ViewModel() {

    val intent = Channel<Intent>(Channel.UNLIMITED)

    var state by mutableStateOf(State.Counter(value = 0))
        private set

    private var increment = 0

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intent.consumeAsFlow().collect {
                when (it) {
                    is Intent.OnButtonClicked -> incrementCounter()
                }
            }
        }
    }

    private fun incrementCounter() {
        viewModelScope.launch {
            state = state.copy(
                value = ++increment
            )
        }
    }
}