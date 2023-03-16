package com.example.compose_weather_app.ui.presentation.search_display

import com.example.compose_weather_app.data.remote.dto.CityDto
import com.example.compose_weather_app.domain.model.CityData

data class SearchDisplayState(
    val isLoading: Boolean = false,
    val cities: List<CityDto>? = null,
    val error: String = ""
)