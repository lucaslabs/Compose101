package com.example.compose101.presentation.feature.firstcomposable

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

    var state = MutableStateFlow<State>(State.Counter(value = 0))
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
            // TODO data class for the state to call update fun?
            state.value = State.Counter(++increment)
        }
    }
}