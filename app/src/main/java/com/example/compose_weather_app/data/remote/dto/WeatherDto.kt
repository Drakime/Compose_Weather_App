package com.example.compose_weather_app.data.remote.dto


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.compose_weather_app.domain.model.WeatherData
import com.example.compose_weather_app.domain.weather.WeatherType
import com.squareup.moshi.Json
import java.time.Clock
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import kotlin.math.roundToInt

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

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherData(): WeatherData {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd" + "'T'" + "HH:00")
    val currentTime = LocalDateTime.now().format(formatter)
    var currentTemperature = ""
    var currentWeatherCode = 0

    for (hour in hourly.time) {
        var index = hourly.time.indexOf(hour)

        if (hour.equals(currentTime)) {
            currentTemperature = hourly.temperature2m[index].roundToInt().toString()
            currentWeatherCode = hourly.weathercode[index]
            break
        } else {
            currentTemperature = "N/A"
        }
    }

    return WeatherData(
        currentTemperature = currentTemperature,
        currentWeatherCode = WeatherType.fromWeatherCode(currentWeatherCode),
        sunrise = daily.sunrise,
        sunset = daily.sunset,
        dailyMaxTemperature = daily.temperature2mMax,
        dailyMinTemperature = daily.temperature2mMin,
        dailyMaxWindSpeed = daily.windspeed10mMax,
        dailyWeatherCode = daily.weathercode,
        latitude = latitude,
        longitude = longitude
    )
}