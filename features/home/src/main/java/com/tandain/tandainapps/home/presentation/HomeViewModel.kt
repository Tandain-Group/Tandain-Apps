package com.tandain.tandainapps.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tandain.tandainapps.home.model.HomeUiEvent
import com.tandain.tandainapps.navigation.interfaces.Navigator
import com.tandain.tandainapps.navigation.route.BottomNavDestinations
import com.tandain.tandainapps.navigation.route.Destination
import kotlinx.coroutines.launch

class HomeViewModel(
    private val navigator: Navigator
) : ViewModel() {
    fun navigationHandler(uiEvents: HomeUiEvent) = viewModelScope.launch {
        when (uiEvents) {
            // TODO: Adjust based on necessary navigation. This is for example only
            HomeUiEvent.NavigateToSplashScreen -> {
                navigator.navigate(destination = Destination.SplashScreen) {
                    popUpTo(BottomNavDestinations.HomeScreen) { inclusive = true }
                }
            }
            else -> {}
        }
    }
}
