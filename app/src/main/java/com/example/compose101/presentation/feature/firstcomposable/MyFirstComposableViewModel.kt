package com.example.compose101.presentation.feature.firstcomposable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyFirstComposableViewModel: ViewModel() {

    private val _counter = MutableLiveData(0)
    val counter: LiveData<Int> = _counter

    fun onButtonClicked() {
        _counter.value = _counter.value?.plus(1)
    }
}