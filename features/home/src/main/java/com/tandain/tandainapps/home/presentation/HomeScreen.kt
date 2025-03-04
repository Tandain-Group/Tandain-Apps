package com.tandain.tandainapps.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tandain.tandainapps.home.model.HomeUiEvent

// TODO: Add actual implementation
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "This is HomeScreen")
            Button(onClick = { viewModel.navigationHandler(HomeUiEvent.NavigateToSplashScreen)}) {
                Text(text = "Click me!")
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
