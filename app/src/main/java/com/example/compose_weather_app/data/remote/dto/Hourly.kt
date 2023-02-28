package com.example.compose_weather_app.data.remote.dto


import com.squareup.moshi.Json

data class Hourly(
    @Json(name = "temperature_2m")
    val temperature2m: List<Double>,
    @Json(name = "time")
    val time: List<String>,
    @Json(name = "weathercode")
    val weathercode: List<Int>
)