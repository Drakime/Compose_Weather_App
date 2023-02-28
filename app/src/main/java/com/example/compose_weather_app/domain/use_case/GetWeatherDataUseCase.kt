package com.example.compose_weather_app.domain.use_case

import com.example.compose_weather_app.common.Resource
import com.example.compose_weather_app.data.remote.dto.toWeatherData
import com.example.compose_weather_app.domain.model.WeatherData
import com.example.compose_weather_app.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherDataUseCase {
    class GetWeatherDataUseCase @Inject constructor(
        private val repository: WeatherRepository
    ) {
        operator fun invoke(): Flow<Resource<WeatherData>> = flow {
            try {
                emit(Resource.Loading())
                val weatherData = repository.getWeather()
                emit(Resource.Success(weatherData.toWeatherData()))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server. Check your internet connection"))
            }
        }
    }
}