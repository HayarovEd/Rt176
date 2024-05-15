package com.edurda77.rt176.data.remote.dto.basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Teams(
    @SerialName("away")
    val away: AwayX,
    @SerialName("home")
    val home: HomeX
)