package com.edurda77.rt176.ui.uikit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.edurda77.rt176.R
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176
import com.edurda77.rt176.ui.state.TypeEventsRt176
import com.edurda77.rt176.ui.state.TypeGame
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.yellow


@Composable
fun SliderTypeGames(
    modifier: Modifier = Modifier,
    typeEventsRt176: TypeEventsRt176,
    typeGame: TypeGame,
    eventRt176Sl: (ApplicationEventRt176) -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = yellow
        )
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ItemNavigation(
                iconRt176Sl = ImageVector.vectorResource(id = R.drawable.ic_football),
                colorRt176Sl = if (typeGame is TypeGame.FootballRt176) yellow else darkRed,
                colorBk = if (typeGame is TypeGame.FootballRt176) darkRed else Color.Transparent,
                onClickRt176Sl = {
                    when (typeEventsRt176) {
                        is TypeEventsRt176.GamesOfDay -> {
                            eventRt176Sl(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.GamesOfDay(
                                            TypeGame.FootballRt176()))
                                )
                            )
                        }

                        is TypeEventsRt176.LiveGames -> {
                            eventRt176Sl(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.LiveGames(
                                            TypeGame.FootballRt176()))
                                )
                            )
                        }
                    }
                }
            )
            ItemNavigation(
                iconRt176Sl = ImageVector.vectorResource(id = R.drawable.ic_hockey),
                colorRt176Sl = if (typeGame is TypeGame.HockeyRt176) yellow else darkRed,
                colorBk = if (typeGame is TypeGame.HockeyRt176) darkRed else Color.Transparent,
                onClickRt176Sl = {
                    when (typeEventsRt176) {
                        is TypeEventsRt176.GamesOfDay -> {
                            eventRt176Sl(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.GamesOfDay(
                                            TypeGame.HockeyRt176()))
                                )
                            )
                        }

                        is TypeEventsRt176.LiveGames -> {
                            eventRt176Sl(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.LiveGames(
                                            TypeGame.HockeyRt176()))
                                )
                            )
                        }
                    }
                }
            )
            ItemNavigation(
                iconRt176Sl = ImageVector.vectorResource(id = R.drawable.ic_basketball),
                colorRt176Sl = if (typeGame is TypeGame.BasketballRt176) yellow else darkRed,
                colorBk = if (typeGame is TypeGame.BasketballRt176) darkRed else Color.Transparent,
                onClickRt176Sl = {
                    when (typeEventsRt176) {
                        is TypeEventsRt176.GamesOfDay -> {
                            eventRt176Sl(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.GamesOfDay(
                                            TypeGame.BasketballRt176()))
                                )
                            )
                        }

                        is TypeEventsRt176.LiveGames -> {
                            eventRt176Sl(
                                ApplicationEventRt176.OnSetApplicationStateRt176(
                                    ApplicationStRt176.EventsRt176(
                                        TypeEventsRt176.LiveGames(
                                            TypeGame.BasketballRt176()))
                                )
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun ItemNavigation(
    iconRt176Sl: ImageVector,
    colorBk: Color,
    colorRt176Sl: Color,
    onClickRt176Sl: () -> Unit
) {
    IconButton(
        onClick = onClickRt176Sl,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = colorBk
        ),
    ) {
        Icon(
            imageVector = iconRt176Sl,
            contentDescription = "",
            tint = colorRt176Sl
        )
    }
}