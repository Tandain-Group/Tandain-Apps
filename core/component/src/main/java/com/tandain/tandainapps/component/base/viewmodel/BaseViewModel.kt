package com.tandain.tandainapps.component.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptionsBuilder
import com.tandain.tandainapps.navigation.interfaces.Navigator
import com.tandain.tandainapps.navigation.route.Destination
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

interface ViewState
interface ViewEvent
interface ViewEffect

abstract class BaseViewModel<State : ViewState, Event : ViewEvent, Effect : ViewEffect>(
    private val navigator: Navigator
) : ViewModel() {

    protected abstract fun setInitialState(): State
    protected abstract fun handleEvents(event: Event)

    private val initialState: State by lazy { setInitialState() }
    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()

    private val _effects = Channel<Effect>()
    val effect = _effects.receiveAsFlow()

    /**
     * Optional variable for debugging data states
     */
    val timeCapsule: TimeCapsule<State> = TimeTravelCapsule { storedState ->
        _state.tryEmit(storedState)
    }

    init {
        subscribeToEvents()
        timeCapsule.addState(initialState)
    }

    private fun subscribeToEvents() = viewModelScope.launch {
        _event.collect {
            handleEvents(it)
        }
    }

    fun sendEffect(effect: Effect) = viewModelScope.launch {
        _effects.send(effect)
    }

    fun sendEvent(event: Event) = viewModelScope.launch {
        _event.emit(event)
    }

    fun updateState(effect: Effect? = null, updates: (State) -> State) = viewModelScope.launch {
        val newState = updates(state.value)
        val success = _state.tryEmit(newState)
        if (success) {
            timeCapsule.addState(newState)
        }
        effect?.let { sendEffect(it) }
    }

    fun navigate(
        route: Destination,
        builder: NavOptionsBuilder.() -> Unit = {}
    ) = viewModelScope.launch(Dispatchers.Main) {
        navigator.navigate(destination = route, navOptions = builder)
    }
}
