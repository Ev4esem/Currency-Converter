package com.example.vktest.data.remove_source.entities

import com.google.gson.annotations.SerializedName

data class DataDto(
    @SerializedName("ADA")
    val ADA: ADAdto,
    @SerializedName("AED")
    val AED: AEDdto,
    @SerializedName("ALL")
    val ALL: ALLdto,
)
