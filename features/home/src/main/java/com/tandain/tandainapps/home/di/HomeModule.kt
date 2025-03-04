package com.tandain.tandainapps.home.di

import com.tandain.tandainapps.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal fun loadHomeModule() {
    loadKoinModules(
        listOf(
            homeViewModelModule
        )
    )
}

private val homeViewModelModule = module {
    viewModelOf(::HomeViewModel)
}
