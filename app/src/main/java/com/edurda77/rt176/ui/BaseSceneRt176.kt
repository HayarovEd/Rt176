package com.edurda77.rt176.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.edurda77.rt176.ui.state.ApplicationStRt176.EventsRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176.GameRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176.H2h
import com.edurda77.rt176.ui.state.ApplicationStRt176.LoadingRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176.MiniGame
import com.edurda77.rt176.ui.state.ApplicationStRt176.Profile
import com.edurda77.rt176.ui.state.ApplicationStRt176.StartRt176
import com.edurda77.rt176.ui.state.MainViewModelRt176

@Composable
fun BaseSceneRt176(
    viewModel: MainViewModelRt176 = hiltViewModel()
) {
    val stateRt176 = viewModel.state.collectAsState()
    val eventRt171 = viewModel::onEventRt171
    when (val rst = stateRt176.value.applicationStRt176) {
        is GameRt176 -> {
            GameScreen(
                applicationStRt176 =  stateRt176.value.applicationStRt176,
                name = stateRt176.value.name,
                phone = stateRt176.value.phone,
                bestScore = stateRt176.value.bestScore,
                event = eventRt171
            )
        }

        is LoadingRt176 -> {
            LoadingScreenRt176()
        }

        is Profile -> {
            ProfileScreenRt176(
                name = stateRt176.value.name,
                phone = stateRt176.value.phone,
                applicationStRt176 = stateRt176.value.applicationStRt176,
                typeProfileRt176 = rst.typeProfileRt176,
                event = eventRt171
            )
        }

        is StartRt176 -> {
            StartScreenRt176(
                url = stateRt176.value.destinationUrl,
                event = eventRt171
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
                name = stateRt176.value.name,
                phone = stateRt176.value.phone,
                selectedDate = stateRt176.value.selectedDate,
                event = eventRt171)
        }

        is H2h -> {
            H2hScreen(
                homeName = rst.homeName,
                homeScore = rst.homeScore,
                homeLogo = rst.homeLogo,
                awayLogo = rst.awayLogo,
                awayName = rst.awayName,
                awayScore = rst.awayScore,
                title = rst.title,
                isLoading = stateRt176.value.isLoading,
                matches = stateRt176.value.matches,
                lastAppState = stateRt176.value.lastStatus,
                event = eventRt171
            )
        }

        is MiniGame -> {
            MiniGameScreen(
                typeMiniGame = rst.typeMiniGame,
                leftTime = stateRt176.value.leftTime,
                score = stateRt176.value.score,
                bestScore = stateRt176.value.bestScore,
                questImage = stateRt176.value.questImage,
                nameSport = stateRt176.value.nameSport,
                event = eventRt171
            )
        }
    }
}