package com.tandain.tandainapps.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tandain.tandainapps.home.navigation.homeSection
import com.tandain.tandainapps.home.navigation.splashScreenSection
import com.tandain.tandainapps.navigation.interfaces.NavigationAction
import com.tandain.tandainapps.navigation.interfaces.Navigator
import com.tandain.tandainapps.navigation.utils.ObserveAsEvents
import org.koin.compose.koinInject

@Composable
fun TandainNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navigator = koinInject<Navigator>()
    ObserveAsEvents(flow = navigator.navigationActions) { action ->
        when (action) {
            is NavigationAction.Navigate -> navController.navigate(action.destination) {
                // TODO: Add safe navigation
                action.navOptions(this)
            }
            NavigationAction.NavigateUp -> navController.navigateUp()
        }
    }
    NavHost(
        navController = navController,
        startDestination = navigator.startDestination,
        modifier = modifier
    ) {
        // Add the list of screen here
        homeSection()
        splashScreenSection()
    }
}
