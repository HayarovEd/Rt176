package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class League(
    @SerialName("country")
    val country: String,
    @SerialName("flag")
    val flag: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val name: String,
    @SerialName("round")
    val round: String,
    @SerialName("season")
    val season: Int
)