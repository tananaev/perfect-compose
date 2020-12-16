package com.tananaev.perfectcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.tananaev.perfectcompose.increment.IncrementPlugin
import com.tananaev.perfectcompose.ui.PerfectComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfectComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var incrementAttached by remember { mutableStateOf(true) }
    var decrementAttached by remember { mutableStateOf(true) }

    Column {
        Button(onClick = { incrementAttached = !incrementAttached }) {
            BasicText(text = "Increment Plugin Toggle")
        }
        Button(onClick = { decrementAttached = !decrementAttached }) {
            BasicText(text = "Decrement Plugin Toggle")
        }
        if (incrementAttached) {
            IncrementPlugin()
        }
        if (decrementAttached) {
            DecrementPlugin()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PerfectComposeTheme {
        MainScreen()
    }
}
