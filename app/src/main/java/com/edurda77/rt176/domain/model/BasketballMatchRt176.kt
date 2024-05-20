package com.edurda77.rt176.domain.model

data class BasketballMatchRt176(
    val homeId: Int,
    val homeName: String,
    val homeImage: String,
    val homeScore: Int?,
    val homeQuarter1: Int?,
    val homeQuarter2: Int?,
    val homeQuarter3: Int?,
    val homeQuarter4: Int?,
    val awayId: Int,
    val awayName: String,
    val awayImage: String,
    val awayScore: Int?,
    val awayQuarter1: Int?,
    val awayQuarter2: Int?,
    val awayQuarter3: Int?,
    val awayQuarter4: Int?,
    val timeStamp: String,
    val dateStamp: String,
    val statusGame: String,
    val currentTimeMatch: Int?,
    val isPlay: Boolean,
    val awayColor:Int,
    val homeColor:Int,
)
