package com.example.compose_weather_app.domain.model

import com.example.compose_weather_app.data.remote.dto.Daily
import com.example.compose_weather_app.data.remote.dto.Hourly

data class WeatherData(
    val currentTemperature: String,
    val currentWeatherCode: String,
    val sunrise: List<String>,
    val sunset: List<String>,
    val dailyMaxTemperature: List<Double>,
    val dailyMinTemperature: List<Double>,
    val dailyMaxWindSpeed: List<Double>,
    val dailyWeatherCode: List<Int>,
    val latitude: Double,
    val longitude: Double
)
