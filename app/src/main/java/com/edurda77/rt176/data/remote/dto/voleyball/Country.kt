package com.edurda77.rt176.data.remote.dto.voleyball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("code")
    val code: Any?,
    @SerialName("flag")
    val flag: Any?,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)