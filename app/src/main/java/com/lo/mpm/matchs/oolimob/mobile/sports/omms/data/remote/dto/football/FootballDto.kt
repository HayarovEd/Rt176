package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


import kotlinx.serialization.SerialName

import kotlinx.serialization.Serializable

@Serializable
data class FootballDto(
    @SerialName("errors")
    val errors: List<String>,
    @SerialName("get")
    val getSt: String,
    @SerialName("paging")
    val pagingRt176FtDto: Paging,
    @SerialName("parameters")
    val parameters: Parameters,
    @SerialName("response")
    val response: List<Response>,
    @SerialName("results")
    val results: Int
)