package com.example.foodstation.domain.usecases

import com.example.foodstation.data.repository.CityRepository
import com.example.foodstation.data.sources.api.model.response.CityResponse
import com.example.foodstation.domain.AppResult

interface CityUseCase {
    suspend fun getCity(): AppResult<CityResponse>
}

class CityUseCaseImpl(
    private val CityRepository: CityRepository
) : CityUseCase {

    override suspend fun getCity(): AppResult<CityResponse> = CityRepository.getCityCode()
}