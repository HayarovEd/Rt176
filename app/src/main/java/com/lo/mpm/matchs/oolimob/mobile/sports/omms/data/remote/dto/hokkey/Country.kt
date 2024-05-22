package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.hokkey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("code")
    val code: String?,
    @SerialName("flag")
    val flag: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)