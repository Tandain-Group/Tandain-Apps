package com.tandain.tandainapps.navigation.route

import kotlinx.serialization.Serializable

/**
 * List the route for every screen here. This route used as an id for each screen. If you wanted
 * to send some information while navigating, you can follow this 3 scenario:
 *
 * 1. Use data object if there isn't necessary data to be sent when navigating to a certain
 * screen. Ex: data object HomeRoute
 * 2. Use data class if there is small necessary data to be sent when navigating to a certain
 *  screen like a string id. Ex: data class HomeRoute(id: String)
 * 3. Use shared view model or local storage if the data is big like an enormous json object.
 */

@Serializable data object HomeRoute

@Serializable data object SplashScreenRoute
