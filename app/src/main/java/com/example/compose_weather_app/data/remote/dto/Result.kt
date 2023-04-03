package com.example.compose_weather_app.data.remote.dto


import com.squareup.moshi.Json

data class Result(
    @Json(name = "admin1")
    val admin1: String = "",
    @Json(name = "admin1_id")
    val admin1Id: Int = 0,
    @Json(name = "admin2")
    val admin2: String? = null,
    @Json(name = "admin2_id")
    val admin2Id: Int? = null,
    @Json(name = "admin3")
    val admin3: String? = null,
    @Json(name = "admin3_id")
    val admin3Id: Int? = null,
    @Json(name = "admin4")
    val admin4: String? = null,
    @Json(name = "admin4_id")
    val admin4Id: Int? = null,
    @Json(name = "country")
    val country: String = "",
    @Json(name = "country_code")
    val countryCode: String = "",
    @Json(name = "country_id")
    val countryId: Int = 0,
    @Json(name = "elevation")
    val elevation: Double = 0.0,
    @Json(name = "feature_code")
    val featureCode: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "latitude")
    val latitude: Double = 0.0,
    @Json(name = "longitude")
    val longitude: Double = 0.0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "population")
    val population: Int? = null,
    @Json(name = "postcodes")
    val postcodes: List<String>? = null,
    @Json(name = "timezone")
    val timezone: String = ""
)