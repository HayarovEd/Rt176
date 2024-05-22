package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.h2h_football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("fixture")
    val fixture: Fixture,
    @SerialName("goals")
    val goals: Goals,
    @SerialName("teams")
    val teams: Teams
)