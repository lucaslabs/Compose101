package com.example.compose101.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.compose101.presentation.theme.Compose101Theme

class MainActivity : ComponentActivity() {

    val viewModel: ReverseTextViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose101Theme {
                ReverseTextScreen(viewModel)
            }
        }
    }
}