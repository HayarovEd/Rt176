package com.edurda77.rt176.data.remote.dto.voleyball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Away(
    @SerialName("id")
    val id: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val name: String
)