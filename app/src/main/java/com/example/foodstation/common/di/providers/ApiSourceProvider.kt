package com.example.foodstation.common.di.providers

import com.example.foodstation.data.sources.api.CityApi
import com.example.foodstation.data.sources.api.CityApiImpl

/**
 * Provides Constructor dependencies to all api sources present in app
 **/

class ApiSourceProvider(private val retrofitProvider: RetrofitProvider) {

    fun provideProfileApi(): CityApi =
        CityApiImpl(
            retrofitProvider.provideService()
        )
}