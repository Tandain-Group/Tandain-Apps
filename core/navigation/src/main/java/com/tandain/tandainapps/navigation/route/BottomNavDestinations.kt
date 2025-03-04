package com.tandain.tandainapps.navigation.route

import kotlinx.serialization.Serializable

interface BottomNavDestinations : Destination {
    @Serializable
    data object HomeScreen : Destination

    @Serializable
    data object MapScreen : Destination

    @Serializable
    data object FinanceScreen : Destination
}
