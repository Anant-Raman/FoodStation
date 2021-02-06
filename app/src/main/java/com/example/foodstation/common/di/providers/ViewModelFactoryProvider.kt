package com.example.foodstation.common.di.providers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodstation.presenation.home.HomeViewModel
import com.example.foodstation.presenation.main.MainActivityViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactoryProvider(private val useCaseProvider: UseCaseProvider) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MainActivityViewModel::class.java) -> {
                return MainActivityViewModel(
                    useCaseProvider.provideCityUseCase()
                ) as T
            }

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                return HomeViewModel(
                    useCaseProvider.provideCityUseCase()
                ) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}