package com.tananaev.perfectcompose.increment

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class IncrementModule(private val context: Context) {
    @Provides
    fun provideContext() = context
}
