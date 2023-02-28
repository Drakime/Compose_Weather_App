package com.example.compose_weather_app.data.remote

import com.example.compose_weather_app.data.remote.dto.WeatherDto
import retrofit2.http.GET

interface WeatherApi {
    @GET("forecast?latitude=51.51&longitude=-0.13&hourly=temperature_2m,weathercode&daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,windspeed_10m_max&timezone=Europe%2FLondon")
    suspend fun getWeather(): WeatherDto
}