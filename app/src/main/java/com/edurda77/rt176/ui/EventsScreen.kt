package com.edurda77.rt176.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edurda77.rt176.R
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176
import com.edurda77.rt176.ui.state.TypeEventsRt176
import com.edurda77.rt176.ui.state.TypeGame
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.yellow
import com.edurda77.rt176.ui.uikit.SliderOfDate
import com.edurda77.rt176.ui.uikit.SliderTypeGames
import java.time.LocalDate

@Preview
@Composable
private fun Sample() {
    EventsScreen(
        typeEventsRt176 = TypeEventsRt176.LiveGames(TypeGame.BasketballRt176()),
        selectedDate = LocalDate.now(),
        event = {}
    )
}


@Composable
fun EventsScreen(
    modifier: Modifier = Modifier,
    typeEventsRt176: TypeEventsRt176,
    selectedDate: LocalDate,
    event: (ApplicationEventRt176) -> Unit
) {
    BackHandler {
        event(ApplicationEventRt176.OnSetApplicationStateRt176(ApplicationStRt176.StartRt176()))
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
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
                            containerColor = if (typeEventsRt176 is TypeEventsRt176.GamesOfDay) yellow else darkRed,
                            contentColor = if (typeEventsRt176 is TypeEventsRt176.GamesOfDay) darkRed else yellow,
                        ),
                        onClick = {
                            event(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.GamesOfDay(TypeGame.FootballRt176())
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
                            containerColor = if (typeEventsRt176 is TypeEventsRt176.LiveGames) yellow else darkRed,
                            contentColor = if (typeEventsRt176 is TypeEventsRt176.LiveGames) darkRed else yellow,
                        ),
                        onClick = {
                            event(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.LiveGames(TypeGame.FootballRt176())
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
                        is TypeEventsRt176.GamesOfDay -> rt.typeGame
                        is TypeEventsRt176.LiveGames -> rt.typeGame
                    }
                    Spacer(modifier = modifier.width(3.dp))
                    SliderTypeGames(
                        typeEventsRt176 = typeEventsRt176,
                        typeGame = typeGame,
                        event = event
                    )
                }
                Spacer(modifier = modifier.height(16.dp))
                SliderOfDate(
                    selectedDate = selectedDate,
                    event = event
                )
            }
        }
    ) {

    }
}