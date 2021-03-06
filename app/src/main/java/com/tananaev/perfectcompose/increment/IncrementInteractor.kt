package com.tananaev.perfectcompose.increment

import android.util.Log
import androidx.compose.runtime.CompositionLifecycleObserver
import com.tananaev.perfectcompose.Action
import com.tananaev.perfectcompose.Store
import javax.inject.Inject

data class IncrementState(val count: Int)

object ActionIncrement : Action

class IncrementInteractor @Inject constructor(
    private val incrementService: IncrementService,
    private val callback: IncrementPluginCallback,
) : CompositionLifecycleObserver {
    private val store = Store(IncrementState(0), ::reduce)

    private fun reduce(state: IncrementState, action: Action): IncrementState {
        return if (action == ActionIncrement) {
            val updatedCount = incrementService.increment(state.count)
            callback.onResult(updatedCount)
            state.copy(count = updatedCount)
        } else {
            state
        }
    }

    fun increment() {
        store.dispatch(ActionIncrement)
    }

    fun initialState() = store.initialState

    fun observeState() = store.observeState()

    override fun onEnter() {
        Log.d(IncrementInteractor::class.simpleName, "attached")
    }

    override fun onLeave() {
        Log.d(IncrementInteractor::class.simpleName, "detached")
    }
}
