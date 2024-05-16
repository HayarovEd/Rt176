package com.edurda77.rt176.data.mapper

import com.edurda77.rt176.data.remote.dto.hokkey.HokkeyDto
import com.edurda77.rt176.domain.model.HockeyMatchRt176


fun HokkeyDto.convertToHokkeyMatches(): List<HockeyMatchRt176> {
    return this.response.map { response ->
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
            scoreFirstPeriod = response.periods.first,
            scoreSecondPeriod = response.periods.second,
            scoreThirdPeriod = response.periods.third,
            scoreOverTime = response.periods.overtime,
            scorePenalties = response.periods.penalties,
            isPlay = checkLiveGame(response.status.short)
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

