package com.tandain.tandainapps.home.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.tandain.tandainapps.home.presentation.dummy.HomeEffect
import com.tandain.tandainapps.home.presentation.dummy.HomeEvent
import com.tandain.tandainapps.navigation.route.Destination
import kotlinx.coroutines.flow.Flow


@Composable
fun <T> rememberFlowWithLifecycle(
    flow: Flow<T>,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): Flow<T> = remember(flow, lifecycle) {
    flow.flowWithLifecycle(
        lifecycle = lifecycle,
        minActiveState = minActiveState
    )
}

// TODO: Add actual implementation
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val effect = rememberFlowWithLifecycle(viewModel.effect)

    val context = LocalContext.current

    LaunchedEffect(effect) {
        effect.collect { action ->
            when (action) {
                is HomeEffect.SuccessAddName -> {
                    Toast.makeText(context, "Berhasil Nambah ${action.name}", Toast.LENGTH_SHORT)
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "This is HomeScreen")
            Button(onClick = { viewModel.navigate(route = Destination.SplashScreen) }) {
                Text(text = "Click me!")
            }
            Spacer(modifier = Modifier.height(100.dp))
            LazyColumn {
                items(state.value.listName.size) {
                    Text(text = state.value.listName[it])
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { viewModel.sendEvent(HomeEvent.AddName("RTA")) }) {
                Text(text = "Add Name")
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { viewModel.fetchApi() }) {
                Text(text = "Refresh")
            }
        }
    }
}

// TODO: Move to splashscreen module and add actual implementation
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "This is SplashScreen")
            Button(onClick = {}) {
                Text(text = "Click me!")
            }
        }
    }
}
