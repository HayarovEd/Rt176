package com.edurda77.rt176.data.mapper

import com.edurda77.rt176.data.remote.dto.football.FootballDto
import com.edurda77.rt176.data.remote.dto.hokkey.HokkeyDto
import com.edurda77.rt176.domain.model.FootballMatchRt176
import com.edurda77.rt176.domain.model.HokkeyMatchRt176


fun HokkeyDto.convertToHokkeyMatches(): List<HokkeyMatchRt176> {
    return this.response.map { response ->
        HokkeyMatchRt176(
            timeStamp = response.date.substring(11, 16),
            dateStamp = response.date.substring(0, 10),
            statusGame = setStatusGame(response.status.short),
            currentTimeMatch = response.timer.toString(),
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
            scorePenalties = response.periods.penalties
        )
    }
}


private fun setStatusGame(status: String): String {
    return when (status) {
        "NS" -> "Запланирован"
        "P1" -> "Первый пероид"
        "P2" -> "Второй пероид"
        "P3" -> "Третий пероид"
        "OT" -> "Овертайм"
        "PT" -> "Буллиты"
        "BT" -> "Перерыв"
        "POST" -> "Отложен"
        "FT", "AOT", "AP" -> "Окончен"
        "CANC" -> "Отменен"
        else -> "Другое"
    }
}

