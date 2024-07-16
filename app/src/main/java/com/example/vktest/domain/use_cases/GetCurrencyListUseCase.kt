package com.example.vktest.domain.use_cases

import com.example.vktest.domain.CurrencyRepository
import com.example.vktest.domain.Result
import com.example.vktest.domain.entities.Currency
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrencyListUseCase @Inject constructor(private val repository: CurrencyRepository) {

    operator fun invoke(): Flow<List<Currency>> {
        return repository.getCurrencyList()
    }

}