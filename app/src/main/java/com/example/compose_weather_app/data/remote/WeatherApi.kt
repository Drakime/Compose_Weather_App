package com.example.compose_weather_app.data.remote

import com.example.compose_weather_app.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface WeatherApi {
    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: String = "51.51",
        @Query("longitude") longitude: String = "-0.13",
        @Query("hourly") hourly: String = "temperature_2m,weathercode",
        @Query("daily") daily: String = "weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,windspeed_10m_max",
        @Query("current_weather") current_weather: Boolean = true,
        @Query("timezone", encoded = true) timezone: String = "Europe%2FLondon" //  You may want to supply a preference option for the user to set timezone.
    ): WeatherDto
}