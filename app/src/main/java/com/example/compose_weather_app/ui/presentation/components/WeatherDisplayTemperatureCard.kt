package com.example.compose_weather_app.ui.presentation.components

import androidx.annotation.RawRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.compose_weather_app.domain.model.WeatherData

@Composable
fun WeatherDisplayTemperatureCard(
    weatherData: WeatherData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier.padding(10.dp)
            ) {
                Text(text = weatherData.currentTemperature + "°", fontSize = 75.sp)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TemperatureLoader(weatherData.currentWeatherCode.iconRes)
            }
        }
        Row(
            modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = weatherData.currentWeatherCode.weatherDesc, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun TemperatureLoader(@RawRes iconRes: Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(iconRes))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        Modifier.size(200.dp)
    )
}

@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Composable
fun WeatherDisplayCardPreview(
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .fillMaxWidth()
            .clickable { },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(text = "7" + "°", fontSize = 100.sp)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier
                        .size(100.dp)
                        .clip(RectangleShape)
                        .background(Color.Red)
                )
                Text(text = "Weather Description")
            }
        }
    }
}