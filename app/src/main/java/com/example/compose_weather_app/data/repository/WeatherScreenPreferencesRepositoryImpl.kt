package com.example.compose_weather_app.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.compose_weather_app.common.Constants.WEATHER_SCREEN_PREFERENCES_DATASTORE_NAME
import com.example.compose_weather_app.domain.repository.WeatherScreenPreferencesRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class WeatherScreenPreferencesRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : WeatherScreenPreferencesRepository {

    override suspend fun putString(key: String, value: String) {
        val preferenceKey = stringPreferencesKey(key)
        dataStore.edit {
            it[preferenceKey] = value
        }
    }

    override suspend fun getString(key: String): String? {
        return try {
            val preferenceKey = stringPreferencesKey(key)
            val preference = dataStore.data.first()
            preference[preferenceKey]
        } catch (e:Exception) {
            e.printStackTrace()
            null
        }
    }
}