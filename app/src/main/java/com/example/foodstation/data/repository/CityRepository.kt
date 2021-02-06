package com.example.foodstation.data.repository

import android.util.Log
import com.example.foodstation.data.sources.api.CityApi
import com.example.foodstation.data.sources.api.model.response.CityResponse
import com.example.foodstation.domain.AppResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface CityRepository {
    suspend fun getCityCode(): AppResult<CityResponse>
}

class CityRepositoryImpl(
    private val cityApi: CityApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : CityRepository {

    override suspend fun getCityCode(): AppResult<CityResponse> {
        return withContext(dispatcher) {
                cityApi.getCityFromApi()
        }
    }
}