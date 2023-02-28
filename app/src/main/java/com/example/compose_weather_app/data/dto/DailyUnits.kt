package com.example.compose_weather_app.data.dto


import com.squareup.moshi.Json

data class DailyUnits(
    @Json(name = "precipitation_sum")
    val precipitationSum: String,
    @Json(name = "sunrise")
    val sunrise: String,
    @Json(name = "sunset")
    val sunset: String,
    @Json(name = "temperature_2m_max")
    val temperature2mMax: String,
    @Json(name = "temperature_2m_min")
    val temperature2mMin: String,
    @Json(name = "time")
    val time: String,
    @Json(name = "weathercode")
    val weathercode: String,
    @Json(name = "windspeed_10m_max")
    val windspeed10mMax: String
)