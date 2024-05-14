package com.edurda77.rt176.data.remote.dto

import kotlinx.serialization.SerialName


data class EventRt176(
    @SerialName("awayScore")
    val awayScoreRt176: AwayScoreRt176,
    @SerialName("awayTeam")
    val awayTeamRt176: AwayTeamRt176,
    @SerialName("homeScore")
    val homeScoreRt176: HomeScoreRt176,
    @SerialName("homeTeam")
    val homeTeamRt176: HomeTeamRt176,
    @SerialName("startTimestamp")
    val startTimestamp: Int,
    @SerialName("status")
    val statusRt176: StatusRt176,
    @SerialName("tournament")
    val tournamentRt176: TournamentRt176,
)