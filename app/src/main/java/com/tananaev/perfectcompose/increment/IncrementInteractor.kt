package com.tananaev.perfectcompose.increment

import com.tananaev.perfectcompose.Action
import com.tananaev.perfectcompose.Store
import javax.inject.Inject

data class IncrementState(val count: Int)

object ActionIncrement : Action

class IncrementInteractor @Inject constructor(
    private val incrementService: IncrementService,
) {
    private val store = Store(IncrementState(0), ::reduce)

    private fun reduce(state: IncrementState, action: Action): IncrementState {
        return if (action == ActionIncrement) {
            state.copy(count = incrementService.increment(state.count))
        } else {
            state
        }
    }

    fun increment() {
        store.dispatch(ActionIncrement)
    }

    fun initialState() = store.initialState

    fun observeState() = store.observeState()
}
