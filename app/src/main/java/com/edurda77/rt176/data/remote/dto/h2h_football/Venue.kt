package com.edurda77.rt176.data.remote.dto.h2h_football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Venue(
    @SerialName("city")
    val city: String,
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String
)