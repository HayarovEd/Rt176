package com.edurda77.rt176.ui

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edurda77.rt176.R
import com.edurda77.rt176.domain.utils.POLITIC_URL_BEGINN_RT176
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176
import com.edurda77.rt176.ui.state.TypeEventsRt176
import com.edurda77.rt176.ui.state.TypeGame
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.white176
import com.edurda77.rt176.ui.theme.yellow

@Composable
fun StartScreenRt176(
    modifier: Modifier = Modifier,
    url: String,
    isVpn: Boolean,
    isInternet: Boolean,
    eventRt176: (ApplicationEventRt176) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val context = LocalContext.current
    BackHandler {}
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Log.d("MainViewModelRt145", "url -$url")
        Column(
            modifier = modifier
                .align(alignment = Alignment.Center)
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            if (!isVpn&&(url.isNotBlank() && !url.startsWith(POLITIC_URL_BEGINN_RT176))&&isInternet) {
                Image(
                    modifier = modifier
                        .height(screenHeight / 4.5f),
                    painter = painterResource(id = R.drawable.rectangle_back),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight
                )
                Spacer(modifier = modifier.height(20.dp))
                TextButton(
                    modifier = modifier.align(alignment = Alignment.CenterHorizontally),
                    onClick = {
                        val uri = Uri.parse(url)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        context.startActivity(intent)
                    }) {
                    Box {
                        Image(
                            modifier = modifier
                                .align(alignment = Alignment.Center)
                                .width(screenWidth / 1.3f),
                            painter = painterResource(id = R.drawable.back_button_enter),
                            contentDescription = "",
                            contentScale = ContentScale.FillWidth
                        )
                        Column(
                            modifier = modifier
                                .align(alignment = Alignment.Center),
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                modifier = modifier.fillMaxWidth(),
                                text = stringResource(R.string.bet),
                                style = TextStyle(
                                    fontSize = 40.sp,
                                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                                    fontWeight = FontWeight(700),
                                    color = yellow,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
                Spacer(modifier = modifier.height(43.dp))
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
                    eventRt176(
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
                    text = stringResource(R.string.events),
                    style = TextStyle(
                        fontSize = 16.sp,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                        color = darkRed
                    )
                )
            }
        }
        if (!isVpn&&(url.isNotBlank() && !url.startsWith(POLITIC_URL_BEGINN_RT176))&&isInternet) {
            Text(
                modifier = modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
                    .fillMaxWidth(),
                text = stringResource(R.string.warning),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    // fontFamily = FontFamily(Font(R.font.gilroy)),
                    color = white176.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Preview
@Composable
private fun PreviewStartScreenRt176() {
    StartScreenRt176(
        url = "ddddd",
        isVpn = false,
        isInternet = true,
        eventRt176 = {})
}