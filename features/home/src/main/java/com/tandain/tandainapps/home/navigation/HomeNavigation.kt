package com.tandain.tandainapps.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.tandain.tandainapps.home.di.loadHomeModule
import com.tandain.tandainapps.home.presentation.HomeScreen
import com.tandain.tandainapps.home.presentation.HomeViewModel
import com.tandain.tandainapps.home.presentation.SplashScreen
import com.tandain.tandainapps.navigation.route.BottomNavDestinations
import com.tandain.tandainapps.navigation.route.Destination
import com.tandain.tandainapps.navigation.utils.DeepLinkConstant
import com.tandain.tandainapps.navigation.utils.NavHelper.toDeeplinkBasePath
import org.koin.androidx.compose.koinViewModel

/**
 *  The Home section of the app.
 */
fun NavGraphBuilder.homeSection() {
    loadHomeModule()
    navigation<Destination.BottomNavGraph>(startDestination = BottomNavDestinations.HomeScreen) {
        composable<BottomNavDestinations.HomeScreen>(
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = DeepLinkConstant.DL_PATH_HOME.toDeeplinkBasePath()
                },
            ),
        ) {
            HomeScreen(viewModel = koinViewModel<HomeViewModel>())
        }
    }
}

// TODO: Remove this. Move to splashscreen module
fun NavGraphBuilder.splashScreenSection() {
    composable<Destination.SplashScreen>() {
        SplashScreen()
    }
}
