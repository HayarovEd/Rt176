package com.edurda77.rt176.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edurda77.rt176.R
import com.edurda77.rt176.domain.model.BasketballMatchRt176
import com.edurda77.rt176.domain.model.FootballMatchRt176
import com.edurda77.rt176.domain.model.HockeyMatchRt176
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176
import com.edurda77.rt176.ui.state.TypeEventsRt176
import com.edurda77.rt176.ui.state.TypeGame
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.white176
import com.edurda77.rt176.ui.theme.yellow
import com.edurda77.rt176.ui.uikit.BottomNavigationRow
import com.edurda77.rt176.ui.uikit.ItemBasketball
import com.edurda77.rt176.ui.uikit.ItemFootball
import com.edurda77.rt176.ui.uikit.ItemHockey
import com.edurda77.rt176.ui.uikit.ItemLiveBasketball
import com.edurda77.rt176.ui.uikit.ItemLiveFootball
import com.edurda77.rt176.ui.uikit.ItemLiveHockey
import com.edurda77.rt176.ui.uikit.SliderOfDate
import com.edurda77.rt176.ui.uikit.SliderTypeGames
import java.time.LocalDate

/*@Preview
@Composable
private fun Sample() {
    EventsScreen(
        typeEventsRt176 = TypeEventsRt176.LiveGames(TypeGame.FootballRt176()),
        applicationStRt176 = ApplicationStRt176.GameRt176(),
        selectedDate = LocalDate.now(),
        name = "ddfgg",
        phone = "89026355319",
        event = {}
    )
}*/


