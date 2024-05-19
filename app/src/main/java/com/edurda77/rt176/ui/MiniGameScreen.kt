package com.edurda77.rt176.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edurda77.rt176.R
import com.edurda77.rt176.domain.model.NameSport
import com.edurda77.rt176.domain.model.Sport
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.TypeMiniGame
import com.edurda77.rt176.ui.state.TypeMiniGame.Play
import com.edurda77.rt176.ui.state.TypeMiniGame.Result
import com.edurda77.rt176.ui.theme.black
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.green
import com.edurda77.rt176.ui.theme.white176
import com.edurda77.rt176.ui.theme.yellow

@Preview
@Composable
private fun Sample() {
    MiniGameScreen(
        typeMiniGame = Result,
        leftTime = 1,
        score = 4,
        bestScore = 10,
        questImage = Sport.FOOTBALL,
        nameSport = NameSport.GOLF,
        eventRt176 = {})
}

@Composable
fun MiniGameScreen(
    modifier: Modifier = Modifier,
    typeMiniGame: TypeMiniGame,
    leftTime: Int,
    score: Int,
    bestScore: Int,
    questImage: Sport,
    nameSport: NameSport,
    eventRt176: (ApplicationEventRt176) -> Unit
) {
    BackHandler {
        eventRt176(ApplicationEventRt176.StopMiniGame)
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = white176,
        topBar = {
            Box(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .fillMaxWidth()
                    .background(color = darkRed)
                    .padding(horizontal = 20.dp, vertical = 10.dp),
            ) {
                IconButton(
                    modifier = modifier
                        .align(Alignment.CenterStart),
                    onClick = {
                        eventRt176(ApplicationEventRt176.StopMiniGame)
                    }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = "",
                        tint = white176
                    )
                }
                Text(
                    modifier = modifier.align(Alignment.Center),
                    text = stringResource(R.string.mini_game),
                    style = TextStyle(
                        fontSize = 32.sp,
                        color = yellow,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
            }
        }
    ) { paddings ->
        Column(
            modifier = modifier
                .padding(paddings)
                .fillMaxSize()
                .padding(vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            when (typeMiniGame) {
                Play -> {
                    Box {
                        CircularProgressIndicator(
                            modifier = modifier
                                .align(alignment = Alignment.Center)
                                .size(70.dp),
                            color = darkRed,
                            strokeWidth = 5.dp,
                            progress = { (leftTime.toFloat() / 3) })
                        Text(
                            modifier = modifier.align(Alignment.Center),
                            text = leftTime.toString(),
                            style = TextStyle(
                                fontSize = 60.sp,
                                color = yellow,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(700),
                            )
                        )
                    }
                    Image(
                        modifier = modifier.size(278.dp),
                        painter = painterResource(id = questImage.image),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = modifier.fillMaxWidth(),
                            text = nameSport.titleSport,
                            style = TextStyle(
                                fontSize = 32.sp,
                                color = darkRed,
                                textAlign = TextAlign.Center,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(700),
                            )
                        )
                        Spacer(modifier = modifier.height(16.dp))
                        Row(
                            verticalAlignment =Alignment.CenterVertically) {
                            Button(
                                modifier = modifier,
                                shape = RoundedCornerShape(16.dp),
                                contentPadding = PaddingValues(vertical = 11.dp, horizontal = 30.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = darkRed
                                ),
                                onClick = {
                                    eventRt176(
                                        ApplicationEventRt176.SetAnswer(false)
                                    )
                                }
                            ) {
                                Image(
                                    modifier = modifier.size(60.dp),
                                    painter = painterResource(id = R.drawable.image_no),
                                    contentDescription = "",
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                            Spacer(modifier = modifier.width(16.dp))
                            Button(
                                modifier = modifier,
                                shape = RoundedCornerShape(16.dp),
                                contentPadding = PaddingValues(vertical = 11.dp, horizontal = 30.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = green
                                ),
                                onClick = {
                                    eventRt176(
                                        ApplicationEventRt176.SetAnswer(true)
                                    )
                                }
                            ) {
                                Image(
                                    modifier = modifier.size(60.dp),
                                    painter = painterResource(id = R.drawable.image_yes),
                                    contentDescription = "",
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                    }
                }

                Result -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = modifier.fillMaxWidth(),
                            text = stringResource(R.string.game_over),
                            style = TextStyle(
                                fontSize = 40.sp,
                                color = darkRed,
                                textAlign = TextAlign.Center,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(700),
                            )
                        )
                        Spacer(modifier = modifier.height(5.dp))
                        Text(
                            modifier = modifier.fillMaxWidth(),
                            text = stringResource(R.string.your_score),
                            style = TextStyle(
                                fontSize = 23.sp,
                                color = darkRed,
                                textAlign = TextAlign.Center,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(500),
                            )
                        )
                    }
                    Box(
                        modifier = modifier
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = yellow)
                            .padding(horizontal = 16.dp, vertical = 30.dp)
                    ){
                        Text(
                            modifier = modifier.align(Alignment.Center),
                            text = score.toString(),
                            style = TextStyle(
                                fontSize = 100.sp,
                                color = darkRed,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(700),
                            )
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = modifier.fillMaxWidth(),
                            text = stringResource(R.string.best_score),
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = black,
                                textAlign = TextAlign.Center,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(500),
                            )
                        )
                        Text(
                            modifier = modifier.fillMaxWidth(),
                            text = bestScore.toString(),
                            style = TextStyle(
                                fontSize = 24.sp,
                                color = black,
                                textAlign = TextAlign.Center,
                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                fontWeight = FontWeight(700),
                            )
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            modifier = modifier
                                .align(alignment = Alignment.CenterHorizontally),
                            shape = RoundedCornerShape(16.dp),
                            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 30.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = darkRed
                            ),
                            onClick = {
                                eventRt176(ApplicationEventRt176.StartMiniGame)
                            }
                        ) {
                            Text(
                                modifier = modifier,
                                text = stringResource(R.string.repeat),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                                    fontWeight = FontWeight(700),
                                    color = yellow
                                )
                            )
                        }
                        Spacer(modifier = modifier.height(16.dp))
                        Button(
                            modifier = modifier
                                .align(alignment = Alignment.CenterHorizontally),
                            shape = RoundedCornerShape(16.dp),
                            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 30.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = black
                            ),
                            onClick = {
                                eventRt176(ApplicationEventRt176.StopMiniGame)
                            }
                        ) {
                            Text(
                                modifier = modifier,
                                text = stringResource(R.string.exit),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                                    fontWeight = FontWeight(700),
                                    color = yellow
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}