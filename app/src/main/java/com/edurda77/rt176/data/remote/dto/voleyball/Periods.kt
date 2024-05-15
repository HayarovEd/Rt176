package com.edurda77.rt176.data.remote.dto.voleyball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Periods(
    @SerialName("fifth")
    val fifth: Fifth,
    @SerialName("first")
    val first: First,
    @SerialName("fourth")
    val fourth: Fourth,
    @SerialName("second")
    val second: Second,
    @SerialName("third")
    val third: Third
)