package com.murattuzel.catchsomezs.internal.util

import android.content.Context
import androidx.startup.Initializer
import com.murattuzel.catchsomezs.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
