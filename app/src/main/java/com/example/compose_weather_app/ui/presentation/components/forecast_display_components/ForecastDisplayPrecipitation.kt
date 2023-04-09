package com.example.compose_weather_app.ui.presentation.components.forecast_display_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_weather_app.domain.model.WeatherData

@Composable
fun ForecastDisplayPrecipitation(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    index: Int,
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(text = "Precipitation Sum")
        Text(text = weatherData.precipitation[index].toString() + " mm")
    }
}