package com.example.foodstation.data.sources.api

import com.example.foodstation.data.sources.api.model.response.CityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getCity(
        @Url url: String,
        @HeaderMap headers: Map<String, String>,
        @Query("q") city: String
    ): Response<CityResponse>

}