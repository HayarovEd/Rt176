package com.edurda77.rt176.data.remote.dto.voleyball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class First(
    @SerialName("away")
    val away: Int?,
    @SerialName("home")
    val home: Int?
)