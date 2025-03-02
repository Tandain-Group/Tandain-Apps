package com.tandain.tandainapps.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.tandain.tandainapps.home.presentation.HomeScreen
import com.tandain.tandainapps.home.presentation.SplashScreen
import com.tandain.tandainapps.navigation.route.HomeRoute
import com.tandain.tandainapps.navigation.route.SplashScreenRoute
import com.tandain.tandainapps.navigation.utils.DeepLinkConstant
import com.tandain.tandainapps.navigation.utils.NavHelper.toDeeplinkBasePath

/**
 *  The Home section of the app.
 *
 *  @param useNavigate - used when there is a need to use navigation by child component.
 */
fun NavGraphBuilder.homeSection(
    useNavigate: (route: Any) -> Unit = {}
) {
    composable<HomeRoute>(
        deepLinks = listOf(
            navDeepLink {
                uriPattern = DeepLinkConstant.DL_PATH_HOME.toDeeplinkBasePath()
            },
        ),
    ) {
        HomeScreen(
            onButtonClick = useNavigate
        )
    }
}

// TODO: Move to splashscreen module
fun NavGraphBuilder.splashScreenSection(
    useNavigate: (route: Any) -> Unit = {}
) {
    composable<SplashScreenRoute>(
        deepLinks = listOf(
            navDeepLink {
                uriPattern = DeepLinkConstant.DL_PATH_SPLASHSCREEN.toDeeplinkBasePath()
            },
        ),
    ) {
        SplashScreen(
            onButtonClick = useNavigate
        )
    }
}
