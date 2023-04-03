package com.example.compose_weather_app.ui.presentation.search_display

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_weather_app.common.Resource
import com.example.compose_weather_app.data.remote.dto.Result
import com.example.compose_weather_app.domain.repository.WeatherScreenPreferencesRepository
import com.example.compose_weather_app.domain.use_case.GetCityDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class SearchDisplayViewModel @Inject constructor(
    private val getCityDataUseCase: GetCityDataUseCase,
    private val weatherScreenPreferencesRepository: WeatherScreenPreferencesRepository,
) : ViewModel() {

    private val _state = mutableStateOf(SearchDisplayState())

    private fun getCities(location: String) {
        getCityDataUseCase.invoke(location).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SearchDisplayState(cities = (result.data))
                    cities.value = _state.value.cities?.results!!
                }
                is Resource.Error -> {
                    _state.value = SearchDisplayState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = SearchDisplayState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private var _searchText = mutableStateOf("")
    val searchText = _searchText

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    val cities: MutableState<List<Result>> = mutableStateOf(listOf())

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun searchLocation(location: String) {
        if (location == "") {
            return
        } else {
            getCities(location)
        }
    }

    fun updateLocation(
        locationKey: String = "location",
        locationValue: String,
        longitudeKey: String = "longitude",
        longitudeValue: String,
        latitudeKey: String = "latitude",
        latitudeValue: String
    ) = runBlocking {
        weatherScreenPreferencesRepository.putString(locationKey, locationValue)
        weatherScreenPreferencesRepository.putString(longitudeKey, longitudeValue)
        weatherScreenPreferencesRepository.putString(latitudeKey, latitudeValue)
    }
}