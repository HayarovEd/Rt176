package com.edurda77.rt176.data.remote.dto.h2h_hockey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Periods(
    @SerialName("first")
    val first: String?,
    @SerialName("overtime")
    val overtime: String?,
    @SerialName("penalties")
    val penalties: String?,
    @SerialName("second")
    val second: String?,
    @SerialName("third")
    val third: String?
)