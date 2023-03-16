package com.example.compose_weather_app.di

import com.example.compose_weather_app.common.Constants
import com.example.compose_weather_app.data.remote.CityApi
import com.example.compose_weather_app.data.remote.WeatherApi
import com.example.compose_weather_app.data.repository.CityRepositoryImpl
import com.example.compose_weather_app.data.repository.WeatherRepositoryImpl
import com.example.compose_weather_app.domain.repository.CityRepository
import com.example.compose_weather_app.domain.repository.WeatherRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCityApi(): CityApi {
        return Retrofit.Builder()
            .baseUrl(Constants.CITIES_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(CityApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCityRepository(api: CityApi): CityRepository {
        return CityRepositoryImpl(api)
    }

}