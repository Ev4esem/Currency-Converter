package com.example.vktest.data.remove_source

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface CurrencyApi {

    @GET("v3/latest")
    suspend fun getCurrencyList(): List<CurrencyDto>

}