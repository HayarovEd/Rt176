package com.edurda77.rt176.data.remote.dto.h2h_football


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