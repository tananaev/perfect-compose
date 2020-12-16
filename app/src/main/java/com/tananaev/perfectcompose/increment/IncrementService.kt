package com.tananaev.perfectcompose.increment

import android.content.Context
import com.tananaev.perfectcompose.NetworkService
import javax.inject.Inject

class IncrementService @Inject constructor(
    private val context: Context,
    private val networkService: NetworkService,
) {
    fun increment(count: Int): Int {
        context.assets
        networkService.foo()
        return count + 1
    }
}
