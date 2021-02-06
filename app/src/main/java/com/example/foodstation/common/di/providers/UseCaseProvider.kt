package com.example.foodstation.common.di.providers

import com.example.foodstation.domain.usecases.CityUseCase
import com.example.foodstation.domain.usecases.CityUseCaseImpl

class UseCaseProvider(private val repositoryProvider: RepositoryProvider) {

    fun provideCityUseCase(): CityUseCase =
        CityUseCaseImpl(
            repositoryProvider.provideCityRepository()
        )
}