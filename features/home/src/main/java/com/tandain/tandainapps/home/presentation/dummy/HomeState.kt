package com.tandain.tandainapps.home.presentation.dummy

import androidx.compose.runtime.Immutable
import com.tandain.tandainapps.component.base.viewmodel.Reducer

@Immutable
data class HomeState(
    val title: String = "",
    val description: String = "",
    val listName: List<String> = listOf()
) : Reducer.ViewState {

    companion object {
        fun initial() = HomeState("title", "description", listOf("Lutfi", "Megi"))
    }
}