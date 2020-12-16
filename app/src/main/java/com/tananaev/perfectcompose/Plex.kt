package com.tananaev.perfectcompose

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

interface Action

typealias Reducer<State> = (state: State, action: Action) -> State

class Store<State: Any>(val initialState: State, private val reducer: Reducer<State>) {

    private var state = BehaviorSubject.createDefault(initialState)

    fun dispatch(action: Action) {
        state.onNext(reducer(state.value!!, action))
    }

    fun observeState(): Observable<State> = state
}
