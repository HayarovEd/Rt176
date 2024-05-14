package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName

data class Extratime(
    @SerialName("away")
    val away: Any?,
    @SerialName("home")
    val home: Any?
)