package com.example.compose_weather_app.ui.presentation.search_display

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

@OptIn(FlowPreview::class)
class SearchDisplayViewModel : ViewModel() {

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