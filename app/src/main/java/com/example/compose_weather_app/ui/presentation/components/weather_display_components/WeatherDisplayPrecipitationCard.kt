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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.compose_weather_app.R
import com.example.compose_weather_app.domain.model.WeatherData

@Composable
fun WeatherDisplayPrecipitationCard(
    weatherData: WeatherData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(0.dp, 10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Precipitation Sum", fontWeight = FontWeight.Bold)
                Text(text = weatherData.precipitation[0].toString() + " mm", fontSize = 35.sp)
            }
            Column() {
                PrecipitationLoader()
            }
        }
    }
}

@Composable
fun PrecipitationLoader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ic_raindrop))
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

@Preview
@Composable
fun WeatherDisplayPrecipitationCardPreview(
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(0.dp, 10.dp),
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
                Text(text = "Precipitation", fontWeight = FontWeight.Bold)
                Text(text = "10.0", fontSize = 35.sp)
            }
            Column() {
                PrecipitationLoader()
            }
        }
    }
}