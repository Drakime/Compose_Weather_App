package com.example.compose_weather_app.ui.presentation.preferences_display

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toLowerCase
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.compose_weather_app.common.UnitTypes
import com.example.compose_weather_app.ui.presentation.components.preferences_display_components.PreferencesDisplayAppBar
import com.example.compose_weather_app.ui.presentation.components.preferences_display_components.PreferencesDisplayDialog
import com.example.compose_weather_app.ui.presentation.components.preferences_display_components.PreferencesDisplayOption
import kotlinx.coroutines.launch

@Composable
fun PreferencesDisplayScreen(
    viewModel: PreferencesDisplayViewModel = hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    var showDialog by remember { mutableStateOf(false) }
    var unitType: UnitTypes by remember { mutableStateOf(UnitTypes.TEMPERATURE) }

    val temperatureUnit = viewModel.temperatureUnit.collectAsState()
    val windUnit = viewModel.windUnit.collectAsState()
    val precipitationUnit = viewModel.precipitationUnit.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getPreferences()
    }

    Column {
        Row {
            PreferencesDisplayAppBar(navController)
        }
        Row {
            Column(
                modifier
                    .verticalScroll(state = scrollState)
            ) {
                PreferencesDisplayOption(
                    onClick = {
                        unitType = UnitTypes.TEMPERATURE
                        showDialog = true
                    },
                    title = "Temperature",
                    subtitle = temperatureUnit.value.replaceFirstChar { char -> char.titlecase() },
                )
                PreferencesDisplayOption(
                    onClick = {
                        unitType = UnitTypes.WIND
                        showDialog = true
                    },
                    title = "Wind",
                    subtitle = windUnit.value,
                )
                PreferencesDisplayOption(
                    onClick = {
                        unitType = UnitTypes.PRECIPITATION
                        showDialog = true
                    },
                    title = "Precipitation",
                    subtitle = precipitationUnit.value,
                )
                if (showDialog) {
                    PreferencesDisplayDialog(
                        onDismiss = { showDialog = false },
                        unitType = unitType,
                        onOptionAccepted = { option ->
                            viewModel.viewModelScope.launch {
                                viewModel.updatePreferences(unitType.key, option.lowercase().replace("/", ""))
                                viewModel.getPreferences()
                                showDialog = false
                            }
                        }
                    )
                }
            }
        }
    }
}