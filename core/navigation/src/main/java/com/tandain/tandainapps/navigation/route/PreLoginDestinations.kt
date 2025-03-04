package com.tandain.tandainapps.navigation.route

import kotlinx.serialization.Serializable

interface PreLoginDestinations : Destination {
    @Serializable
    data object LoginScreen : Destination

    @Serializable
    data object OTPScreen : Destination

    @Serializable
    data object RegisterScreen : Destination
}
