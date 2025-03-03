package com.tandain.tandainapps.navigation.impl

import androidx.navigation.NavOptionsBuilder
import com.tandain.tandainapps.navigation.interfaces.NavigationAction
import com.tandain.tandainapps.navigation.interfaces.Navigator
import com.tandain.tandainapps.navigation.route.Destination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * A global navigation that starts from pre-login graph
 */
class NavigatorImpl(
    // TODO: Adjust later with the actual start destination
    override val startDestination: Destination = Destination.BottomNavGraph
) : Navigator {
    private val _navigationActions = Channel<NavigationAction>()
    override val navigationActions = _navigationActions.receiveAsFlow()

    override suspend fun navigate(destination: Destination, navOptions: NavOptionsBuilder.() -> Unit) {
        _navigationActions.send(NavigationAction.Navigate(destination, navOptions))
    }

    override suspend fun navigateUp() {
        _navigationActions.send(NavigationAction.NavigateUp)
    }
}
