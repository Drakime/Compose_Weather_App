package com.example.compose_weather_app.data.remote.dto


import com.squareup.moshi.Json

data class CityDto(
    @Json(name = "generationtime_ms")
    val generationtimeMs: Double = 0.0,
    @Json(name = "results")
    val results: List<Result> = listOf()
)