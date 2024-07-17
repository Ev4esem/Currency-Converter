package com.example.vktest.data.remove_source

import com.example.vktest.domain.CurrencyRepository
import com.example.vktest.domain.entities.Currency
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyApi: CurrencyApi
): CurrencyRepository {
    override suspend fun getCurrencyList(): Currency {
        return currencyApi.getCurrencyList().toCurrency()
    }

}