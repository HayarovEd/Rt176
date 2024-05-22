package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Periods(
    @SerialName("first")
    val first: Int?,
    @SerialName("second")
    val second: Int?
)