package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName
data class Paging(
    @SerialName("current")
    val current: Int,
    @SerialName("total")
    val total: Int
)