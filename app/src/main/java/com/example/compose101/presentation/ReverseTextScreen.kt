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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose101.R
import com.example.compose101.presentation.theme.Compose101Theme
import com.example.compose101.presentation.theme.Large
import com.example.compose101.presentation.theme.Medium
import com.example.compose101.presentation.theme.Small

// Composable functions are the fundamental building blocks of an application built with Compose.
@Composable
fun ReverseTextScreen(viewModel: ReverseTextViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Starts observing this LiveData and represents its values via State.
        // Every time there would be new value posted into the LiveData
        // the returned State will be updated causing recomposition of every State.value usage.
        val reversedTextState: State<String> = viewModel.reversedText.observeAsState("")

        val inputTextListState: State<List<String>> =
            viewModel.inputTextList.observeAsState(initial = emptyList())

        val paddingModifier = Modifier
            .padding(horizontal = Large, vertical = Medium)
            .fillMaxWidth()

        ReversedTextSection(
            text = reversedTextState.value,
            onTextValueChange = { text -> viewModel.onTextValueChange(text) },
            modifier = paddingModifier
        )

        InputTextListSection(
            textList = inputTextListState.value,
            modifier = paddingModifier
        )
    }
}

@Composable
fun ReversedTextSection(
    text: String, // State
    onTextValueChange: (String) -> Unit, // Handles state changes
    modifier: Modifier,
) {

    // 1. remember is a composable that returns the value produced during the composition.
    // During recomposition, it will always return the value produced by composition.
    // 2. mutableStateOf is an observable value and updates to this variable
    // will redraw all the composable functions that access it.
    var inputTextState: String by remember { mutableStateOf(value = "") }

    Text(
        text = stringResource(id = R.string.reversed_text, text),
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )

    TextField(
        value = inputTextState,
        onValueChange = { inputTextState = it },
        label = { Text(text = stringResource(id = R.string.enter_text)) },
        modifier = modifier
    )

    Button(
        onClick = { onTextValueChange(inputTextState) },
        modifier = modifier
    ) {
        Text(text = stringResource(id = R.string.reverse_text))
    }
}

@Composable
fun InputTextListSection(textList: List<String>, modifier: Modifier) {
    Text(
        text = stringResource(id = R.string.original_input_list),
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