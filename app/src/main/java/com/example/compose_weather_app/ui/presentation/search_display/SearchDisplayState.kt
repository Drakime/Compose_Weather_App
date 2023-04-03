package com.example.compose_weather_app.ui.presentation.search_display

import com.example.compose_weather_app.data.remote.dto.CityDto

data class SearchDisplayState(
    val isLoading: Boolean = false,
    val cities: CityDto? = null,
    val error: String = ""
)