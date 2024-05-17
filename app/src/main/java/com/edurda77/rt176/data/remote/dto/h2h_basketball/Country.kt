package com.edurda77.rt176.data.remote.dto.h2h_basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("code")
    val code: String,
    @SerialName("flag")
    val flag: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)