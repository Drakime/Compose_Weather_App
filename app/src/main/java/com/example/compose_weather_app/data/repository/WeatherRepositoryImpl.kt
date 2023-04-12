package com.example.compose_weather_app.data.repository

import com.example.compose_weather_app.data.remote.WeatherApi
import com.example.compose_weather_app.data.remote.dto.WeatherDto
import com.example.compose_weather_app.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val weatherScreenPreferencesRepositoryImpl: WeatherScreenPreferencesRepositoryImpl
) : WeatherRepository {

    override suspend fun getWeather(): WeatherDto {
        val lat = weatherScreenPreferencesRepositoryImpl.getString("latitude")
        val long = weatherScreenPreferencesRepositoryImpl.getString("longitude")
        val temperatureUnit = weatherScreenPreferencesRepositoryImpl.getString("temperature_unit")
        val windUnit = weatherScreenPreferencesRepositoryImpl.getString("wind_unit")
        val precipitationUnit =
            weatherScreenPreferencesRepositoryImpl.getString("precipitation_unit")

        return api.getWeather(
            latitude = lat.toString(),
            longitude = long.toString(),
            temperature_unit = temperatureUnit.toString(),
            windspeed_unit = windUnit.toString(),
            precipitation_unit = precipitationUnit.toString()
        )
    }

}