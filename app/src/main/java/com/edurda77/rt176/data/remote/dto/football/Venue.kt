package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
data class Venue(
    @SerialName("city")
    val city: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?
)