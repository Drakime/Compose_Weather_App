package com.example.compose_weather_app.domain.repository

import com.example.compose_weather_app.data.remote.dto.CityDto

interface CityRepository {

    suspend fun getCities() : List<CityDto>

}