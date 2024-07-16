package com.example.vktest.domain

import com.example.vktest.domain.entities.Currency
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    fun getCurrencyList(): Flow<List<Currency>>

    suspend fun getCurrencyById(currencyId: String): Currency?

    fun converterCurrency(one: Double, two: Double): Double

}