package com.example.compose_weather_app.ui.presentation

sealed class Screen(var route: String) {
    object WeatherDisplayScreen: Screen("weather_display_screen")
    object SearchDisplayScreen: Screen("search_display_screen")
    object ForecastDisplayScreen: Screen("forecast_display_screen/")
}
