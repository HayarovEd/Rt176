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
    when (stateRt171.value.applicationStRt176) {
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

        is ApplicationStRt176.LiveEventsRt176 -> {
            /* LiveScreenRt171(
                 name = stateRt171.value.name,
                 phone = stateRt171.value.phone,
                 liveFootballData = stateRt171.value.liveFootballData,
                 liveBasketballData = stateRt171.value.liveBasketballData,
                 countFootball = stateRt171.value.liveFootballData.size,
                 countBasketball = stateRt171.value.liveBasketballData.size,
                 ApplicationStRt176 = stateRt171.value.ApplicationStRt176,
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

        is ApplicationStRt176.IncomingEventsRt176 -> {
            /*IncomingScreenRt171(
                name = stateRt171.value.name,
                phone = stateRt171.value.phone,
                countFootball = stateRt171.value.allFootball.size,
                countBasketball = stateRt171.value.allBasketball.size,
                ApplicationStRt176 = stateRt171.value.ApplicationStRt176,
                selectedDate = stateRt171.value.selectedDate,
                footballData = stateRt171.value.allFootball,
                basketballData = stateRt171.value.allBasketball,
                isLoading = stateRt171.value.isLoading,
                message = stateRt171.value.message,
                event = eventRt171
            )*/
        }
    }
}