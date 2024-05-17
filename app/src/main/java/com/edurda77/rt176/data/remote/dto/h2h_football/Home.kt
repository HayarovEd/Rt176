package com.edurda77.rt176.data.remote.dto.h2h_football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Home(
    @SerialName("id")
    val id: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val name: String,
    @SerialName("winner")
    val winner: Boolean?
)