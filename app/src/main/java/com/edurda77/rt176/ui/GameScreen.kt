package com.edurda77.rt176.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.white176
import com.edurda77.rt176.ui.theme.yellow
import com.edurda77.rt176.ui.uikit.BottomNavigationRow

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    applicationStRt176: ApplicationStRt176,
    name:String,
    phone:String,
    bestScore:Int,
    event: (ApplicationEventRt176) -> Unit
) {
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
        },
        bottomBar = {
            BottomNavigationRow(
                applicationStRt176 = applicationStRt176,
                nameRt176 = name,
                phoneRt176 = phone,
                eventRt176 = event)
        }
    ) {paddings->
        Column(
            modifier = modifier
                .padding(paddings)
                .fillMaxSize()
                .padding(vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(R.string.sport),
                style = TextStyle(
                    fontSize = 60.sp,
                    color = yellow,
                    textAlign = TextAlign.Center,
                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                    fontWeight = FontWeight(700),
                )
            )
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = darkRed
                )
            ) {
                Column(
                    modifier = modifier.padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        modifier = modifier,
                        text = stringResource(R.string.best_score),
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = yellow,
                            textAlign = TextAlign.Center,
                            //fontFamily = FontFamily(Font(R.font.gilroy)),
                            fontWeight = FontWeight(500),
                        )
                    )
                    Spacer(modifier = modifier.height(15.dp))
                    Text(
                        modifier = modifier,
                        text = bestScore.toString(),
                        style = TextStyle(
                            fontSize = 96.sp,
                            color = yellow,
                            textAlign = TextAlign.Center,
                            //fontFamily = FontFamily(Font(R.font.gilroy)),
                            fontWeight = FontWeight(700),
                        )
                    )
                }
            }
            Button(
                modifier = modifier
                    .align(alignment = Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                contentPadding = PaddingValues(vertical = 20.dp, horizontal = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = yellow
                ),
                onClick = {
                    event(ApplicationEventRt176.StartMiniGame)
                }
            ) {
                Text(
                    modifier = modifier,
                    text = stringResource(R.string.is_play),
                    style = TextStyle(
                        fontSize = 16.sp,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                        color = darkRed
                    )
                )
            }
        }
    }
}