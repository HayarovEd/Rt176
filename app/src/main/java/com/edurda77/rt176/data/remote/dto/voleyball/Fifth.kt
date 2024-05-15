package com.edurda77.rt176.data.remote.dto.voleyball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fifth(
    @SerialName("away")
    val away: Any?,
    @SerialName("home")
    val home: Any?
)