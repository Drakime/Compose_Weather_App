package com.example.compose_weather_app.data.remote.dto


import com.example.compose_weather_app.domain.model.CityData
import com.squareup.moshi.Json

data class CityDtoItem(
    @Json(name = "boundingbox")
    val boundingbox: List<String>,
    @Json(name = "class")
    val classX: String,
    @Json(name = "display_name")
    val displayName: String,
    @Json(name = "importance")
    val importance: Double,
    @Json(name = "lat")
    val lat: String,
    @Json(name = "licence")
    val licence: String,
    @Json(name = "lon")
    val lon: String,
    @Json(name = "osm_id")
    val osmId: Long,
    @Json(name = "osm_type")
    val osmType: String,
    @Json(name = "place_id")
    val placeId: Int,
    @Json(name = "powered_by")
    val poweredBy: String,
    @Json(name = "type")
    val type: String
)

fun CityDtoItem.toCityDataList(): CityData {
    return CityData(
        name = displayName,
        latitude = lat,
        longitude = lon,
        classX = classX,
        type = type
    )
}