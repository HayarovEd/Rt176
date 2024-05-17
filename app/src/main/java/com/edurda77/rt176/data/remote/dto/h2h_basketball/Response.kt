package com.edurda77.rt176.data.remote.dto.h2h_basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("country")
    val country: Country,
    @SerialName("date")
    val date: String,
    @SerialName("id")
    val id: Int,
    @SerialName("league")
    val league: League,
    @SerialName("scores")
    val scores: Scores,
    @SerialName("stage")
    val stage: String?,
    @SerialName("status")
    val status: Status,
    @SerialName("teams")
    val teams: Teams,
    @SerialName("time")
    val time: String,
    @SerialName("timestamp")
    val timestamp: Int,
    @SerialName("timezone")
    val timezone: String,
    @SerialName("week")
    val week: String
)