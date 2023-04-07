package com.example.compose_weather_app.data.remote.dto

import com.squareup.moshi.Json

data class CurrentWeather(
    @Json(name = "is_day")
    val isDay: Int = 0,
    @Json(name = "temperature")
    val temperature: Double = 0.0,
    @Json(name = "time")
    val time: String = "",
    @Json(name = "weathercode")
    val weathercode: Int = 0,
    @Json(name = "winddirection")
    val winddirection: Double = 0.0,
    @Json(name = "windspeed")
    val windspeed: Double = 0.0
)