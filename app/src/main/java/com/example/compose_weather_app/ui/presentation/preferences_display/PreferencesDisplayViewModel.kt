package com.example.compose_weather_app.ui.presentation.preferences_display

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.compose_weather_app.domain.repository.WeatherScreenPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PreferencesDisplayViewModel @Inject constructor(
    private val weatherScreenPreferencesRepository: WeatherScreenPreferencesRepository
) : ViewModel() {

    private val _temperatureUnit = MutableStateFlow("")
    val temperatureUnit = _temperatureUnit.asStateFlow()

    private val _windUnit = MutableStateFlow("")
    val windUnit = _windUnit.asStateFlow()

    private val _precipitationUnit = MutableStateFlow("")
    val precipitationUnit = _precipitationUnit.asStateFlow()

    suspend fun getPreferences() {
        _temperatureUnit.value = weatherScreenPreferencesRepository.getString("temperature_unit").toString()
        _windUnit.value = weatherScreenPreferencesRepository.getString("wind_unit").toString()
        _precipitationUnit.value = weatherScreenPreferencesRepository.getString("precipitation_unit").toString()
    }

    suspend fun updatePreferences(key: String, option: String) {
        weatherScreenPreferencesRepository.putString(key, option)
        Log.d("Test", weatherScreenPreferencesRepository.getString(key).toString())
    }

}