package com.example.compose101.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.compose101.presentation.theme.Compose101Theme

class MainActivity : ComponentActivity() {

    private val viewModel: ReverseTextViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Main entry point for Compose
        setContent {
            Compose101Theme {
                ReverseTextScreen(viewModel)
            }
        }
    }
}