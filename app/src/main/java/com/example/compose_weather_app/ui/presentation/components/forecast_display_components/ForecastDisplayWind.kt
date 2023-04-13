package com.example.compose_weather_app.ui.presentation.components.forecast_display_components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_weather_app.domain.model.WeatherData

@Composable
fun ForecastDisplayWind(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    index: Int,
    unit: State<String>,
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(text = "Max Wind Speed")
        Text(text = weatherData.dailyMaxWindSpeed[index].toString() + " $unit")
    }
}