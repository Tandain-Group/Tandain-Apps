package com.tandain.tandainapps.navigation.interfaces

import androidx.navigation.NavOptionsBuilder
import com.tandain.tandainapps.navigation.route.Destination

sealed interface NavigationAction {
    data class Navigate(
        val destination: Destination,
        val navOptions: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationAction

    data object NavigateUp : NavigationAction
}
