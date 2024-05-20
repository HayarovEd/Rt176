package com.edurda77.rt176.data.remote.dto.hokkey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("country")
    val country: Country,
    @SerialName("date")
    val dateRt176HcDto: String,
    @SerialName("events")
    val eventsRt176HcDto: Boolean,
    @SerialName("id")
    val idRt176HcDto: Int,
    @SerialName("periods")
    val periods: Periods,
    @SerialName("scores")
    val scores: Scores,
    @SerialName("status")
    val statusRt176HcDto: Status,
    @SerialName("teams")
    val teams: Teams,
    @SerialName("time")
    val timeRt176Dto: String,
    @SerialName("timer")
    val timer: Int?,
    @SerialName("timestamp")
    val timestampRt176HcDto: Int,
    @SerialName("timezone")
    val timezoneRt176HcDto: String,
    @SerialName("week")
    val week: String?
)