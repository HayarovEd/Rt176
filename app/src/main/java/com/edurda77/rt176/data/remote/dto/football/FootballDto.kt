package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName


data class FootballDto(
    @SerialName("errors")
    val errors: List<Any>,
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