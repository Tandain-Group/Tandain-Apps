package com.tandain.tandainapps.home.presentation

import androidx.lifecycle.viewModelScope
import com.tandain.tandainapps.component.base.viewmodel.BaseViewModel
import com.tandain.tandainapps.home.presentation.dummy.HomeEffect
import com.tandain.tandainapps.home.presentation.dummy.HomeEvent
import com.tandain.tandainapps.home.presentation.dummy.HomeState
import com.tandain.tandainapps.navigation.interfaces.Navigator
import com.tandain.tandainapps.navigation.route.Destination
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(
    navigator: Navigator
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>(navigator) {

    override fun setInitialState(): HomeState = HomeState.initial()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            is HomeEvent.AddName -> addName(event.name)
            HomeEvent.NavToSplash -> navigate(Destination.SplashScreen)
            HomeEvent.Refresh -> refreshData()
        }
    }

    private fun addName(name: String) = viewModelScope.launch {
        val effect = HomeEffect.SuccessAddName(name)
        updateState(effect) {
            it.copy(
                listName = it.listName + name
            )
        }
    }

    private fun refreshData() = viewModelScope.launch {
        delay(2000)
        updateState {
            HomeState.initial()
        }
    }
}
