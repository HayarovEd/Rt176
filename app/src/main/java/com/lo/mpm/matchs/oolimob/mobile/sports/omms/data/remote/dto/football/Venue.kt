package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Venue(
    @SerialName("city")
    val city: String?,
    @SerialName("id")
    val idRt176FtDto: Int?,
    @SerialName("name")
    val nameRt176FtDto: String?
)