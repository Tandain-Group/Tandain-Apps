package com.tandain.tandainapps.home.model

sealed class HomeUiEvent {
    // TODO: Adjust based on necessary navigation. This is for example only
    data object NavigateToSplashScreen : HomeUiEvent()
    data object NavigateToMapScreen : HomeUiEvent()
}
