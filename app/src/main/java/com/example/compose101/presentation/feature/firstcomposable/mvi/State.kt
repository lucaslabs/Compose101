package com.example.compose101.presentation.feature.firstcomposable.mvi

sealed class State {
    data class Counter(val value: Int) : State()
}
