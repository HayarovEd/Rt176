package com.edurda77.rt176.data.remote.dto.h2h_football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("fixture")
    val fixture: Fixture,
    @SerialName("goals")
    val goals: Goals,
    @SerialName("league")
    val league: League,
    @SerialName("score")
    val score: Score,
    @SerialName("teams")
    val teams: Teams
)