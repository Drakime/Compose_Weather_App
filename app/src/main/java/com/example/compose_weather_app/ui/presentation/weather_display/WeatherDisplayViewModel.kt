package com.example.compose_weather_app.ui.presentation.weather_display

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_weather_app.common.Resource
import com.example.compose_weather_app.domain.use_case.GetWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class WeatherDisplayViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase
) : ViewModel() {

    private val _state = mutableStateOf(WeatherDisplayState())
    val state: State<WeatherDisplayState> = _state

    init {
        getWeather()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getWeather() {
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
}