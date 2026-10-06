package com.example.climaapp.domain.repository

import com.example.climaapp.domain.model.City
import com.example.climaapp.domain.model.WeatherForecast

interface WeatherRepository {
    suspend fun searchCities(query: String): Result<List<City>>
    suspend fun getWeatherForecast(latitude: Double, longitude: Double): Result<WeatherForecast>
}
