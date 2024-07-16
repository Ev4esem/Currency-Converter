package com.example.vktest.data.remove_source

import com.example.vktest.domain.entities.Currency

data class CurrencyDto(
    val code: String,
    val value: Double
)

fun CurrencyDto.toCurrency() = Currency(
    code = code,
    value = value
)

fun List<CurrencyDto>.toCurrencyList(): List<Currency> {
    return map { it.toCurrency() }
}
