package com.edurda77.rt176.data.mapper

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
            timeStamp = response.dateRt176HcDto.substring(11, 16),
            dateStamp = response.dateRt176HcDto.substring(0, 10),
            statusGame = setStatusGame(response.statusRt176HcDto.short),
            currentTimeMatch = response.timer,
            awayId = response.teams.away.id,
            awayImage = response.teams.away.logo,
            awayScore = response.scores.away,
            awayName = response.teams.away.name,
            homeId = response.teams.home.idRT176hcDto,
            homeImage = response.teams.home.logo,
            homeScore = response.scores.home,
            homeName = response.teams.home.nameRT176hcDto,
            scoreHomeFirstPeriod = scorePerPeriod1?.get(0),
            scoreHomeSecondPeriod = scorePerPeriod2?.get(0),
            scoreHomeThirdPeriod = scorePerPeriod3?.get(0),
            scoreAwayFirstPeriod = scorePerPeriod1?.get(1),
            scoreAwaySecondPeriod = scorePerPeriod2?.get(1),
            scoreAwayThirdPeriod = scorePerPeriod3?.get(1),
            scoreOverTime = response.periods.overtime,
            scorePenalties = response.periods.penalties,
            isPlay = checkLiveGame(response.statusRt176HcDto.short)
        )
    }
}

fun H2hHockeyDto.convertHockeyToH2hModel(): List<H2HModel> {
    return this.response.map {
        H2HModel(
            homeName = it.teams.home.nameRT176hcDto,
            homeLogo = it.teams.home.logo,
            homeScore = it.scores.home,
            awayName = it.teams.away.name,
            awayLogo = it.teams.away.logo,
            awayScore = it.scores.away,
            dateOfMatch = it.date.substring(0, 10)
        )
    }
}
private fun setStatusGame(statusHcRt176: String): String {
    return when (statusHcRt176) {
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

private fun checkLiveGame(statusHcRt176: String): Boolean {
    return when (statusHcRt176) {
        "P1", "P2", "P3", "OT", "PT", "BT"  -> true
        else -> false
    }
}

