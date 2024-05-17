package com.edurda77.rt176.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.edurda77.rt176.ui.state.ApplicationStRt176
import com.edurda77.rt176.ui.state.MainViewModelRt176

@Composable
fun BaseSceneRt176(
    viewModel: MainViewModelRt176 = hiltViewModel()
) {
    val stateRt171 = viewModel.state.collectAsState()
    val eventRt171 = viewModel::onEventRt171
    when (val rst = stateRt171.value.applicationStRt176) {
        is ApplicationStRt176.GameRt176 -> {
            /* RacingGameScreen(
                 gameScore = { stateRt171.value.gameScore },
                 highscore = { stateRt171.value.highScore },
                 name = stateRt171.value.name,
                 phone = stateRt171.value.phone,
                 acceleration = { stateRt171.value.accelerationCarData },
                 moveInput = { stateRt171.value.moveInput },
                 resourcePack = { stateRt171.value.resourcePack },
                 isDevMode = { true },
                 ApplicationStRt176 = stateRt171.value.ApplicationStRt176,
                 gameState = stateRt171.value.gameState,
                 onGameScoreIncrease = { eventRt171(ApplicationEventRt171.IncreaseGameScoreRt171()) },
                 onResetGameScore = { eventRt171(ApplicationEventRt171.RstGmeScoreRt171()) },
                 event = eventRt171
             )*/
        }

        is ApplicationStRt176.LoadingRt176 -> {
            LoadingScreenRt176()
        }

        is ApplicationStRt176.Profile -> {
            /*ProfileScreenRt171(
                name = stateRt171.value.name,
                phone = stateRt171.value.phone,
                ApplicationStRt176 = stateRt171.value.ApplicationStRt176,
                event = eventRt171
            )*/
        }

        is ApplicationStRt176.StartRt176 -> {
            StartScreenRt176(
                url = stateRt171.value.destinationUrl,
                event = eventRt171
            )
        }

        is ApplicationStRt176.EventsRt176 -> {
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

        is ApplicationStRt176.H2h -> {
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
    }
}