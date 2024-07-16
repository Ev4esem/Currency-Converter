package com.example.vktest.domain.use_cases

import com.example.vktest.domain.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConverterCurrencyUseCase @Inject constructor (private val repository: CurrencyRepository) {
    operator fun invoke(one: Double, two: Double): Double {
        return repository.converterCurrency(one, two)
    }
}