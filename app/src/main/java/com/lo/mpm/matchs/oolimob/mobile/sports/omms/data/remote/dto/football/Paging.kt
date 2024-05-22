package com.lo.mpm.matchs.oolimob.mobile.sports.omms.data.remote.dto.football


import kotlinx.serialization.SerialName

import kotlinx.serialization.Serializable

@Serializable
data class Paging(
    @SerialName("current")
    val current: Int,
    @SerialName("total")
    val total: Int
)