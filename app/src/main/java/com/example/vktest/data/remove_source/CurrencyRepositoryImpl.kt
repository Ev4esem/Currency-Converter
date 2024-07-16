package com.example.vktest.data.remove_source

import com.example.vktest.domain.CurrencyRepository
import com.example.vktest.domain.entities.Currency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyApi: CurrencyApi
): CurrencyRepository {
    override fun getCurrencyList(): Flow<List<Currency>> = flow {
        val currency = currencyApi.getCurrencyList().toCurrencyList()
        emit(currency)
    }

    override suspend fun getCurrencyById(currencyId: String): Currency? {
        val currencyDto = currencyApi.getCurrencyList().firstOrNull {
            it.code == currencyId
        }
        val currency = currencyDto?.toCurrency()
        return currency
    }

    override fun converterCurrency(one: Double, two: Double): Double {
        return one / two
    }
}