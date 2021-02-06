package com.example.foodstation.presenation.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.foodstation.common.base.BaseViewModel
import com.example.foodstation.data.sources.api.model.response.CityResponse
import com.example.foodstation.domain.AppResult
import com.example.foodstation.domain.usecases.CityUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val cityUseCase: CityUseCase
) :BaseViewModel(){

    fun getCompanyName() {
        viewModelScope.launch {
            when (val result = cityUseCase.getCity()) {
                is AppResult.Success<CityResponse> -> {
                    val res = result.data.status
//                    if (!res.isNullOrEmpty()) {
////                        _companyName.value = ""
//                    } else {
////                        _companyName.value = name
//                    }
                }
            }
        }
    }
}