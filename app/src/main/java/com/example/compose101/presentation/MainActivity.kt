package com.example.compose101.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.compose101.presentation.feature.firstcomposable.MyFirstComposableScreen
import com.example.compose101.presentation.feature.firstcomposable.MyFirstComposableViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MyFirstComposableViewModel by viewModels()

//    private val viewModel: ReverseTextViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Main entry point for Compose
        setContent {
            MyFirstComposableScreen(viewModel)

            // Second example with LazyList and StateList
//            Compose101Theme {
//                ReverseTextScreen(viewModel = viewModel)
//            }
        }
    }
}