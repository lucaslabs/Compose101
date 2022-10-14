package com.example.compose101.presentation.feature.firstcomposable.mvi

sealed class Intent {
    object OnButtonClicked : Intent()
}
