package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Score(
    @SerialName("extratime")
    val extratime: Extratime,
    @SerialName("fulltime")
    val fulltime: Fulltime,
    @SerialName("halftime")
    val halftime: Halftime,
)