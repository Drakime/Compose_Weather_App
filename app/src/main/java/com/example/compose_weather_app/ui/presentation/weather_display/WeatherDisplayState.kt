package com.example.compose_weather_app.ui.presentation.weather_display

import com.example.compose_weather_app.domain.model.WeatherData

data class WeatherDisplayState(
    val isLoading: Boolean = false,
    val weather: WeatherData? = null,
    val error: String = ""
)