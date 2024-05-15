package com.edurda77.rt176.data.mapper

import com.edurda77.rt176.data.remote.dto.football.FootballDto
import com.edurda77.rt176.domain.model.FootballMatchRt176


fun FootballDto.convertToFootballMatches(): List<FootballMatchRt176> {
    return this.response.map { response ->
        FootballMatchRt176(
            timeStamp = response.fixture.date.substring(11, 16),
            dateStamp = response.fixture.date.substring(0, 10),
            statusGame = setStatusGame(response.fixture.status.short),
            currentTimeMatch = response.fixture.status.elapsed,
            awayId = response.teams.away.id,
            awayImage = response.teams.away.logo,
            awayScore = response.goals.away,
            awayScoreFirstTime = response.score.halftime.away,
            awayScoreSecondTime = response.score.fulltime.away,
            awayName = response.teams.away.name,
            homeId = response.teams.home.id,
            homeImage = response.teams.home.logo,
            homeScore = response.goals.home,
            homeScoreFirstTime = response.score.halftime.home,
            homeScoreSecondTime = response.score.halftime.away,
            homeName = response.teams.home.name,
        )
    }
}


private fun setStatusGame(status: String): String {
    return when (status) {
        "TBD", "NS" -> "Запланирован"
        "1H" -> "Первый тайм"
        "HT" -> "Перерыв"
        "2H" -> "Второй тайм"
        "ET", "BT" -> "Дополнительное время"
        "P" -> "Серия Пенальти"
        "SUSP", "INT" -> "Приостановлен"
        "FT", "AET", "PEN" -> "Окончен"
        "PST" -> "Перенесен"
        "CANC" -> "Отменен"
        "AWD", "WO" -> "Не сыгран"
        else -> "Другое"
    }
}

