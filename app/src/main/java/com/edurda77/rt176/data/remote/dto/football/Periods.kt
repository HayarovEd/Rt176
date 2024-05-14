package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
data class Periods(
    @SerialName("first")
    val first: Int?,
    @SerialName("second")
    val second: Int?
)