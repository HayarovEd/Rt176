package com.edurda77.rt176.data.remote.dto.h2h_football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class H2hFootballDto(
    @SerialName("errors")
    val errors: List<String>,
    @SerialName("get")
    val `get`: String,
    @SerialName("paging")
    val paging: Paging,
    @SerialName("parameters")
    val parameters: Parameters,
    @SerialName("response")
    val response: List<Response>,
    @SerialName("results")
    val results: Int
)