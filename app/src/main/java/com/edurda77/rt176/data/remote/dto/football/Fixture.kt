package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fixture(
    @SerialName("date")
    val dateRt176FtDto: String,
    @SerialName("id")
    val idRt176FtDto: Int,
    @SerialName("periods")
    val periods: Periods,
    @SerialName("referee")
    val referee: String?,
    @SerialName("status")
    val status: Status,
    @SerialName("timestamp")
    val timestampRt176FtDto: Int,
    @SerialName("timezone")
    val timezoneRt176FtDto: String,
    @SerialName("venue")
    val venue: Venue
)