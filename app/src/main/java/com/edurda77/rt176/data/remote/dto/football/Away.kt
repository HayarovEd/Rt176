package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Away(
    @SerialName("id")
    val idRt176AwFtDto: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val nameRt176AwFtDto: String,
    @SerialName("winner")
    val winner: Boolean?
)