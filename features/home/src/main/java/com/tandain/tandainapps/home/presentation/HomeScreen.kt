package com.tandain.tandainapps.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tandain.tandainapps.navigation.route.HomeRoute
import com.tandain.tandainapps.navigation.route.SplashScreenRoute

// TODO: Add actual implementation
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onButtonClick: (route: Any) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "This is HomeScreen")
            Button(onClick = { onButtonClick(SplashScreenRoute) }) {
                Text(text = "Click me!")
            }
        }
    }
}

// TODO: Move to splashscreen module and add actual implementation
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onButtonClick: (route: Any) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "This is SplashScreen")
            Button(onClick = { onButtonClick(HomeRoute) }) {
                Text(text = "Click me!")
            }
        }
    }
}
