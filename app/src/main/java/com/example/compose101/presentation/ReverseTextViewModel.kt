package com.example.compose101.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReverseTextViewModel : ViewModel() {

    // LiveData to hold reversedText value
    private val _reversedText = MutableLiveData<String>()
    val reversedText: LiveData<String> = _reversedText

    // LiveData to hold the list of input text value
    private val _inputTextList = MutableLiveData<List<String>>()
    val inputTextList: LiveData<List<String>> = _inputTextList

    // Mutable list to allow adding new input text values
    private val textList = mutableListOf<String>()

    fun onTextValueChange(text: String) {
        textList.add(text)
        _inputTextList.value = textList

        _reversedText.value = text.reversed()
    }
}