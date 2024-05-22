package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Status(
    @SerialName("long")
    val long: String,
    @SerialName("short")
    val short: String,
    @SerialName("timer")
    val timer: Int?
)