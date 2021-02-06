package com.example.foodstation.data.sources.api

import android.util.Log
import com.example.foodstation.common.utils.ApiUrlBuilder
import com.example.foodstation.common.utils.ErrorCodes
import com.example.foodstation.data.ErrorMapper
import com.example.foodstation.data.sources.api.model.response.CityResponse
import com.example.foodstation.domain.AppError
import com.example.foodstation.domain.AppResult
import com.example.foodstation.domain.RetrofitResult
import retrofit2.Response

interface CityApi {
    suspend fun getCityFromApi(): AppResult<CityResponse>
}

class CityApiImpl(
    private val apiService: ApiService
) : CityApi {
    override suspend fun getCityFromApi(): AppResult<CityResponse> {

        var response: Response<CityResponse>? = null
        var exception: Exception? = null
        val accessToken = ApiUrlBuilder.getApiKey()

        try {
            response = apiService.getCity(
                ApiUrlBuilder.getBaseUrl(),
                DefaultHeaderBuilder.getDefaultHeaders(ContentType.URL_ENCODED, accessToken),
                "VARANASI"
            )
        } catch (e: Exception) {
            exception = e
        }


        return when (val result =
            ErrorMapper.checkAndMapError(response, exception)) {
            is RetrofitResult.Success -> {
                if (result.data != null) {
                    AppResult.Success(CityEntityMapper(result.data))
                } else {
                    AppResult.Failure(AppError(ErrorCodes.GENERIC_ERROR))
                }
            }

            is RetrofitResult.Failure -> AppResult.Failure(result.error)
        }
    }
}

/*---------------------------------------Entity Mappers-------------------------------------------*/

private fun CityEntityMapper(cityResponse: CityResponse): CityResponse {
    cityResponse.apply {
        return cityResponse
    }
}