package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
data class Score(
    @SerialName("extratime")
    val extratime: Extratime,
    @SerialName("fulltime")
    val fulltime: Fulltime,
    @SerialName("halftime")
    val halftime: Halftime,
)