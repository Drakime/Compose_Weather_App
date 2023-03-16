package com.example.compose_weather_app.ui.presentation.search_display

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_weather_app.common.Resource
import com.example.compose_weather_app.domain.use_case.GetCityDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(FlowPreview::class)
class SearchDisplayViewModel @Inject constructor(
    private val getCityDataUseCase: GetCityDataUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SearchDisplayState())

    init {
        getCities()
    }

    private fun getCities() {
        getCityDataUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SearchDisplayState(cities = (result.data))
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

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _cities = MutableStateFlow(allCities)
    val cities = searchText
        .debounce(500L)
        .onEach { _isSearching.update { true } }
        .combine(_cities) { text, cities ->
            if (text.isBlank()) {
                cities
            } else {
                delay(1000L)
                cities.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _cities.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}

data class City(
    val name: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$name"
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

private val allCities = listOf(
    City(name = "London"),
    City(name = "Leeds"),
    City(name = "Manchester"),
    City(name = "Brighton"),
    City(name = "Tokyo"),
    City(name = "Norwich"),
)