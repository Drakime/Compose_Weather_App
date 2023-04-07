package com.example.compose_weather_app.ui.presentation.components.weather_display_components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.compose_weather_app.ui.presentation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherDisplayAppBar(navController: NavController) {
    TopAppBar(
        title = { Text("Compose Weather App") },
        actions = {
            // RowScope here, so these icons will be placed horizontally
            IconButton(onClick = { navController.navigate(route = Screen.SearchDisplayScreen.route) }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray)
    )
}