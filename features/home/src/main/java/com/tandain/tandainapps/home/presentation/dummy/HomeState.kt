package com.tandain.tandainapps.home.presentation.dummy

import androidx.compose.runtime.Immutable
import com.tandain.tandainapps.component.base.viewmodel.ViewState

@Immutable
data class HomeState(
    val title: String = "",
    val description: String = "",
    val listName: List<String> = listOf()
) : ViewState {

    companion object {
        fun initial() = HomeState("title", "description", listOf("Lutfi", "Megi"))
    }
}