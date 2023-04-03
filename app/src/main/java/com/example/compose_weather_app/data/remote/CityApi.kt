package com.example.compose_weather_app.data.remote

import com.example.compose_weather_app.data.remote.dto.CityDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {
    @GET("search?")
    suspend fun getCities(
        @Query("name") location: String,
        @Query("count") count: Int = 100
    ): CityDto
}