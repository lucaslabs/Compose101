package com.example.compose101.presentation.feature.firstcomposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose101.presentation.feature.firstcomposable.mvi.Intent
import com.example.compose101.presentation.feature.firstcomposable.mvi.State
import kotlinx.coroutines.launch

@Composable
fun MyFirstComposableScreen(viewModel: MyFirstComposableViewModel) {
    val state = viewModel.state

    val scope = rememberCoroutineScope()

    MyFirstComposable(
        state = state,
        onValueChanged = {
            scope.launch {
                viewModel.intent.send(Intent.OnButtonClicked)
            }
        }
    )
}

@Composable
fun MyFirstComposable(state: State, onValueChanged: () -> Unit) {
    when (state) {
        is State.Counter -> {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text("Button clicked ${state.value} times")
                Button(onClick = onValueChanged) {
                    Text(text = "Click me")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MyFirstComposable(State.Counter(value = 0), onValueChanged = {})
}