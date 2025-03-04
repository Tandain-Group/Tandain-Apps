package com.tandain.tandainapps.initilizer

import android.content.Context
import androidx.startup.Initializer
import com.tandain.tandainapps.di.loadAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        startKoin {
            androidLogger()
            androidContext(context.applicationContext)
        }
        loadAppModule()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
