package com.tandain.tandainapps.initilizer

import android.content.Context
import androidx.startup.Initializer

/**
 * Class to initialize dependency efficiently before the app started.
 * TODO: Add database initiation
 */
class CommonInitializer : Initializer<Unit> {
    override fun create(context: Context) {}
    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(
        KoinInitializer::class.java
    )
}
