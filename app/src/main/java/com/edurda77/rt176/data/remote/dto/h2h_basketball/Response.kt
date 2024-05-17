package com.edurda77.rt176.data.remote.dto.h2h_basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("date")
    val date: String,
    @SerialName("scores")
    val scores: Scores,
    @SerialName("teams")
    val teams: Teams,
)