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
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.math.roundToInt

@Composable
fun WeatherDisplayForecastCard(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        LazyRow() {
            items(weatherData.dailyMaxTemperature.drop(1).size) { item ->
                Box(
                    modifier = Modifier
                        .clickable(onClick = { navController.navigate(route = Screen.ForecastDisplayScreen.route) })
                ) {
                    Column(
                        modifier
                            .fillMaxHeight()
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val dates = getDates()
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

// Code adapted from Rahul Khatri, from StackOverflow
// https://stackoverflow.com/a/67418587
//
// Returns a list of dates between two dates, as list collection
fun getDates(inputDate: LocalDate = LocalDate.now()): List<String> {
    var dates = ArrayList<String>()
    val input = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val startDate = inputDate.toString()
    val endDate = inputDate.plusDays(6).toString()
    var date1: Date? = null
    var date2: Date? = null

    try {
        date1 = input.parse(startDate)
        date2 = input.parse(endDate)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    val cal1 = Calendar.getInstance()
    cal1.time = date1
    val cal2 = Calendar.getInstance()
    cal2.time = date2

    while (!cal1.after(cal2)) {
        val output = SimpleDateFormat("d/M", Locale.getDefault())
        dates.add(output.format(cal1.time))
        cal1.add(Calendar.DATE, 1)
    }

    return dates
}