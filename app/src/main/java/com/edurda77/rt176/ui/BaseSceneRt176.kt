package com.edurda77.rt176.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.edurda77.rt176.ui.state.ApplicationStRt176
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
    val stateRt171 = viewModel.state.collectAsState()
    val eventRt171 = viewModel::onEventRt171
    when (val rst = stateRt171.value.applicationStRt176) {
        is GameRt176 -> {
            GameScreen(
                applicationStRt176 =  stateRt171.value.applicationStRt176,
                name = stateRt171.value.name,
                phone = stateRt171.value.phone,
                bestScore = stateRt171.value.bestScore,
                event = eventRt171
            )
        }

        is LoadingRt176 -> {
            LoadingScreenRt176()
        }

        is Profile -> {
            /*ProfileScreenRt171(
                name = stateRt171.value.name,
                phone = stateRt171.value.phone,
                ApplicationStRt176 = stateRt171.value.ApplicationStRt176,
                event = eventRt171
            )*/
        }

        is StartRt176 -> {
            StartScreenRt176(
                url = stateRt171.value.destinationUrl,
                event = eventRt171
            )
        }

        is EventsRt176 -> {
            EventsScreen(
                typeEventsRt176 = rst.typeEventsRt176,
                applicationStRt176 = stateRt171.value.applicationStRt176,
                footballMatches = stateRt171.value.allFootball,
                footballLiveMatches = stateRt171.value.liveFootballData,
                basketballMatches = stateRt171.value.allBasketball,
                basketballLiveMatches = stateRt171.value.liveBasketballData,
                hockeyMatches = stateRt171.value.allHockey,
                hockeyLiveMatches = stateRt171.value.liveHockeyData,
                isLoading = stateRt171.value.isLoading,
                name = stateRt171.value.name,
                phone = stateRt171.value.phone,
                selectedDate = stateRt171.value.selectedDate,
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
                isLoading = stateRt171.value.isLoading,
                matches = stateRt171.value.matches,
                lastAppState = stateRt171.value.lastStatus,
                event = eventRt171
            )
        }

        is MiniGame -> {
            MiniGameScreen(
                typeMiniGame = rst.typeMiniGame,
                leftTime = stateRt171.value.leftTime,
                score = stateRt171.value.score,
                bestScore = stateRt171.value.bestScore,
                questImage = stateRt171.value.questImage,
                nameSport = stateRt171.value.nameSport,
                event = eventRt171
            )
        }
    }
}