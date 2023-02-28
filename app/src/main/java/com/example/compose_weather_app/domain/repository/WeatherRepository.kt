package com.example.compose_weather_app.domain.repository

import com.example.compose_weather_app.data.remote.dto.WeatherDto

interface WeatherRepository {
    suspend fun getWeather() : WeatherDto
}