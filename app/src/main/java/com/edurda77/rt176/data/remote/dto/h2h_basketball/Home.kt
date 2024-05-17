package com.edurda77.rt176.data.remote.dto.h2h_basketball


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Home(
    @SerialName("over_time")
    val overTime: Int?,
    @SerialName("quarter_1")
    val quarter1: Int?,
    @SerialName("quarter_2")
    val quarter2: Int?,
    @SerialName("quarter_3")
    val quarter3: Int?,
    @SerialName("quarter_4")
    val quarter4: Int?,
    @SerialName("total")
    val total: Int?
)