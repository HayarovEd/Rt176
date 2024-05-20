package com.edurda77.rt176.data.remote.dto.h2h_hockey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Scores(
    @SerialName("away")
    val away: Int?,
    @SerialName("home")
    val home: Int?
)