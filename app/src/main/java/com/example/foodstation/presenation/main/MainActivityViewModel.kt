package com.example.foodstation.presenation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodstation.common.base.BaseViewModel
import com.example.foodstation.data.sources.api.model.response.CityResponse
import com.example.foodstation.domain.AppResult
import com.example.foodstation.domain.usecases.CityUseCase
import com.example.foodstation.presenation.Event
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val cityUseCase: CityUseCase
) : BaseViewModel() {


    /*------------------------------------------------Live Data--------------------------------------------------*/

    private val _isInternetAvailableLiveData: MutableLiveData<Event<Boolean>> = MutableLiveData()
    val isInternetAvailableLiveData: LiveData<Event<Boolean>> get() = _isInternetAvailableLiveData


    /*---------------------------------------Internet Error Info -----------------------------------------------*/

//    fun registerInternetStatus() {
//        viewModelScope.launch {
//            internetUseCase.receiveInternetStatus().collect {
//                _isInternetAvailableLiveData.value = Event(it)
//            }
//        }
//    }

    fun getCompanyName() {
        viewModelScope.launch {
            when (val result = cityUseCase.getCity()) {
                is AppResult.Success<CityResponse> -> {
                    val res = result.data.status
                    if (!res.isNullOrEmpty()) {
//                        _companyName.value = ""
                    } else {
//                        _companyName.value = name
                    }
                }
            }
        }
    }
}