package com.example.compose101.presentation.feature.reversetext

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel that holds the state of the Composable(s)
class ReverseTextViewModel : ViewModel() {

    // LiveData that holds the last reversed text value
    private val _reversedText = MutableLiveData<String>()
    val reversedText: LiveData<String> = _reversedText

    // StateList that holds a list of reversed text values
    private val _reversedTextList = mutableStateListOf<String>()
    val reversedTextList: SnapshotStateList<String> = _reversedTextList

    fun onReverseText(text: String) {
        val reverseStr = text.reversed()
        _reversedText.value = reverseStr
        _reversedTextList.add(reverseStr)
    }
}