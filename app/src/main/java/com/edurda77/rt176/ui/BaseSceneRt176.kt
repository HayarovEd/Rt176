package com.edurda77.rt176.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.edurda77.rt176.domain.utils.dpToSpRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176.EventsRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176.GameRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176.H2h
import com.edurda77.rt176.ui.state.ApplicationStRt176.LoadingRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176.MiniGameRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176.ProfileRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176.StartRt176
import com.edurda77.rt176.ui.state.MainViewModelRt176

@Composable
fun BaseSceneRt176(
    viewModel: MainViewModelRt176 = hiltViewModel()
) {
    val stateRt176 = viewModel.state.collectAsState()
    val eventRt176 = viewModel::onEventRt176
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val timeTexSize = (screenWidth/70f).dpToSpRt176()
    when (val rst = stateRt176.value.applicationStRt176) {
        is GameRt176 -> {
            GameScreen(
                applicationStRt176 =  stateRt176.value.applicationStRt176,
                name = stateRt176.value.name,
                phone = stateRt176.value.phone,
                bestScore = stateRt176.value.bestScore,
                event = eventRt176
            )
        }

        is LoadingRt176 -> {
            LoadingScreenRt176()
        }

        is ProfileRt176 -> {
            ProfileScreenRt176(
                nameRt176 = stateRt176.value.name,
                phoneRt176 = stateRt176.value.phone,
                applicationStRt176 = stateRt176.value.applicationStRt176,
                typeProfileRt176 = rst.typeProfileRt176,
                event = eventRt176
            )
        }

        is StartRt176 -> {
            StartScreenRt176(
                url = stateRt176.value.destinationUrl,
                isAccess = stateRt176.value.isAccess,
                isInternet = stateRt176.value.isInternet,
                eventRt176 = eventRt176
            )
        }

        is EventsRt176 -> {
            EventsScreen(
                typeEventsRt176 = rst.typeEventsRt176,
                applicationStRt176 = stateRt176.value.applicationStRt176,
                footballMatches = stateRt176.value.allFootball,
                footballLiveMatches = stateRt176.value.liveFootballData,
                basketballMatches = stateRt176.value.allBasketball,
                basketballLiveMatches = stateRt176.value.liveBasketballData,
                hockeyMatches = stateRt176.value.allHockey,
                hockeyLiveMatches = stateRt176.value.liveHockeyData,
                isLoading = stateRt176.value.isLoading,
                nameRt176 = stateRt176.value.name,
                phoneRt176 = stateRt176.value.phone,
                selectedDateRt176Es = stateRt176.value.selectedDate,
                isInternet = stateRt176.value.isInternet,
                timeTexSize = timeTexSize,
                event = eventRt176)
        }

        is H2h -> {
            H2hScreen(
                homeName = rst.homeName,
                homeScore = rst.homeScore,
                homeLogo = rst.homeLogo,
                homeColor = rst.homeColor,
                awayLogo = rst.awayLogo,
                awayName = rst.awayName,
                awayScore = rst.awayScore,
                awayColor = rst.awayColor,
                title = rst.title,
                isLoading = stateRt176.value.isLoading,
                matches = stateRt176.value.matches,
                lastAppState = stateRt176.value.lastStatus,
                icon = rst.icon,
                event = eventRt176
            )
        }

        is MiniGameRt176 -> {
            MiniGameScreen(
                typeMiniGameRt176 = rst.typeMiniGameRt176,
                leftTime = stateRt176.value.leftTime,
                score = stateRt176.value.score,
                bestScore = stateRt176.value.bestScore,
                questImage = stateRt176.value.questImage,
                nameSport = stateRt176.value.nameSport,
                eventRt176 = eventRt176
            )
        }
    }
}