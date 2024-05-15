package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fulltime(
    @SerialName("away")
    val away: Int?,
    @SerialName("home")
    val home: Int?
)