package com.example.compose101.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel that holds the state of the Composable(s)
class ReverseTextViewModel : ViewModel() {

    // StateList that holds the list of reversed text values
    private val _reversedTextList = mutableStateListOf<String>()
    val reversedTextList: SnapshotStateList<String> = _reversedTextList

    fun onReverseText(text: String) {
        _reversedTextList.add(text.reversed())
    }
}