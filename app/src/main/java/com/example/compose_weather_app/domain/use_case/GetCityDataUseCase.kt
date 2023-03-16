package com.example.compose_weather_app.domain.use_case

import com.example.compose_weather_app.common.Resource
import com.example.compose_weather_app.data.remote.dto.CityDto
import com.example.compose_weather_app.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCityDataUseCase @Inject constructor(
    private val repository: CityRepository
) {

    operator fun invoke(): Flow<Resource<List<CityDto>>> = flow {
        try {
            emit(Resource.Loading())
            val cityData = repository.getCities()
            emit(Resource.Success(cityData))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}