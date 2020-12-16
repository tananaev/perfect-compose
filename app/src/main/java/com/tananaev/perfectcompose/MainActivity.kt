package com.tananaev.perfectcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
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
    Column {
        IncrementPlugin()
        DecrementPlugin()
        BasicText(text = "Sum ${0}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PerfectComposeTheme {
        MainScreen()
    }
}
