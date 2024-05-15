package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fixture(
    @SerialName("date")
    val date: String,
    @SerialName("id")
    val id: Int,
    @SerialName("periods")
    val periods: Periods,
    @SerialName("referee")
    val referee: String?,
    @SerialName("status")
    val status: Status,
    @SerialName("timestamp")
    val timestamp: Int,
    @SerialName("timezone")
    val timezone: String,
    @SerialName("venue")
    val venue: Venue
)