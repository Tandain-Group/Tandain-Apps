package com.tandain.tandainapps.component.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptionsBuilder
import com.tandain.tandainapps.navigation.interfaces.Navigator
import com.tandain.tandainapps.navigation.route.Destination
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    private val navigator: Navigator
): ViewModel() {
    /**
     * Navigates to the specified destination using the provided navigation options.
     *
     * @param route The destination to navigate to.
     * @param builder Optional configuration for navigation options.
     */
    fun navigate(
        route: Destination,
        builder: NavOptionsBuilder.() -> Unit = {}
    ) = viewModelScope.launch(Dispatchers.Main) {
        navigator.navigate(destination = route, navOptions = builder)
    }
}
