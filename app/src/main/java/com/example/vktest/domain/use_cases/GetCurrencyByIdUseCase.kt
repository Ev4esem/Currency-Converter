package com.example.vktest.domain.use_cases

import com.example.vktest.domain.CurrencyRepository
import com.example.vktest.domain.entities.Currency
import javax.inject.Inject

class GetCurrencyByIdUseCase @Inject constructor(private val repository: CurrencyRepository) {

    operator fun invoke(currencyId: String): Currency {
        return repository.getCurrencyById(currencyId)
    }

}