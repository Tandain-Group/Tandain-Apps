package com.tandain.tandainapps.home.presentation.dummy

import androidx.compose.runtime.Immutable
import com.tandain.tandainapps.component.base.viewmodel.Reducer


@Immutable
sealed class HomeEffect : Reducer.ViewEffect {
    data class SuccessAddName(val name: String) : HomeEffect()
}