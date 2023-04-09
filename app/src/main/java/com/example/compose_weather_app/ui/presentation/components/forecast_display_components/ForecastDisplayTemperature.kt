package com.example.compose_weather_app.ui.presentation.components.forecast_display_components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_weather_app.domain.model.WeatherData

@Composable
fun ForecastDisplayTemperature(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    index: Int,
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(text = "Minimum Temperature")
        Text(text = weatherData.dailyMinTemperature[index].toString() + "°")
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Maximum Temperature")
        Text(text = weatherData.dailyMaxTemperature[index].toString() + "°")
    }
}