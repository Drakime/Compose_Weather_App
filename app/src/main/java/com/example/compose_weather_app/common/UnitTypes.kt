package com.example.compose_weather_app.common

enum class UnitTypes {
    TEMPERATURE(listOf("Celsius", "Fahrenheit"), "temperature_unit"),
    WIND(listOf("mph", "km/h"), "wind_unit"),
    PRECIPITATION(listOf("mm", "inch"), "precipitation_unit");

    var units: List<String>
    var key: String

    constructor(
        units: List<String>,
        key: String,
    ) {
        this.units = units
        this.key = key
    }
}