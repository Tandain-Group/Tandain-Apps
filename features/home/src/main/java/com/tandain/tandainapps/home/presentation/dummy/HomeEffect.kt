package com.tandain.tandainapps.home.presentation.dummy

import androidx.compose.runtime.Immutable
import com.tandain.tandainapps.component.base.viewmodel.ViewEffect


@Immutable
sealed class HomeEffect : ViewEffect {
    data class SuccessAddName(val name: String) : HomeEffect()
}