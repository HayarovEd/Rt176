package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName

data class Fulltime(
    @SerialName("away")
    val away: Int?,
    @SerialName("home")
    val home: Int?
)