package com.tandain.tandainapps.di

import com.tandain.tandainapps.navigation.impl.NavigatorImpl
import com.tandain.tandainapps.navigation.interfaces.Navigator
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun loadAppModule() {
    loadKoinModules(
        listOf(
           appNavigationModule
        )
    )
}

val appNavigationModule = module {
    single<Navigator> { NavigatorImpl() }
}
