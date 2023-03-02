package com.example.compose_weather_app.ui.presentation.weather_display

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_weather_app.R
import com.example.compose_weather_app.ui.presentation.components.WeatherDisplayCard

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherDisplayScreen(
    viewModel: WeatherDisplayViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    state.weather?.let {
        Column(modifier = Modifier.padding(24.dp)) {
            WeatherDisplayCard(weatherData = state.weather)
        }
    }
}