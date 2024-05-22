package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.h2h_hockey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class H2hHockeyDto(
    @SerialName("response")
    val response: List<Response>,
)