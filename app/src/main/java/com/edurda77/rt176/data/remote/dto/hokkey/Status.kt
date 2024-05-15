package com.edurda77.rt176.data.remote.dto.hokkey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Status(
    @SerialName("long")
    val long: String,
    @SerialName("short")
    val short: String
)