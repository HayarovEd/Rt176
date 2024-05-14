package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
data class Teams(
    @SerialName("away")
    val away: Away,
    @SerialName("home")
    val home: Home
)