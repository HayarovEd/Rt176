package com.edurda77.rt176.data.remote.dto.h2h_football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Teams(
    @SerialName("away")
    val away: Away,
    @SerialName("home")
    val home: Home
)