package com.example.vktest.domain

import com.example.vktest.domain.entities.Currency
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    suspend fun getCurrencyList(): Currency

}