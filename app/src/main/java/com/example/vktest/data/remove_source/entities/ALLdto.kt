package com.example.vktest.data.remove_source.entities

import com.google.gson.annotations.SerializedName

data class ALLdto(
    @SerializedName("code")
    val code: String,
    @SerializedName("value")
    val value: Double
)
