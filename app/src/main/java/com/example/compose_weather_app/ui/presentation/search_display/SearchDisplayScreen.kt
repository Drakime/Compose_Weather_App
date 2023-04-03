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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchDisplayScreen(
    viewModel: SearchDisplayViewModel = hiltViewModel(),
    navController: NavController
) {
    val searchText = viewModel.searchText
    val cities = viewModel.cities.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchText.value,
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { viewModel.searchLocation(searchText.value) }),
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search") }
        )
        Spacer(modifier = Modifier.height(16.dp))
//        if (isSearching) {
//            Box(modifier = Modifier.fillMaxSize()) {
//                CircularProgressIndicator(
//                    modifier = Modifier.align(Alignment.Center)
//                )
//            }
//        } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            if (cities.isNotEmpty()) {
                items(cities) { city ->
                    Box(
                        modifier = Modifier
                            .clickable(onClick = { /* TODO */ })
                            .padding(bottom = 16.dp)
                    ) {
                        Column {
                            Text(
                                text = city.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Text(
                                text = city.country,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            } else if (cities.isEmpty() && searchText.value != "") {
                item {
                    Box {
                        Text(
                            text = "Location not found",
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}