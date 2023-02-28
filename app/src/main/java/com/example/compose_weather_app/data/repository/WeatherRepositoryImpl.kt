package com.example.compose_weather_app.data.repository

import com.example.compose_weather_app.data.remote.WeatherApi
import com.example.compose_weather_app.data.remote.dto.WeatherDto
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(): WeatherDto {
        return api.getWeather()
    }

}