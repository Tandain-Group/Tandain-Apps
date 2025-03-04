package com.tandain.tandainapps.navigation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import com.tandain.tandainapps.navigation.utils.DeepLinkConstant.DEEP_LINK_SCHEME_AND_HOST
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

object NavHelper {
    fun String.toDeeplinkBasePath() : String {
        return "$DEEP_LINK_SCHEME_AND_HOST/$this"
    }
}

/**
 * This function is collected observable flow for single live event
 * Single live event in flow can use ChannelFlow or SharedFlow
 *
 * @param flow The Flow to be observed.
 * @param key1 Optional recomposition key to restart collection when changed.
 * @param key2 Another optional recomposition key.
 * @param onEvent Callback function triggered for each emitted value.
 */
@Composable
fun <T> ObserveAsEvents(
    flow: Flow<T>,
    key1: Any? = null,
    key2: Any? = null,
    onEvent: (T) -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(key1 = lifecycleOwner.lifecycle, key1, key2) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            withContext(Dispatchers.Main.immediate) {
                flow.collect(onEvent)
            }
        }
    }
}
