package com.example.compose_weather_app.data.remote

import com.example.compose_weather_app.data.remote.dto.CityDto
import retrofit2.http.GET

interface CityApi {
    @GET("search?q={location}")
    suspend fun getCities(): List<CityDto>
}