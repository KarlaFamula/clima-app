package com.example.climaapp.data.repository

import com.example.climaapp.data.remote.ForecastApiService
import com.example.climaapp.data.remote.GeocodingApiService
import com.example.climaapp.data.remote.dto.toDomainModel
import com.example.climaapp.domain.model.City
import com.example.climaapp.domain.model.WeatherForecast
import com.example.climaapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val geocodingApiService: GeocodingApiService,
    private val forecastApiService: ForecastApiService
) : WeatherRepository {

    override suspend fun searchCities(query: String): Result<List<City>> {
        return try {
            val response = geocodingApiService.searchCities(name = query)
            val cities = response.results?.map { it.toDomainModel() } ?: emptyList()
            Result.success(cities)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double
    ): Result<WeatherForecast> {
        return try {
            val response = forecastApiService.getWeatherForecast(
                latitude = latitude,
                longitude = longitude
            )
            val forecast = response.toDomainModel(cityId = 0)
            Result.success(forecast)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
