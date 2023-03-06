package com.example.compose_weather_app.ui.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.compose_weather_app.domain.model.WeatherData
import com.example.compose_weather_app.R

@Composable
fun WeatherDisplayForecastCard(
    weatherData: WeatherData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(0.dp, 10.dp, 0.dp, 0.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        LazyRow() {
            items(6) {
                ItemView(weatherData = weatherData)
            }
        }
    }
}

@Composable
fun ItemView(
    weatherData: WeatherData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxHeight()
    ) {
        DailyTemperatureLoader()
        Text(text = weatherData.dailyMaxTemperature[0].toString(), textAlign = TextAlign.Center)
    }

}

@Composable
fun DailyTemperatureLoader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ic_clear_day))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        Modifier.size(100.dp)
    )
}