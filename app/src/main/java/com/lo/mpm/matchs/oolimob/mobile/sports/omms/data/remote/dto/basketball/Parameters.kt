package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Parameters(
    @SerialName("date")
    val date: String
)