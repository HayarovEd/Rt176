package com.lo.mpm.matchs.oolimob.mobile.sports.omms.domain.model

data class FootballMatchRt176(
    val homeId: Int,
    val homeName: String,
    val homeImage: String,
    val homeScore: Int?,
    val homeScoreFirstTime: Int?,
    val homeScoreSecondTime: Int?,
    val awayId: Int,
    val awayName: String,
    val awayImage: String,
    val awayScore: Int?,
    val awayScoreFirstTime: Int?,
    val awayScoreSecondTime: Int?,
    val timeStamp: String,
    val dateStamp: String,
    val statusGame: String,
    val currentTimeMatch: Int?,
    val isPlay: Boolean,
    val awayColor:Int,
    val homeColor:Int,
)
