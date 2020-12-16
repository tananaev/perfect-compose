package com.tananaev.perfectcompose.increment

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class IncrementModule(
    private val context: Context,
    private val callback: IncrementPluginCallback,
) {
    @Provides
    fun provideContext() = context

    @Provides
    fun provideIncrementPluginCallback() = callback
}
