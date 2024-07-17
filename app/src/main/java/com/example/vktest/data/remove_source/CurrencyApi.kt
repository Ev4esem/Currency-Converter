package com.example.vktest.data.remove_source

import com.example.vktest.data.remove_source.entities.CurrencyDto
import retrofit2.http.GET

interface CurrencyApi {

    @GET("v3/latest")
    suspend fun getCurrencyList(): CurrencyDto

}