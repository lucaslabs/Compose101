package com.example.compose101.presentation.feature.firstcomposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyFirstComposableScreen(viewModel: MyFirstComposableViewModel) {
    val counter = viewModel.counter.observeAsState(initial = 0)

    MyFirstComposable(
        value = counter.value,
        onValueChanged = { viewModel.onButtonClicked() }
    )
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