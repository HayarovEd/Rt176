package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Score(
    @SerialName("extratime")
    val extratime: Extratime,
    @SerialName("fulltime")
    val fulltime: Fulltime,
    @SerialName("halftime")
    val halftime: Halftime,
)