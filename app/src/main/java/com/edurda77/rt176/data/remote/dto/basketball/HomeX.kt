package com.edurda77.rt176.data.remote.dto.basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeX(
    @SerialName("id")
    val id: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val name: String
)