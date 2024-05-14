package com.edurda77.rt176.data.remote.dto

import kotlinx.serialization.SerialName


data class RemoteFootballRt176(
    @SerialName("events")
    val eventRt176s: List<EventRt176>,
)