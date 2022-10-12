package com.example.compose101.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    @Composable
    fun ClickTheButton() {
        val counter = remember { mutableStateOf(0) }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "Button clicked ${counter.value} times")
            Button(onClick = { counter.value++ }) {
                Text(text = "Click me")
            }
        }
    }

    // TODO Show a preview
    @Composable
    fun Preview() {
        ClickTheButton()
    }
}