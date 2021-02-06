package com.example.foodstation.common.di.providers

import com.example.foodstation.data.repository.CityRepository
import com.example.foodstation.data.repository.CityRepositoryImpl

class RepositoryProvider(
    apiSourceProvider: ApiSourceProvider
) {
    private val cityRepository: CityRepository by lazy {
        CityRepositoryImpl(
            apiSourceProvider.provideProfileApi(),
        )
    }



    /*-------------------------------Public -----------------------------*/

    fun provideCityRepository(): CityRepository = cityRepository

}