package com.edurda77.rt176.data.remote.dto.basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Parameters(
    @SerialName("date")
    val date: String
)