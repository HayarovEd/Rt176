package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Home(
    @SerialName("id")
    val idRt176FtHmDto: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val nameRt176Dto: String,
    @SerialName("winner")
    val winnerRt176Dto: Boolean?
)