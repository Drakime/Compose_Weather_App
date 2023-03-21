package com.example.compose_weather_app.data.remote

import com.example.compose_weather_app.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude", encoded = true) latitude: String = "51.51",
        @Query("longitude", encoded = true) longitude: String = "-0.13",
        @Query("hourly", encoded = true) hourly: String = "temperature_2m,weathercode",
        @Query("daily", encoded = true) daily: String = "weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,windspeed_10m_max",
        @Query("timezone", encoded = true) timezone: String = "Europe%2FLondon"
    ): WeatherDto
}