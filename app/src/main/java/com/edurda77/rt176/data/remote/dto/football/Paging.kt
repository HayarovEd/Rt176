package com.edurda77.rt176.data.remote.dto.football


import kotlinx.serialization.SerialName

import kotlinx.serialization.Serializable

@Serializable
data class Paging(
    @SerialName("current")
    val current: Int,
    @SerialName("total")
    val total: Int
)