package com.example.compose_weather_app.domain.weather

import androidx.annotation.RawRes
import com.example.compose_weather_app.R

sealed class WeatherType(
    val weatherDesc: String,
    @RawRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        weatherDesc = "Clear Sky",
        iconRes = R.raw.ic_clear_day
    )

    object MainlyClear : WeatherType(
        weatherDesc = "Mainly Clear",
        iconRes = R.raw.ic_clear_day
    )

    object PartlyCloudy : WeatherType(
        weatherDesc = "Partly Cloudy",
        iconRes = R.raw.ic_cloudy
    )

    object Overcast : WeatherType(
        weatherDesc = "Overcast",
        iconRes = R.raw.ic_overcast
    )

    object Fog : WeatherType(
        weatherDesc = "Fog",
        iconRes = R.raw.ic_fog
    )

    object DepositingRimeFog : WeatherType(
        weatherDesc = "Depositing Rime Fog",
        iconRes = R.raw.ic_fog
    )

    object LightDrizzle : WeatherType(
        weatherDesc = "Light Drizzle",
        iconRes = R.raw.ic_drizzle
    )

    object ModerateDrizzle : WeatherType(
        weatherDesc = "Moderate Drizzle",
        iconRes = R.raw.ic_drizzle
    )

    object HeavyDrizzle : WeatherType(
        weatherDesc = "Heavy Drizzle",
        iconRes = R.raw.ic_drizzle
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Light Freezing Drizzle",
        iconRes = R.raw.ic_sleet
    )

    object HeavyFreezingDrizzle : WeatherType(
        weatherDesc = "Heavy Freezing Drizzle",
        iconRes = R.raw.ic_sleet
    )

    object SlightRain : WeatherType(
        weatherDesc = "Slight Rain",
        iconRes = R.raw.ic_drizzle
    )

    object ModerateRain : WeatherType(
        weatherDesc = "Moderate Rain",
        iconRes = R.raw.ic_rain
    )

    object HeavyRain : WeatherType(
        weatherDesc = "Heavy Rain",
        iconRes = R.raw.ic_rain
    )

    object LightFreezingRain : WeatherType(
        weatherDesc = "Light Freezing Rain",
        iconRes = R.raw.ic_overcast_sleet
    )

    object HeavyFreezingRain : WeatherType(
        weatherDesc = "Heavy Freezing Rain",
        iconRes = R.raw.ic_overcast_sleet
    )

    object SlightSnowFall : WeatherType(
        weatherDesc = "Slight Snowfall",
        iconRes = R.raw.ic_snow
    )

    object ModerateSnowFall : WeatherType(
        weatherDesc = "Moderate Snowfall",
        iconRes = R.raw.ic_snow
    )

    object HeavySnowFall : WeatherType(
        weatherDesc = "Heavy Snowfall",
        iconRes = R.raw.ic_snow
    )

    object SnowGrains : WeatherType(
        weatherDesc = "Snow Grains",
        iconRes = R.raw.ic_snow
    )

    object SlightRainShowers : WeatherType(
        weatherDesc = "Slight Rain Showers",
        iconRes = R.raw.ic_drizzle
    )

    object ModerateRainShowers : WeatherType(
        weatherDesc = "Moderate Rain Showers",
        iconRes = R.raw.ic_rain
    )

    object ViolentRainShowers : WeatherType(
        weatherDesc = "Violent Rain Showers",
        iconRes = R.raw.ic_rain
    )

    object SlightSnowShowers : WeatherType(
        weatherDesc = "Slight Snow Showers",
        iconRes = R.raw.ic_snow
    )

    object HeavySnowShowers : WeatherType(
        weatherDesc = "Heavy Snow Showers",
        iconRes = R.raw.ic_snow
    )

    companion object {
        fun fromWeatherCode(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Fog
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> HeavyDrizzle
                56 -> LightFreezingDrizzle
                57 -> HeavyFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingRain
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                else -> ClearSky
            }
        }
    }
}