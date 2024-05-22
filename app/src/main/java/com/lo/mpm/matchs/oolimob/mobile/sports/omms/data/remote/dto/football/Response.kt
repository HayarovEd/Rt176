package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


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