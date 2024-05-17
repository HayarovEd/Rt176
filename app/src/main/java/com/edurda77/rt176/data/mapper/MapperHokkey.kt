package com.edurda77.rt176.data.mapper

import com.edurda77.rt176.data.remote.dto.h2h_football.H2hFootballDto
import com.edurda77.rt176.data.remote.dto.h2h_hockey.H2hHockeyDto
import com.edurda77.rt176.data.remote.dto.hokkey.HokkeyDto
import com.edurda77.rt176.domain.model.H2HModel
import com.edurda77.rt176.domain.model.HockeyMatchRt176


fun HokkeyDto.convertToHokkeyMatches(): List<HockeyMatchRt176> {
    return this.response.map { response ->
        val scorePerPeriod1 = if (response.periods.first!=null) response.periods.first.split("-") else null
        val scorePerPeriod2 = if (response.periods.second!=null) response.periods.second.split("-") else null
        val scorePerPeriod3 = if (response.periods.third!=null) response.periods.third.split("-") else null
        HockeyMatchRt176(
            timeStamp = response.date.substring(11, 16),
            dateStamp = response.date.substring(0, 10),
            statusGame = setStatusGame(response.status.short),
            currentTimeMatch = response.timer,
            awayId = response.teams.away.id,
            awayImage = response.teams.away.logo,
            awayScore = response.scores.away,
            awayName = response.teams.away.name,
            homeId = response.teams.home.id,
            homeImage = response.teams.home.logo,
            homeScore = response.scores.home,
            homeName = response.teams.home.name,
            scoreHomeFirstPeriod = scorePerPeriod1?.get(0),
            scoreHomeSecondPeriod = scorePerPeriod2?.get(0),
            scoreHomeThirdPeriod = scorePerPeriod3?.get(0),
            scoreAwayFirstPeriod = scorePerPeriod1?.get(1),
            scoreAwaySecondPeriod = scorePerPeriod2?.get(1),
            scoreAwayThirdPeriod = scorePerPeriod3?.get(1),
            scoreOverTime = response.periods.overtime,
            scorePenalties = response.periods.penalties,
            isPlay = checkLiveGame(response.status.short)
        )
    }
}

fun H2hHockeyDto.convertHockeyToH2hModel(): List<H2HModel> {
    return this.response.map {
        H2HModel(
            homeName = it.teams.home.name,
            homeLogo = it.teams.home.logo,
            homeScore = it.scores.home,
            awayName = it.teams.away.name,
            awayLogo = it.teams.away.logo,
            awayScore = it.scores.away,
            dateOfMatch = it.date.substring(0, 10)
        )
    }
}
private fun setStatusGame(status: String): String {
    return when (status) {
        "NS" -> "СК"
        "P1" -> "1П"
        "P2" -> "2П"
        "P3" -> "3П"
        "OT" -> "ОТ"
        "PT" -> "БЛ"
        "BT" -> "ПР"
        "POST" -> "ОТЛ"
        "FT", "AOT", "AP" -> "ОК"
        else -> "ДРГ"
    }
}

private fun checkLiveGame(status: String): Boolean {
    return when (status) {
        "P1", "P2", "P3", "OT", "PT", "BT"  -> true
        else -> false
    }
}

