package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.h2h_hockey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("date")
    val date: String,
    @SerialName("scores")
    val scores: Scores,
    @SerialName("teams")
    val teams: Teams,

)