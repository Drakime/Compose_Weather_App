package com.example.compose_weather_app.data.dto


import com.squareup.moshi.Json

data class Daily(
    @Json(name = "precipitation_sum")
    val precipitationSum: List<Double>,
    @Json(name = "sunrise")
    val sunrise: List<String>,
    @Json(name = "sunset")
    val sunset: List<String>,
    @Json(name = "temperature_2m_max")
    val temperature2mMax: List<Double>,
    @Json(name = "temperature_2m_min")
    val temperature2mMin: List<Double>,
    @Json(name = "time")
    val time: List<String>,
    @Json(name = "weathercode")
    val weathercode: List<Int>,
    @Json(name = "windspeed_10m_max")
    val windspeed10mMax: List<Double>
)