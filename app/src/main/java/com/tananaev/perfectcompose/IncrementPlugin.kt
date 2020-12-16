package com.tananaev.perfectcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.rxjava2.subscribeAsState

data class IncrementState(val count: Int)

object ActionIncrement : Action

fun incrementReducer(state: IncrementState, action: Action): IncrementState {
    return if (action == ActionIncrement) {
        state.copy(count = state.count + 1)
    } else {
        state
    }
}

@Composable
fun IncrementPlugin() {
    val store = remember { Store(IncrementState(0), ::incrementReducer) }
    val state by store.observeState().subscribeAsState(store.initialState)
    Row {
        BasicText(text = "${state.count}")
        Button(onClick = { store.dispatch(ActionIncrement) }) {
            BasicText(text = "Increment")
        }
    }
}
