package com.example.compose_weather_app.ui.presentation.components.weather_display_components

import androidx.annotation.RawRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.compose_weather_app.domain.model.WeatherData
import com.example.compose_weather_app.ui.presentation.Screen
import com.example.compose_weather_app.utils.DateUtils
import kotlin.math.roundToInt

@Composable
fun WeatherDisplayForecastCard(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val dateUtils = DateUtils()

    Card(
        modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        LazyRow() {
            items(weatherData.dailyMaxTemperature.drop(1).size) { item ->
                Box(
                    modifier = Modifier
                        .clickable(onClick = { navController.navigate(route = Screen.ForecastDisplayScreen.route + (item + 1)) })
                ) {
                    Column(
                        modifier
                            .fillMaxHeight()
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val dates = dateUtils.getDates().drop(1)
                        Text(text = dates[item])
                        DailyTemperatureLoader(weatherData.dailyWeatherCode[item].iconRes)
                        Text(
                            text = weatherData.dailyMaxTemperature[item].roundToInt()
                                .toString() + "°"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DailyTemperatureLoader(@RawRes iconRes: Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(iconRes))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        Modifier.size(65.dp)
    )
}