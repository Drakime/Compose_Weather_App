package com.example.compose_weather_app.ui.presentation.forecast_display

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose_weather_app.ui.presentation.components.forecast_display_components.*
import com.example.compose_weather_app.ui.presentation.weather_display.WeatherDisplayViewModel

@Composable
fun ForecastDisplayScreen(
    viewModel: WeatherDisplayViewModel = hiltViewModel(),
    navController: NavController,
    arguments: String,
    modifier: Modifier = Modifier
) {
    val state = viewModel.state.value
    val scrollState = rememberScrollState()

    val index = arguments.toInt()

    LaunchedEffect(Unit) {
        viewModel.getWeather()
    }

    state.weather?.let {
        Column {
            Row {
                ForecastDisplayAppBar(navController)
            }
            Row {
                Column(
                    modifier
                        .verticalScroll(state = scrollState)
                ) {
                    ForecastDisplayTemperature(weatherData = state.weather, index = index)
                    Divider(Modifier.padding(5.dp))
                    ForecastDisplayWind(weatherData = state.weather, index = index)
                    Divider(Modifier.padding(5.dp))
                    ForecastDisplayPrecipitation(weatherData = state.weather, index = index)
                    Divider(Modifier.padding(5.dp))
                    ForecastDisplaySunriseSunset(weatherData = state.weather, index = index)
                }
            }
        }
    }

}