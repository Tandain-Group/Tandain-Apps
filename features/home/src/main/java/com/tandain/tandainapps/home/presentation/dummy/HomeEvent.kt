package com.tandain.tandainapps.home.presentation.dummy

import androidx.compose.runtime.Immutable
import com.tandain.tandainapps.component.base.viewmodel.ViewEvent

@Immutable
sealed class HomeEvent : ViewEvent {
    data object Refresh : HomeEvent()
    data class AddName(val name: String) : HomeEvent()
    data object NavToSplash : HomeEvent()
}