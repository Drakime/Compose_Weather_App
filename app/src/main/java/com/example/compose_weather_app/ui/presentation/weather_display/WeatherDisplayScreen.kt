package com.example.compose_weather_app.ui.presentation.weather_display

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose_weather_app.ui.presentation.components.weather_display_components.*

@Composable
fun WeatherDisplayScreen(
    viewModel: WeatherDisplayViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
    val scrollState = rememberScrollState()
    val location = viewModel.location

    val windUnit = viewModel.windUnit.collectAsState()
    val precipitationUnit = viewModel.precipitationUnit.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.checkDataStore()
        viewModel.getWeather()
        viewModel.getLocation()
        viewModel.getDataStoreUnits()
    }

    state.weather?.let {
        Column {
            Row {
                WeatherDisplayAppBar(navController)
            }
            Row {
                Column(
                    modifier = Modifier
                        .verticalScroll(state = scrollState)
                        .padding(10.dp)
                ) {
                    WeatherDisplayTemperatureCard(weatherData = state.weather, location = location)
                    WeatherDisplayForecastCard(weatherData = state.weather, navController = navController)
                    WeatherDisplayWindCard(weatherData = state.weather, unit = windUnit.value)
                    WeatherDisplaySunriseSunsetCard(weatherData = state.weather)
                    WeatherDisplayPrecipitationCard(weatherData = state.weather, unit = precipitationUnit.value)
                }
            }
        }
    }
}