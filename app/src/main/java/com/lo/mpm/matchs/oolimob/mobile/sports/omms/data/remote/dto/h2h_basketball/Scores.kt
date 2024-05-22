package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.h2h_basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Scores(
    @SerialName("away")
    val away: Away,
    @SerialName("home")
    val home: Home
)