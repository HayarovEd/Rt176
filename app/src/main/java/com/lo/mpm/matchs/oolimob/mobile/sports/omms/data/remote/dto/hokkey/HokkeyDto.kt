package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.hokkey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HokkeyDto(
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