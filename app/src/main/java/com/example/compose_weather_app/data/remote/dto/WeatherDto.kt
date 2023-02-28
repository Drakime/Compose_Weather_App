package com.example.compose_weather_app.data.remote.dto


import com.example.compose_weather_app.domain.model.WeatherData
import com.squareup.moshi.Json

data class WeatherDto(
    @Json(name = "daily")
    val daily: Daily,
    @Json(name = "daily_units")
    val dailyUnits: DailyUnits,
    @Json(name = "elevation")
    val elevation: Double,
    @Json(name = "generationtime_ms")
    val generationtimeMs: Double,
    @Json(name = "hourly")
    val hourly: Hourly,
    @Json(name = "hourly_units")
    val hourlyUnits: HourlyUnits,
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "timezone_abbreviation")
    val timezoneAbbreviation: String,
    @Json(name = "utc_offset_seconds")
    val utcOffsetSeconds: Int
)

fun WeatherDto.toWeatherData(): WeatherData {
    return WeatherData(
        timezone = timezone
    )
}