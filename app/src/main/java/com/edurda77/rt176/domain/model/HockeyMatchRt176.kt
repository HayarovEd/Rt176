package com.edurda77.rt176.domain.model

data class HockeyMatchRt176(
    val homeId: Int,
    val homeName: String,
    val homeImage: String,
    val homeScore: Int?,
    val awayId: Int,
    val awayName: String,
    val awayImage: String,
    val awayScore: Int?,
    val timeStamp: String,
    val dateStamp: String,
    val statusGame: String,
    val currentTimeMatch: Int?,
    val scoreFirstPeriod: String?,
    val scoreSecondPeriod: String?,
    val scoreThirdPeriod: String?,
    val scoreOverTime: String?,
    val scorePenalties: String?,
    val isPlay: Boolean,
)
