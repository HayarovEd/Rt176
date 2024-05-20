package com.edurda77.rt176.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.edurda77.rt176.R
import com.edurda77.rt176.domain.model.H2HModel
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176
import com.edurda77.rt176.ui.theme.black
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.grey
import com.edurda77.rt176.ui.theme.white176
import com.edurda77.rt176.ui.theme.yellow

@Composable
fun H2hScreen(
    modifier: Modifier = Modifier,
    homeName: String,
    homeScore: Int?,
    homeLogo: String,
    awayLogo: String,
    awayName: String,
    awayScore: Int?,
    title: String,
    isLoading: Boolean,
    matches: List<H2HModel>,
    lastAppState: ApplicationStRt176,
    event: (ApplicationEventRt176) -> Unit
) {
    BackHandler {
        event(ApplicationEventRt176.OnSetApplicationStateRt176(lastAppState))
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = darkRed,
        topBar = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                ) {
                    IconButton(
                        modifier = modifier
                            .align(Alignment.CenterStart),
                        onClick = {
                            event(ApplicationEventRt176.OnSetApplicationStateRt176(lastAppState))
                        }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = "",
                            tint = white176
                        )
                    }
                    Text(
                        modifier = modifier.align(Alignment.Center),
                        text = stringResource(R.string.match),
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = white176,
                            //fontFamily = FontFamily(Font(R.font.gilroy)),
                            fontWeight = FontWeight(700),
                        )
                    )
                }
                Spacer(modifier = modifier.height(25.dp))
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = title,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow,
                        textAlign = TextAlign.Center,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
                Spacer(modifier = modifier.height(25.dp))
                RowH2h(
                    logo = homeLogo,
                    name = homeName,
                    colorRect = yellow,
                    score = homeScore
                )
                Spacer(modifier = modifier.height(25.dp))
                RowH2h(
                    logo = awayLogo,
                    name = awayName,
                    colorRect = white176,
                    score = awayScore
                )
            }
        }
    ) { paddings ->
        Column(
            modifier = modifier
                .padding(paddings)
                .clip(shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxSize()
                .background(color = white176)
                .padding(16.dp)
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(R.string.h2h),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = darkRed,
                    textAlign = TextAlign.Center,
                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                    fontWeight = FontWeight(700),
                )
            )
            Spacer(modifier = modifier.height(10.dp))
            HorizontalDivider(
                modifier = modifier.fillMaxWidth(),
                color = darkRed,
                thickness = 2.dp
            )
            Spacer(modifier = modifier.height(20.dp))
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = modifier
                        .align(Alignment.CenterHorizontally)
                        .size(100.dp)
                        .padding(top = 200.dp),
                    color = darkRed,
                )
            } else {
                if (matches.isEmpty()) {
                    NoMatches(
                        modifier = modifier.align(Alignment.CenterHorizontally)
                    )
                } else {
                    Text(
                        modifier = modifier,
                        text = stringResource(R.string.last_5),
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = grey,
                            //fontFamily = FontFamily(Font(R.font.gilroy)),
                            fontWeight = FontWeight(400),
                        )
                    )

                    LazyColumn(
                        modifier = modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        items(matches) { match ->
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    modifier = modifier,
                                    text = match.dateOfMatch,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = grey,
                                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                                        fontWeight = FontWeight(400),
                                    )
                                )
                                Spacer(modifier = modifier.width(20.dp))
                                Column {
                                    Row(
                                        modifier = modifier,
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        AsyncImage(
                                            modifier = modifier.size(24.dp),
                                            model = match.homeLogo,
                                            contentDescription = "",
                                            contentScale = ContentScale.FillBounds
                                        )
                                        Spacer(modifier = modifier.width(10.dp))
                                        Text(
                                            modifier = modifier,
                                            text = match.homeName,
                                            style = TextStyle(
                                                fontSize = 14.sp,
                                                color = black,
                                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                                fontWeight = FontWeight(700),
                                            )
                                        )
                                    }
                                    Spacer(modifier = modifier.height(10.dp))
                                    Row(
                                        modifier = modifier,
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        AsyncImage(
                                            modifier = modifier.size(24.dp),
                                            model = match.awayLogo,
                                            contentDescription = "",
                                            contentScale = ContentScale.FillBounds
                                        )
                                        Spacer(modifier = modifier.width(10.dp))
                                        Text(
                                            modifier = modifier,
                                            text = match.awayName,
                                            style = TextStyle(
                                                fontSize = 14.sp,
                                                color = black,
                                                //fontFamily = FontFamily(Font(R.font.gilroy)),
                                                fontWeight = FontWeight(700),
                                            )
                                        )
                                    }
                                }
                                Spacer(modifier = modifier.weight(1f))
                                Column {
                                    Text(
                                        modifier = modifier,
                                        text = match.homeScore?.toString() ?: "-",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            color = black,
                                            //fontFamily = FontFamily(Font(R.font.gilroy)),
                                            fontWeight = FontWeight(700),
                                        )
                                    )
                                    Spacer(modifier = modifier.height(10.dp))
                                    Text(
                                        modifier = modifier,
                                        text = match.awayScore?.toString() ?: "-",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            color = black,
                                            //fontFamily = FontFamily(Font(R.font.gilroy)),
                                            fontWeight = FontWeight(700),
                                        )
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


@Composable
private fun RowH2h(
    modifier: Modifier = Modifier,
    logo: String,
    name: String,
    colorRect: Color,
    score: Int?
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = modifier
                .height(24.dp)
                .width(46.dp)
                .clip(shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp))
                .background(color = colorRect)
        )
        Spacer(modifier = modifier.width(16.dp))
        AsyncImage(
            modifier = modifier.size(24.dp),
            model = logo,
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = modifier.width(16.dp))
        Text(
            modifier = modifier,
            text = name,
            style = TextStyle(
                fontSize = 20.sp,
                color = white176,
                //fontFamily = FontFamily(Font(R.font.gilroy)),
                fontWeight = FontWeight(700),
            )
        )
        Spacer(modifier = modifier.weight(1f))
        Text(
            modifier = modifier,
            text = score?.toString() ?: "-",
            style = TextStyle(
                fontSize = 20.sp,
                color = white176,
                textAlign = TextAlign.Center,
                //fontFamily = FontFamily(Font(R.font.gilroy)),
                fontWeight = FontWeight(700),
            )
        )
    }
}