package com.tandain.tandainapps.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tandain.tandainapps.home.navigation.homeSection
import com.tandain.tandainapps.home.navigation.splashScreenSection
import com.tandain.tandainapps.navigation.ext.generalSafeNavigate
import com.tandain.tandainapps.navigation.route.HomeRoute

@Composable
fun TandainNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier
    ) {
        homeSection(useNavigate = navController::generalSafeNavigate)
        splashScreenSection(useNavigate = navController::generalSafeNavigate)
    }
}
