package com.example.compose_weather_app.ui.presentation.weather_display

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_weather_app.common.Resource
import com.example.compose_weather_app.domain.repository.WeatherScreenPreferencesRepository
import com.example.compose_weather_app.domain.use_case.GetWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherDisplayViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    private val weatherScreenPreferencesRepository: WeatherScreenPreferencesRepository,
) : ViewModel() {

    private val _state = mutableStateOf(WeatherDisplayState())
    val state: State<WeatherDisplayState> = _state

    private var _location = mutableStateOf("")
    val location = _location

    fun getWeather() {
        getWeatherDataUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = WeatherDisplayState(weather = (result.data))
                }
                is Resource.Error -> {
                    _state.value = WeatherDisplayState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = WeatherDisplayState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    suspend fun getLocation() {
        _location.value = weatherScreenPreferencesRepository.getString("location").toString()
        Log.d("Test", "$_location WeatherDisplayViewModel")
        Log.d("Test", weatherScreenPreferencesRepository.getString("latitude").toString())
        Log.d("Test", weatherScreenPreferencesRepository.getString("longitude").toString())
    }

    suspend fun checkDataStore() {
        if (weatherScreenPreferencesRepository.getString("location") == null) {
            weatherScreenPreferencesRepository.putString("location", "Leeds")
            weatherScreenPreferencesRepository.putString("latitude", "51.51")
            weatherScreenPreferencesRepository.putString("longitude", "-0.13")
            getWeather()
            getLocation()
        } else {
            return
        }
    }
}