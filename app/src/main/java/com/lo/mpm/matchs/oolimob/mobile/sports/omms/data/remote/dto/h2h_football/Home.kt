package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.h2h_football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Home(
    @SerialName("id")
    val idRt176FtH2hDto: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val nameRt176FtH2hDto: String,
    @SerialName("winner")
    val winnerRt176FtH2hDto: Boolean?
)