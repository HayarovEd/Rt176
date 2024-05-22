package com.lo.mpm.matchs.oolimob.mobile.sports.omms.domain.model

data class H2HModel(
    val homeName:String,
    val homeLogo:String,
    val homeScore:Int?,
    val awayName:String,
    val awayLogo:String,
    val awayScore:Int?,
    val dateOfMatch: String,
)