@Composable
fun EventsScreen(
    modifier: Modifier = Modifier,
    applicationStRt176: ApplicationStRt176,
    nameRt176:String,
    phoneRt176:String,
    footballMatches: List<FootballMatchRt176>,
    footballLiveMatches: List<FootballMatchRt176>,
    basketballMatches: List<BasketballMatchRt176>,
    basketballLiveMatches: List<BasketballMatchRt176>,
    hockeyMatches: List<HockeyMatchRt176>,
    hockeyLiveMatches: List<HockeyMatchRt176>,
    isLoading: Boolean,
    typeEventsRt176: TypeEventsRt176,
    selectedDateRt176Es: LocalDate,
    event: (ApplicationEventRt176) -> Unit
) {
    BackHandler {
        event(ApplicationEventRt176.OnSetApplicationStateRt176(ApplicationStRt176.StartRt176()))
    }

    val titleRt176Es = when (val rt = typeEventsRt176) {
        is TypeEventsRt176.GamesOfDayRt176 -> when (rt.typeGame) {
            is TypeGame.BasketballRt176 -> stringResource(R.string.basketbal)
            is TypeGame.FootballRt176 ->  stringResource(R.string.football)
            is TypeGame.HockeyRt176 ->  stringResource(R.string.hockey)
        }
        is TypeEventsRt176.LiveGamesRt176 -> when (rt.typeGame) {
            is TypeGame.BasketballRt176 -> stringResource(R.string.basketbal)
            is TypeGame.FootballRt176 ->  stringResource(R.string.football)
            is TypeGame.HockeyRt176 ->  stringResource(R.string.hockey)
        }
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = white176,
        topBar = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .background(color = darkRed)
                    .padding(16.dp),
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        modifier = modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = PaddingValues(vertical = 12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (typeEventsRt176 is TypeEventsRt176.GamesOfDayRt176) yellow else darkRed,
                            contentColor = if (typeEventsRt176 is TypeEventsRt176.GamesOfDayRt176) darkRed else yellow,
                        ),
                        onClick = {
                            event(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.GamesOfDayRt176(TypeGame.FootballRt176())
                                    )
                                )
                            )
                        }
                    ) {
                        Text(
                            modifier = modifier,
                            text = stringResource(R.string.games),
                            style = TextStyle(
                                fontSize = 20.sp,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(700),
                            )
                        )
                    }
                    Button(
                        modifier = modifier.weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = PaddingValues(vertical = 12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (typeEventsRt176 is TypeEventsRt176.LiveGamesRt176) yellow else darkRed,
                            contentColor = if (typeEventsRt176 is TypeEventsRt176.LiveGamesRt176) darkRed else yellow,
                        ),
                        onClick = {
                            event(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.LiveGamesRt176(TypeGame.FootballRt176())
                                    )
                                )
                            )
                        }
                    ) {
                        Text(
                            modifier = modifier,
                            text = stringResource(R.string.lives),
                            style = TextStyle(
                                fontSize = 20.sp,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(700),
                            )
                        )
                    }
                    val typeGame = when (val rt = typeEventsRt176) {
                        is TypeEventsRt176.GamesOfDayRt176 -> rt.typeGame
                        is TypeEventsRt176.LiveGamesRt176 -> rt.typeGame
                    }
                    Spacer(modifier = modifier.width(3.dp))
                    SliderTypeGames(
                        typeEventsRt176 = typeEventsRt176,
                        typeGame = typeGame,
                        eventRt176Sl = event
                    )
                }
                Spacer(modifier = modifier.height(16.dp))
                if (typeEventsRt176 is TypeEventsRt176.GamesOfDayRt176) {
                    SliderOfDate(
                        selectedDate = selectedDateRt176Es,
                        event = event
                    )
                    Spacer(modifier = modifier.height(16.dp))
                }
                Text(
                    text = titleRt176Es,
                    style = TextStyle(
                        fontSize = 26.sp,
                        color = yellow,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(800),
                    )
                )
            }
        },
        bottomBar = {
            BottomNavigationRow(
                applicationStRt176 = applicationStRt176,
                nameRt176 = nameRt176,
                phoneRt176 = phoneRt176,
                eventRt176 = event)
        }
    ) {paddings->
        Column(
            modifier = modifier
                .padding(paddings)
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = modifier
                        .align(Alignment.CenterHorizontally)
                        .size(100.dp)
                        .padding(top = 200.dp),
                    color = darkRed,
                )
            } else {
                when (val rt = typeEventsRt176) {
                    is TypeEventsRt176.GamesOfDayRt176 -> when (rt.typeGame) {
                        is TypeGame.BasketballRt176 -> {
                            if (basketballMatches.isEmpty()) {
                                NoMatches(
                                    modifier = modifier.align(Alignment.CenterHorizontally)
                                )
                            } else {
                                LazyColumn(
                                    modifier = modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(15.dp)
                                ) {
                                    items(basketballMatches) {
                                        ItemBasketball(
                                            basketballMatchRt176 = it,
                                            eventRt176 = event
                                        )
                                    }
                                }
                            }
                        }

                        is TypeGame.FootballRt176 -> {
                            if (footballMatches.isEmpty()) {
                                NoMatches(
                                    modifier = modifier.align(Alignment.CenterHorizontally)
                                )
                            } else {
                                LazyColumn(
                                    modifier = modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(15.dp)
                                ) {
                                    items(footballMatches) {
                                        ItemFootball(
                                            footballMatchRt176 = it,
                                            event = event
                                        )
                                    }
                                }
                            }
                        }

                        is TypeGame.HockeyRt176 -> {
                            if (hockeyMatches.isEmpty()) {
                                NoMatches(
                                    modifier = modifier.align(Alignment.CenterHorizontally)
                                )
                            } else {
                                LazyColumn(
                                    modifier = modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(15.dp)
                                ) {
                                    items(hockeyMatches) {
                                        ItemHockey(
                                            hockeyMatchRt176 = it,
                                            eventRt176 = event
                                        )
                                    }
                                }
                            }
                        }
                    }

                    is TypeEventsRt176.LiveGamesRt176 -> when (rt.typeGame) {
                        is TypeGame.BasketballRt176 -> {
                            if (basketballLiveMatches.isEmpty()) {
                                NoMatches(
                                    modifier = modifier.align(Alignment.CenterHorizontally)
                                )
                            } else {
                                LazyColumn(
                                    modifier = modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(15.dp)
                                ) {
                                    items(basketballLiveMatches) {
                                        ItemLiveBasketball(
                                            basketballMatchRt176 = it,
                                            event = event
                                        )
                                    }
                                }
                            }
                        }

                        is TypeGame.FootballRt176 -> {
                            if (footballLiveMatches.isEmpty()) {
                                NoMatches(
                                    modifier = modifier.align(Alignment.CenterHorizontally)
                                )
                            } else {
                                LazyColumn(
                                    modifier = modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(15.dp)
                                ) {
                                    items(footballLiveMatches) {
                                        ItemLiveFootball(
                                            footballMatchRt176 = it,
                                            event = event
                                        )
                                    }
                                }
                            }
                        }

                        is TypeGame.HockeyRt176 -> {
                            if (hockeyLiveMatches.isEmpty()) {
                                NoMatches(
                                    modifier = modifier.align(Alignment.CenterHorizontally)
                                )
                            } else {
                                LazyColumn(
                                    modifier = modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(15.dp)
                                ) {
                                    items(hockeyLiveMatches) {
                                        ItemLiveHockey(
                                            hockeyMatchRt176 = it,
                                            event = event
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun NoMatches(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = stringResource(R.string.no_matches),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            color = darkRed,
            textAlign = TextAlign.Center
        )
    )
}