package com.edurda77.rt176.data.remote.dto.h2h_hockey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class League(
    @SerialName("id")
    val id: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val name: String,
    @SerialName("season")
    val season: Int,
    @SerialName("type")
    val type: String
)