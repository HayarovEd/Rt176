package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("date")
    val dateBskRt176: String,
    @SerialName("id")
    val idBskRt176: Int,
    @SerialName("scores")
    val scores: Scores,
    @SerialName("stage")
    val stage: String?,
    @SerialName("status")
    val statusRt176Dto: Status,
    @SerialName("teams")
    val teams: Teams,
    @SerialName("time")
    val timeRt176Dto: String,
    @SerialName("timestamp")
    val timestampRt176Dto: Int,
    @SerialName("timezone")
    val timezoneRt176Dto: String,
    @SerialName("week")
    val week: String?
)