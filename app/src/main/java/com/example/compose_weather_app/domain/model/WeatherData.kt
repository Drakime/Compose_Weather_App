package com.example.compose_weather_app.domain.model

import com.example.compose_weather_app.data.remote.dto.Daily
import com.example.compose_weather_app.data.remote.dto.Hourly
import com.example.compose_weather_app.domain.weather.WeatherType

data class WeatherData(
    val currentTemperature: String,
    val currentWeatherCode: WeatherType,
    val sunrises: List<String>,
    val sunsets: List<String>,
    val precipitation: List<Double>,
    val dailyMaxTemperature: List<Double>,
    val dailyMinTemperature: List<Double>,
    val dailyMaxWindSpeed: List<Double>,
    val dailyWeatherCode: List<Int>,
    val latitude: Double,
    val longitude: Double
)
