package com.edurda77.rt176.ui.state

import com.edurda77.rt176.domain.model.BasketballMatchRt176
import com.edurda77.rt176.domain.model.FootballMatchRt176
import com.edurda77.rt176.domain.model.H2HModel
import com.edurda77.rt176.domain.model.HockeyMatchRt176
import com.edurda77.rt176.domain.model.NameSport
import com.edurda77.rt176.domain.model.Sport
import java.time.LocalDate
import java.util.Calendar
import java.util.Date

data class MainStateRt176(
    val applicationStRt176: ApplicationStRt176 = ApplicationStRt176.LoadingRt176(),
    val lastStatus: ApplicationStRt176 = ApplicationStRt176.StartRt176(),
    val selectedDate: LocalDate = LocalDate.now(),
    val matches: List<H2HModel> = emptyList(),
    val destinationUrl: String = "",
    val allFootball: List<FootballMatchRt176> = emptyList(),
    val allBasketball: List<BasketballMatchRt176> = emptyList(),
    val allHockey: List<HockeyMatchRt176> = emptyList(),
    val liveFootballData: List<FootballMatchRt176> = emptyList(),
    val liveBasketballData: List<BasketballMatchRt176> = emptyList(),
    val liveHockeyData: List<HockeyMatchRt176> = emptyList(),
    val name: String = "",
    val phone: String = "",
    val bestScore: Int = 0,
    val isLoading: Boolean = true,
    val isLoadingUrl: Boolean = true,
    val message: String = "",
    val leftTime:Int = 3,
    val score:Int = 0,
    val questImage: Sport = Sport.FOOTBALL,
    val nameSport: NameSport = NameSport.GOLF
)