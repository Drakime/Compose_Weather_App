package com.example.compose_weather_app.ui.presentation.weather_display

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose_weather_app.ui.presentation.components.WeatherDisplaySunriseSunsetCard
import com.example.compose_weather_app.ui.presentation.components.WeatherDisplayTemperatureCard
import com.example.compose_weather_app.ui.presentation.components.WeatherDisplayWindCard

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherDisplayScreen(
    viewModel: WeatherDisplayViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    state.weather?.let {
        Column(modifier = Modifier.padding(24.dp)) {
            WeatherDisplayTemperatureCard(weatherData = state.weather)
            WeatherDisplayWindCard(weatherData = state.weather)
            WeatherDisplaySunriseSunsetCard(weatherData = state.weather)
        }
    }
}