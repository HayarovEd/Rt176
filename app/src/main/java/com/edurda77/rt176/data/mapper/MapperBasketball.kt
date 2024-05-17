package com.edurda77.rt176.data.mapper

import com.edurda77.rt176.data.remote.dto.basketball.BasketBallDto
import com.edurda77.rt176.data.remote.dto.h2h_basketball.H2hBasketballDto
import com.edurda77.rt176.data.remote.dto.h2h_football.H2hFootballDto
import com.edurda77.rt176.domain.model.BasketballMatchRt176
import com.edurda77.rt176.domain.model.H2HModel


fun BasketBallDto.convertToBasketBallMatches(): List<BasketballMatchRt176> {
    return this.response.map { response ->
        BasketballMatchRt176(
            timeStamp = response.date.substring(11, 16),
            dateStamp = response.date.substring(0, 10),
            statusGame = setStatusGame(response.status.short),
            currentTimeMatch = response.status.timer,
            awayId = response.teams.away.id,
            awayImage = response.teams.away.logo,
            awayScore = response.scores.away.total,
            awayQuarter1 = response.scores.away.quarter1,
            awayQuarter2 = response.scores.away.quarter2,
            awayQuarter3 = response.scores.away.quarter3,
            awayQuarter4 = response.scores.away.quarter4,
            awayName = response.teams.away.name,
            homeId = response.teams.home.id,
            homeImage = response.teams.home.logo,
            homeScore = response.scores.home.total,
            homeQuarter1 = response.scores.home.quarter1,
            homeQuarter2 = response.scores.home.quarter2,
            homeQuarter3 = response.scores.home.quarter3,
            homeQuarter4 = response.scores.home.quarter4,
            homeName = response.teams.home.name,
            isPlay = checkLiveGame(response.status.short)
        )
    }
}

fun H2hBasketballDto.convertBasketballToH2hModel(): List<H2HModel> {
    return this.response.map {
        H2HModel(
            homeName = it.teams.home.name,
            homeLogo = it.teams.home.logo,
            homeScore = it.scores.home.total,
            awayName = it.teams.away.name,
            awayLogo = it.teams.away.logo,
            awayScore = it.scores.away.total,
            dateOfMatch = it.date.substring(0, 10)
        )
    }
}

private fun setStatusGame(status: String): String {
    return when (status) {
        "NS" -> "СК"
        "Q1" -> "1Ч"
        "Q2" -> "2Ч"
        "Q3" -> "3Ч"
        "Q4" -> "4Ч"
        "HT", "BT" -> "ПР"
        "OT" -> "ОТ"
        "FT", "AOT" -> "ОК"
        "POST" -> "ОТЛ"
        else -> "ДРГ"
    }
}

private fun checkLiveGame(status: String): Boolean {
    return when (status) {
        "Q1", "Q2", "Q3", "Q4", "OT", "BT", "HT"  -> true
        else -> false
    }
}

