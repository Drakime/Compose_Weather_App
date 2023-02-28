package com.example.compose_weather_app.ui.presentation

sealed class Screen(val route: String) {
    object WeatherDisplayScreen: Screen("weather_display_screen")
}
