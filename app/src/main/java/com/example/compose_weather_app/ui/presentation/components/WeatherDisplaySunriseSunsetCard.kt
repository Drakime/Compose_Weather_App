package com.example.compose_weather_app.ui.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.compose_weather_app.R
import com.example.compose_weather_app.domain.model.WeatherData

@Composable
fun WeatherDisplaySunriseSunsetCard(
    weatherData: WeatherData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SunriseLoader()
                Text(text = "Sunrise", fontWeight = FontWeight.Bold)
                Text(text = weatherData.sunrises[0], textAlign = TextAlign.Center)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SunsetLoader()
                Text(text = "Sunset", fontWeight = FontWeight.Bold)
                Text(text = weatherData.sunsets[0], textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun SunriseLoader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ic_sunrise))
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

@Composable
fun SunsetLoader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ic_sunset))
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

@Preview
@Composable
fun WeatherDisplaySunriseSunsetCardPreview(
    modifier: Modifier = Modifier
) {
    Card(
        modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SunriseLoader()
                Text(text = "Sunrise", fontWeight = FontWeight.Bold)
                Text(text = "00:00")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SunsetLoader()
                Text(text = "Sunset", fontWeight = FontWeight.Bold)
                Text(text = "00:00")
            }
        }
    }
}