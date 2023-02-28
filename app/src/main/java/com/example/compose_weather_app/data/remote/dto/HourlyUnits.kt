package com.example.compose_weather_app.data.remote.dto


import com.squareup.moshi.Json

data class HourlyUnits(
    @Json(name = "temperature_2m")
    val temperature2m: String,
    @Json(name = "time")
    val time: String,
    @Json(name = "weathercode")
    val weathercode: String
)