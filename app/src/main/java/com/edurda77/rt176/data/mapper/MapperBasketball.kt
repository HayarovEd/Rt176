package com.edurda77.rt176.data.mapper

import com.edurda77.rt176.data.remote.dto.basketball.BasketBallDto
import com.edurda77.rt176.data.remote.dto.h2h_basketball.H2hBasketballDto
import com.edurda77.rt176.domain.model.BasketballMatchRt176
import com.edurda77.rt176.domain.model.H2HModel
import com.edurda77.rt176.domain.utils.generateRandomColorRt175


fun BasketBallDto.convertToBasketBallMatches(): List<BasketballMatchRt176> {
    return this.response.map { response ->
        BasketballMatchRt176(
            timeStamp = response.dateBskRt176.substring(11, 16),
            dateStamp = response.dateBskRt176.substring(0, 10),
            statusGame = setStatusGame(response.statusRt176Dto.short),
            currentTimeMatch = response.statusRt176Dto.timer,
            awayId = response.teams.away.id,
            awayImage = response.teams.away.logo,
            awayScore = response.scores.away.total,
            awayQuarter1 = response.scores.away.quarter1,
            awayQuarter2 = response.scores.away.quarter2,
            awayQuarter3 = response.scores.away.quarter3,
            awayQuarter4 = response.scores.away.quarter4,
            awayName = response.teams.away.name,
            homeId = response.teams.home.idRt176bskDtoX,
            homeImage = response.teams.home.logo,
            homeScore = response.scores.home.total,
            homeQuarter1 = response.scores.home.quarter1,
            homeQuarter2 = response.scores.home.quarter2,
            homeQuarter3 = response.scores.home.quarter3,
            homeQuarter4 = response.scores.home.quarter4,
            homeName = response.teams.home.nameRt176bskDtoX,
            isPlay = checkLiveGame(response.statusRt176Dto.short),
            awayColor = generateRandomColorRt175(),
            homeColor = generateRandomColorRt175()
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

private fun setStatusGame(statusBskRt176: String): String {
    return when (statusBskRt176) {
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

private fun checkLiveGame(statusBskRt176: String): Boolean {
    return when (statusBskRt176) {
        "Q1", "Q2", "Q3", "Q4", "OT", "BT", "HT"  -> true
        else -> false
    }
}

