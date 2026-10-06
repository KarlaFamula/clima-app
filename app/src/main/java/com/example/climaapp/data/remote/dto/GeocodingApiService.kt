package com.example.climaapp.data.remote.dto

import com.example.climaapp.data.remote.dto.GeocodingResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApiService {
    @GET("v1/search")
    suspend fun searchCities(
        @Query("name") name: String,
        @Query("count") count: Int = 10,
        @Query("language") language: String = "pt",
        @Query("format") format: String = "json"
    ): GeocodingResponseDto
}
