package com.tandain.tandainapps.home.presentation.dummy

import androidx.compose.runtime.Immutable
import com.tandain.tandainapps.component.base.viewmodel.Reducer

@Immutable
sealed class HomeEvent: Reducer.ViewEvent {
    data object Refresh: HomeEvent()
    data class AddName(val name: String) : HomeEvent()
}