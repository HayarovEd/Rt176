package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
data class Status(
    @SerialName("elapsed")
    val elapsed: Int?,
    @SerialName("long")
    val long: String,
    @SerialName("short")
    val short: String
)