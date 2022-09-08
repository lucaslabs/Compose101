package com.example.compose101.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose101.R
import com.example.compose101.presentation.theme.Compose101Theme
import com.example.compose101.presentation.theme.Large
import com.example.compose101.presentation.theme.Medium
import com.example.compose101.presentation.theme.Small

// Composable functions are the fundamental building blocks of an application built with Compose.
// Composable functions can receive data, use the data to create the UI and then emit UI components
// that users see on the screen.
@Composable
fun ReverseTextScreen(viewModel: ReverseTextViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Starts observing this StateList and represents its values via State.
        // Every time there would be new value posted into the StateList
        // the returned State will be updated causing recomposition of every State value usage.
        val reversedTextList: SnapshotStateList<String> = viewModel.reversedTextList

        val paddingModifier = Modifier
            .padding(horizontal = Large, vertical = Medium)
            .fillMaxWidth()

        ReversedTextSection(
            onClick = { viewModel.onReverseText(it) },
            modifier = paddingModifier
        )

        InputTextListSection(
            textList = reversedTextList,
            modifier = paddingModifier
        )
    }
}

@Composable
fun ReversedTextSection(
    onClick: (String) -> Unit,
    modifier: Modifier
) {
    // This is a Composable with a state, aka, Stateful Composable
    // because it's holding its own state within its body function.

    // 1. remember is a composable that returns the value produced during the composition.
    // During recomposition, it will always return the value produced by composition.
    // 2. mutableStateOf is an observable value and updates to this variable
    // will redraw all the composable functions that access it.
    var inputTextState: String by remember { mutableStateOf(value = "") }

    // TextField is a Stateless composable
    TextField(
        value = inputTextState, // State
        onValueChange = { inputTextState = it }, // Handling state changes
        label = { Text(text = stringResource(id = R.string.enter_text)) },
        modifier = modifier
    )

    Button(
        onClick = { onClick(inputTextState) },
        modifier = modifier
    ) {
        Text(text = stringResource(id = R.string.reverse_text))
    }
}

@Composable
fun InputTextListSection(textList: List<String>, modifier: Modifier) {
    // This is a Composable without a state, aka, Stateless Composable
    // because it's receiving a state (textList) as parameter.
    // It also could receive a parameter/lambda to handle the state changes.

    Text(
        text = stringResource(id = R.string.reversed_text_list),
        modifier = modifier
    )

    LazyColumn(modifier = modifier) {
        items(items = textList) { text ->
            InputTextItem(text = text)
        }
    }
}

@Composable
fun InputTextItem(text: String) {
    Text(text = text, Modifier.padding(vertical = Small))
    Divider(color = Color.Black)
}

@Preview(
    name = "portrait",
    showBackground = true,
    device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480"
)
@Preview(
    name = "landscape",
    showBackground = true,
    device = "spec:shape=Normal,width=640,height=360,unit=dp,dpi=480"
)
@Preview(
    name = "foldable",
    showBackground = true,
    device = "spec:shape=Normal,width=673,height=841,unit=dp,dpi=480"
)
@Preview(
    name = "tablet",
    showBackground = true,
    device = "spec:shape=Normal,width=1280,height=800,unit=dp,dpi=480"
)
@Composable
fun Preview() {
    Compose101Theme(darkTheme = false) {
        ReverseTextScreen(ReverseTextViewModel())
    }
}