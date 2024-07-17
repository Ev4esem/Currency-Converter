package com.example.vktest.data.remove_source.entities

import com.example.vktest.domain.entities.Currency
import com.example.vktest.domain.entities.Data
import com.example.vktest.domain.entities.Meta
import com.example.vktest.domain.entities.currencies.ADA
import com.example.vktest.domain.entities.currencies.AED
import com.example.vktest.domain.entities.currencies.ALL
import com.google.gson.annotations.SerializedName

data class CurrencyDto(
    @SerializedName("data")
    val data: DataDto,
    @SerializedName("meta")
    val meta: MetaDto
)
