package com.edurda77.rt176.data.remote.dto

import kotlinx.serialization.SerialName


data class HomeScoreRt176(
    @SerialName("current")
    val current: Int,
)