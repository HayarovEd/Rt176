package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.hokkey


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Home(
    @SerialName("id")
    val idRT176hcDto: Int,
    @SerialName("logo")
    val logo: String,
    @SerialName("name")
    val nameRT176hcDto: String
)