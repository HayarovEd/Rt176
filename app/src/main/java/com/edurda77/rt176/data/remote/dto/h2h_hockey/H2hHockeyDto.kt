package com.edurda77.rt176.data.remote.dto.h2h_hockey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class H2hHockeyDto(
    @SerialName("errors")
    val errors: List<String>,
    @SerialName("get")
    val `get`: String,
    @SerialName("parameters")
    val parameters: Parameters,
    @SerialName("response")
    val response: List<Response>,
    @SerialName("results")
    val results: Int
)