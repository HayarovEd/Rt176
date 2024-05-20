package com.edurda77.rt176.domain.model

data class H2HModel(
    val homeName:String,
    val homeLogo:String,
    val homeScore:Int?,
    val awayName:String,
    val awayLogo:String,
    val awayScore:Int?,
    val dateOfMatch: String,
)
