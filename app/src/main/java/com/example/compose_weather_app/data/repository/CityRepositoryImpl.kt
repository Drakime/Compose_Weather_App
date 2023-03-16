package com.example.compose_weather_app.data.repository

import com.example.compose_weather_app.data.remote.CityApi
import com.example.compose_weather_app.data.remote.dto.CityDto
import com.example.compose_weather_app.domain.repository.CityRepository
import com.example.compose_weather_app.ui.presentation.search_display.City
import retrofit2.Response
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val api: CityApi
) : CityRepository {

    override suspend fun getCities(): List<CityDto> {
        return api.getCities()
    }
}