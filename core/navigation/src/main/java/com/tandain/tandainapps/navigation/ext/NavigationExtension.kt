package com.tandain.tandainapps.navigation.ext

import androidx.navigation.NavController
import androidx.navigation.navOptions

// TODO : Add safe handling (add try catch or if checking or else)
// Make another variant of navigation when there is a specific case needed for the custom NavOptions
fun <T: Any> NavController.generalSafeNavigate(route: T) {
    val generalNavOptions = navOptions {
        // Avoid multiple copies of the same destination when re-selecting the same item
        launchSingleTop = true
        // Restore state when re-selecting a previously selected item
        restoreState = true
    }
    navigate(route, generalNavOptions)
}
