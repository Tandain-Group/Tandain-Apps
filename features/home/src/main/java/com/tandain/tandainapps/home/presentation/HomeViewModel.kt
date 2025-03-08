package com.tandain.tandainapps.home.presentation

import androidx.lifecycle.viewModelScope
import com.tandain.tandainapps.component.base.viewmodel.BaseViewModel
import com.tandain.tandainapps.home.presentation.dummy.HomeEffect
import com.tandain.tandainapps.home.presentation.dummy.HomeEvent
import com.tandain.tandainapps.home.presentation.dummy.HomeScreenReducer
import com.tandain.tandainapps.home.presentation.dummy.HomeState
import com.tandain.tandainapps.navigation.interfaces.Navigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(
    navigator: Navigator
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>(
    initialState = HomeState.initial(),
    reducer = HomeScreenReducer(),
    navigator = navigator
) {

    fun fetchApi() = viewModelScope.launch {
        delay(2000)
        sendEvent(HomeEvent.Refresh)
    }
}
