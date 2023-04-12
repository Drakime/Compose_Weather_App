package com.example.compose_weather_app.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose_weather_app.ui.presentation.Screen
import com.example.compose_weather_app.ui.presentation.forecast_display.ForecastDisplayScreen
import com.example.compose_weather_app.ui.presentation.preferences_display.PreferencesDisplayScreen
import com.example.compose_weather_app.ui.presentation.search_display.SearchDisplayScreen
import com.example.compose_weather_app.ui.presentation.weather_display.WeatherDisplayScreen
import com.example.compose_weather_app.ui.theme.Material3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.WeatherDisplayScreen.route
                    ) {
                        composable(
                            route = Screen.WeatherDisplayScreen.route
                        ) {
                            WeatherDisplayScreen(navController = navController)
                        }
                        composable(
                            route = Screen.SearchDisplayScreen.route
                        ) {
                            SearchDisplayScreen(navController = navController)
                        }
                        composable(
                            route = Screen.ForecastDisplayScreen.route + "{index}",
                            arguments = listOf(
                                navArgument("index") {
                                    type = NavType.StringType
                                    defaultValue = "0"
                                }
                            )
                        ) { backStackEntry ->
                            ForecastDisplayScreen(
                                navController = navController,
                                arguments = backStackEntry.arguments?.getString("index") ?: ""
                            )
                        }
                        composable(
                            route = Screen.PreferencesDisplayScreen.route
                        ) {
                            PreferencesDisplayScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}