package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class Halftime(
    @SerialName("away")
    val away: Int?,
    @SerialName("home")
    val home: Int?
)