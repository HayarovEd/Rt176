package com.edurda77.rt176.data.remote.dto.hokkey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("country")
    val country: Country,
    @SerialName("date")
    val date: String,
    @SerialName("events")
    val events: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("league")
    val league: League,
    @SerialName("periods")
    val periods: Periods,
    @SerialName("scores")
    val scores: Scores,
    @SerialName("status")
    val status: Status,
    @SerialName("teams")
    val teams: Teams,
    @SerialName("time")
    val time: String,
    @SerialName("timer")
    val timer: Any?,
    @SerialName("timestamp")
    val timestamp: Int,
    @SerialName("timezone")
    val timezone: String,
    @SerialName("week")
    val week: String?
)