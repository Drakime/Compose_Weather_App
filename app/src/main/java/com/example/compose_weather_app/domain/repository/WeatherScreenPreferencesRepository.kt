package com.example.compose_weather_app.domain.repository

interface WeatherScreenPreferencesRepository {
    suspend fun putString(key: String, value: String)
    suspend fun getString(key: String): String?
}