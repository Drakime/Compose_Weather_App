package com.example.compose_weather_app.data.repository

import com.example.compose_weather_app.data.remote.CityApi
import com.example.compose_weather_app.data.remote.dto.CityDto
import com.example.compose_weather_app.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val api: CityApi
) : CityRepository {

    override suspend fun getCities(location: String): CityDto {
        return api.getCities(location)
    }
}