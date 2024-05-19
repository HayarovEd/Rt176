package com.edurda77.rt176.data.remote.dto.h2h_football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Away(
    @SerialName("id")
    val idRt176FtH2hDto: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val nameRt176FtH2hDto: String,
    @SerialName("winner")
    val winner: Boolean?
)