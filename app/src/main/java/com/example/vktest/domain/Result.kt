package com.example.vktest.domain

import com.example.vktest.domain.entities.Currency

sealed class Result {
    data object Loading : Result()
    data object Error : Result()
    data class Success(val data: List<Currency>) : Result()
}