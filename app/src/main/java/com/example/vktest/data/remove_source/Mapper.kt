package com.example.vktest.data.remove_source

import com.example.vktest.data.remove_source.entities.ADAdto
import com.example.vktest.data.remove_source.entities.AEDdto
import com.example.vktest.data.remove_source.entities.ALLdto
import com.example.vktest.data.remove_source.entities.CurrencyDto
import com.example.vktest.data.remove_source.entities.DataDto
import com.example.vktest.data.remove_source.entities.MetaDto
import com.example.vktest.domain.entities.Currency
import com.example.vktest.domain.entities.Data
import com.example.vktest.domain.entities.Meta
import com.example.vktest.domain.entities.currencies.ADA
import com.example.vktest.domain.entities.currencies.AED
import com.example.vktest.domain.entities.currencies.ALL


fun CurrencyDto.toCurrency() = Currency(
    data = data.toData(),
    meta = meta.toMeta()
)

fun MetaDto.toMeta() = Meta(
    last_updated_at = last_updated_at
)

fun DataDto.toData() = Data(
    ADA = ADA.toADA(),
    AED = AED.toAED(),
    ALL = ALL.toAFN()
)

fun ADAdto.toADA() = ADA(
    code = code,
    value = value
)
fun AEDdto.toAED() = AED(
    code = code,
    value = value
)
fun ALLdto.toAFN() = ALL(
    code = code,
    value = value
)

