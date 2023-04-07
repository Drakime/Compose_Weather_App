package com.example.compose_weather_app.ui.presentation.search_display

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchDisplayScreen(
    viewModel: SearchDisplayViewModel = hiltViewModel(),
    navController: NavController
) {
    val searchText = viewModel.searchText
    val cities = viewModel.cities.value
    val isSearching by viewModel.isSearching.collectAsState()

    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchText.value,
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                scope.launch {
                    focusManager.clearFocus()
                    viewModel.searchLocation(
                        searchText.value
                    )
                }
            }),
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (isSearching) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                if (cities.isNotEmpty()) {
                    items(cities) { city ->
                        Box(
                            modifier = Modifier
                                .clickable(onClick = {
                                    viewModel.updateLocation(
                                        latitudeValue = city.latitude.toString(),
                                        longitudeValue = city.longitude.toString(),
                                        locationValue = city.name
                                    )
                                    navController.navigateUp()
                                })
                                .padding(bottom = 16.dp)
                        ) {
                            Column {
                                Text(
                                    text = city.name,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
                                if (city.admin1 != "") {
                                    Text(
                                        text = "${city.country}, ${city.admin1}",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    )
                                } else {
                                    Text(
                                        text = city.country,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}