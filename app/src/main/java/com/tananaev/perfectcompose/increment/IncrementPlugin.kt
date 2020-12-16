package com.tananaev.perfectcompose.increment

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.rxjava2.subscribeAsState
import androidx.compose.ui.platform.AmbientContext
import dagger.Component

@Component(modules = [IncrementModule::class])
interface IncrementPluginComponent {
    fun interactor(): IncrementInteractor
}

@Composable
fun IncrementPlugin() {
    val context = AmbientContext.current
    val interactor = remember(context) {
        DaggerIncrementPluginComponent.builder()
            .incrementModule(IncrementModule(context))
            .build()
            .interactor()
    }
    val state by interactor.observeState().subscribeAsState(interactor.initialState())

    Row {
        BasicText(text = "${state.count}")
        Button(onClick = { interactor.increment() }) {
            BasicText(text = "Increment")
        }
    }
}
