package com.tandain.tandainapps.home.presentation.dummy

import com.tandain.tandainapps.component.base.viewmodel.Reducer

class HomeScreenReducer : Reducer<HomeState, HomeEvent, HomeEffect> {
    override fun reduce(
        previousState: HomeState,
        event: HomeEvent
    ): Pair<HomeState, HomeEffect?> {
        return when (event) {
            is HomeEvent.AddName -> previousState.copy(
                listName = previousState.listName + event.name
            ) to HomeEffect.SuccessAddName(event.name)

            HomeEvent.Refresh -> HomeState.initial() to null
        }
    }

}