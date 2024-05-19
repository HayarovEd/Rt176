package com.edurda77.rt176.data.mapper

import com.edurda77.rt176.data.remote.dto.football.FootballDto
import com.edurda77.rt176.data.remote.dto.h2h_football.H2hFootballDto
import com.edurda77.rt176.domain.model.FootballMatchRt176
import com.edurda77.rt176.domain.model.H2HModel


fun FootballDto.convertToFootballMatches(): List<FootballMatchRt176> {
    return this.response.map { response ->
        FootballMatchRt176(
            timeStamp = response.fixture.dateRt176FtDto.substring(11, 16),
            dateStamp = response.fixture.dateRt176FtDto.substring(0, 10),
            statusGame = setStatusGame(response.fixture.status.short),
            currentTimeMatch = response.fixture.status.elapsed,
            awayId = response.teams.away.idRt176AwFtDto,
            awayImage = response.teams.away.logo,
            awayScore = response.goals.away,
            awayScoreFirstTime = response.score.halftime.away,
            awayScoreSecondTime = response.score.fulltime.away,
            awayName = response.teams.away.nameRt176AwFtDto,
            homeId = response.teams.home.idRt176FtHmDto,
            homeImage = response.teams.home.logo,
            homeScore = response.goals.home,
            homeScoreFirstTime = response.score.halftime.home,
            homeScoreSecondTime = response.score.halftime.away,
            homeName = response.teams.home.nameRt176Dto,
            isPlay = checkLiveGame(response.fixture.status.short)
        )
    }
}

fun H2hFootballDto.convertFottballToH2hModel(): List<H2HModel> {
    return this.response.map {
        H2HModel(
            homeName = it.teams.home.nameRt176FtH2hDto,
            homeLogo = it.teams.home.logo,
            homeScore = it.goals.home,
            awayName = it.teams.away.nameRt176FtH2hDto,
            awayLogo = it.teams.away.logo,
            awayScore = it.goals.away,
            dateOfMatch = it.fixture.date.substring(0, 10)
        )
    }
}
private fun setStatusGame(statusFtRt176: String): String {
    return when (statusFtRt176) {
        "TBD", "NS" -> "СК"
        "1H" -> "1Т"
        "HT" -> "ПР"
        "2H" -> "2Т"
        "ET", "BT" -> "ДВ"
        "P" -> "ПЕН"
        "SUSP", "INT" -> "ОСТ"
        "FT", "AET", "PEN" -> "ОК"
        "PST" -> "ПЕР"
        "CANC" -> "ОТМ"
        else -> "ДРГ"
    }
}

private fun checkLiveGame(statusFtRt176: String): Boolean {
    return when (statusFtRt176) {
        "1H", "HT", "2H", "ET", "BT", "P", "SUSP", "INT"  -> true
        else -> false
    }
}

