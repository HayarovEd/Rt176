/*
package com.edurda77.rt176.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176


@Composable
fun LiveScreenRt176(
    modifier: Modifier = Modifier,
    countFootball: Int,
    countBasketball: Int,
    applicationStRt171: ApplicationStRt176,
    event: (ApplicationEventRt176) -> Unit,
    name: String,
    phone: String,
    liveFootballData: List<GameDataRt171>,
    liveBasketballData: List<GameDataRt171>
) {
    BackHandler {
        event(ApplicationEventRt171.OnSetApplicationStateRt171(ApplicationStRt171.StartRt171()))
    }
    val matches = when ((applicationStRt171 as ApplicationStRt171.LiveEventsRt171).typeEventsRt171) {
        is TypeEventsRt171.BasketballRt171 -> liveBasketballData
        is TypeEventsRt171.FootballRt171 -> liveFootballData
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = whiteRt171)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.live_events),
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = blackRt171
                    )
                )
            }
        },
        bottomBar = {
            BottomBarRt171(
                applicationStRt171 = applicationStRt171,
                name = name,
                phone = phone,
                event = event
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .background(color = whiteRt171),
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = blackRt171)
                    .padding(vertical = 9.dp, horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TypeEventsSwitcher(
                    modifier = modifier.weight(1f),
                    backGroundColor = if (applicationStRt171.typeEventsRt171 == TypeEventsRt171.FootballRt171()
                    ) redRt171 else blackRt171,
                    countColor = if (applicationStRt171.typeEventsRt171 == TypeEventsRt171.FootballRt171()
                    ) whiteRt171 else greyRt171,
                    countTextColor = if (applicationStRt171.typeEventsRt171 == TypeEventsRt171.FootballRt171()
                    ) redRt171 else whiteRt171,
                    title = stringResource(id = R.string.football),
                    count = countFootball,
                    icon = ImageVector.vectorResource(id = R.drawable.sports_soccer_24),
                    onClick = {
                        event(
                            ApplicationEventRt171.OnSetApplicationStateRt171(
                                ApplicationStRt171.LiveEventsRt171(
                                    TypeEventsRt171.FootballRt171()
                                )
                            )
                        )
                    }
                )
                Spacer(modifier = modifier.width(15.dp))
                TypeEventsSwitcher(
                    modifier = modifier.weight(1f),
                    backGroundColor = if (applicationStRt171.typeEventsRt171 == TypeEventsRt171.BasketballRt171()
                    ) redRt171 else blackRt171,
                    countColor = if (applicationStRt171.typeEventsRt171 == TypeEventsRt171.BasketballRt171()
                    ) whiteRt171 else greyRt171,
                    countTextColor = if (applicationStRt171.typeEventsRt171 == TypeEventsRt171.BasketballRt171()
                    ) redRt171 else whiteRt171,
                    title = stringResource(id = R.string.basketball),
                    count = countBasketball,
                    icon = ImageVector.vectorResource(id = R.drawable.baseline_sports_basketball_24),
                    onClick = {
                        event(
                            ApplicationEventRt171.OnSetApplicationStateRt171(
                                ApplicationStRt171.LiveEventsRt171(
                                    TypeEventsRt171.BasketballRt171()
                                )
                            )
                        )
                    }
                )
            }
            Spacer(modifier = modifier.height(16.dp))
            Text(
                modifier = modifier.padding(horizontal = 16.dp),
                text = stringResource(R.string.top_events),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = blackRt171,
                )
            )
            Spacer(modifier = modifier.height(16.dp))
            if (matches.isEmpty()) {
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 200.dp),
                    text = stringResource(R.string.no_matches),
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = blackRt171,
                        textAlign = TextAlign.Center
                    )
                )
            } else {
                val content = when (applicationStRt171.typeEventsRt171) {
                    is TypeEventsRt171.BasketballRt171 -> stringResource(id = R.string.basketball)
                    is TypeEventsRt171.FootballRt171 -> stringResource(id = R.string.football)
                }
                LazyVerticalGrid(
                    modifier = modifier.padding(horizontal = 16.dp),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(matches) { game ->
                        ItemGameRt171(
                            date = content,
                            time = game.statusGameRt171,
                            nameTournament = game.nameTournamentRt171,
                            nameAway = game.awayNameRt171,
                            nameHome = game.homeNameRt171,
                            scoreHome = game.homeScoreRt171,
                            scoreAway = game.awayScoreRt171,
                        )
                    }
                }
            }
        }
    }
}*/
