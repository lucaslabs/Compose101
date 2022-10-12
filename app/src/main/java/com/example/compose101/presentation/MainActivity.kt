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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose101.presentation.theme.Compose101Theme

class MainActivity : ComponentActivity() {

//    private val viewModel: ReverseTextViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Main entry point for Compose
        setContent {
            var counter by remember { mutableStateOf(0) }

            MyFirstComposable(
                value = counter,
                onValueChanged = { counter++ }
            )

            // Advanced example
//            Compose101Theme {
//                ReverseTextScreen(viewModel = viewModel)
//            }
        }
    }

    @Composable
    fun MyFirstComposable(value: Int, onValueChanged: () -> Unit) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text("Button clicked $value times")
            Button(onClick = onValueChanged) {
                Text(text = "Click me")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        MyFirstComposable(value = 0, onValueChanged = {})
    }
}