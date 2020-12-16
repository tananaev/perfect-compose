package com.tananaev.perfectcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.runtime.*

@Composable
fun DecrementPlugin() {
    var count by remember { mutableStateOf(0) }
    Row {
        BasicText(text = "$count")
        Button(onClick = { count -= 1 }) {
            BasicText(text = "Decrement")
        }
    }
}
