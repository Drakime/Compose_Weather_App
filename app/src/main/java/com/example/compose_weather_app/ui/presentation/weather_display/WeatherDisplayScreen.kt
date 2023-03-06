package com.example.compose_weather_app.ui.presentation.weather_display

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose_weather_app.ui.presentation.components.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherDisplayScreen(
    viewModel: WeatherDisplayViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scrollState = rememberScrollState()

    state.weather?.let {
        Column(modifier = Modifier
            .verticalScroll(state = scrollState)
            .padding(10.dp)) {
            WeatherDisplayTemperatureCard(weatherData = state.weather)
            WeatherDisplayForecastCard(weatherData = state.weather)
            WeatherDisplayWindCard(weatherData = state.weather)
            WeatherDisplaySunriseSunsetCard(weatherData = state.weather)
            WeatherDisplayPrecipitationCard(weatherData = state.weather)
        }
    }
}