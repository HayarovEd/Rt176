package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Status(
    @SerialName("elapsed")
    val elapsed: Int?,
    @SerialName("long")
    val long: String,
    @SerialName("short")
    val short: String
)