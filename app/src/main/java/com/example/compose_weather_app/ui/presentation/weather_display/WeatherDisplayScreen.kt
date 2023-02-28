package com.example.compose_weather_app.ui.presentation.weather_display

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WeatherDisplayScreen(
    viewModel: WeatherDisplayViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    state.weather?.let { Text(text = it.timezone) }
}