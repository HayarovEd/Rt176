package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName


data class Away(
    @SerialName("id")
    val id: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val name: String,
    @SerialName("winner")
    val winner: Boolean?
)