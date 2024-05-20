package com.edurda77.rt176.ui.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.edurda77.rt176.R
import com.edurda77.rt176.domain.model.HockeyMatchRt176
import com.edurda77.rt176.domain.utils.formattedDateRt176
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.TypeEventsRt176
import com.edurda77.rt176.ui.state.TypeGame
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.yellow
import java.time.LocalDate


@Composable
fun ItemLiveHockey(
    modifier: Modifier = Modifier,
    hockeyMatchRt176: HockeyMatchRt176,
    event: (ApplicationEventRt176) -> Unit
) {
    val isToday = LocalDate.now().formattedDateRt176() == hockeyMatchRt176.dateStamp
    val dsk = "${stringResource(R.string.lives)}, ${hockeyMatchRt176.statusGame}, ${hockeyMatchRt176.currentTimeMatch}`"
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {
                event(
                    ApplicationEventRt176.GetH2hData176(
                        idHome = hockeyMatchRt176.homeId,
                        homeLogo = hockeyMatchRt176.homeImage,
                        homeName = hockeyMatchRt176.homeName,
                        homeScore = hockeyMatchRt176.homeScore,
                        idAway = hockeyMatchRt176.awayId,
                        awayLogo = hockeyMatchRt176.awayImage,
                        awayName = hockeyMatchRt176.awayName,
                        awayScore = hockeyMatchRt176.awayScore,
                        title = dsk,
                        typeEventsRt176 = TypeEventsRt176.LiveGamesRt176(TypeGame.HockeyRt176()),
                        awayColor = hockeyMatchRt176.awayColor,
                        homeColor = hockeyMatchRt176.homeColor
                    )
                )
            }
            .background(color = darkRed)
            .padding(top = 5.dp, bottom = 5.dp, end = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        VerticalDivider(
            modifier = modifier.height(80.dp),
            thickness = 2.dp,
            color = yellow
        )
        Spacer(modifier = modifier.width(20.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier,
                text = stringResource(R.string.lives),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = yellow,
                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                    fontWeight = FontWeight(700),
                )
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                modifier = modifier,
                text = "${hockeyMatchRt176.statusGame}, ${hockeyMatchRt176.currentTimeMatch}`",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = yellow,
                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                    fontWeight = FontWeight(700),
                )
            )
        }
        Spacer(modifier = modifier.width(20.dp))
        Column (
            modifier = modifier.width(200.dp),
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = modifier
                        .size(36.dp)
                        .background(color = Color(hockeyMatchRt176.homeColor)),
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.homeName,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Spacer(modifier = modifier.height(14.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = modifier
                        .size(36.dp)
                        .background(color = Color(hockeyMatchRt176.awayColor)),
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.awayName,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = modifier.weight(1f))
        if (hockeyMatchRt176.scoreHomeFirstPeriod!=null&&hockeyMatchRt176.scoreAwayFirstPeriod!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.scoreHomeFirstPeriod,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow.copy(alpha = 0.8f),
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
                Spacer(modifier = modifier.height(35.dp))
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.scoreAwayFirstPeriod.toString(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow.copy(alpha = 0.8f),
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
            }
        }
        Spacer(modifier = modifier.width(5.dp))
        if (hockeyMatchRt176.scoreHomeSecondPeriod!=null&&hockeyMatchRt176.scoreAwaySecondPeriod!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.scoreHomeSecondPeriod.toString(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow.copy(alpha = 0.8f),
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
                Spacer(modifier = modifier.height(35.dp))
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.scoreAwaySecondPeriod.toString(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow.copy(alpha = 0.8f),
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
            }
        }
        Spacer(modifier = modifier.width(5.dp))
        if (hockeyMatchRt176.scoreHomeThirdPeriod!=null&&hockeyMatchRt176.scoreAwayThirdPeriod!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.scoreHomeThirdPeriod.toString(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow.copy(alpha = 0.8f),
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
                Spacer(modifier = modifier.height(35.dp))
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.scoreAwayThirdPeriod.toString(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow.copy(alpha = 0.8f),
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
            }
        }
        Spacer(modifier = modifier.width(5.dp))
        if (hockeyMatchRt176.homeScore!=null&&hockeyMatchRt176.awayScore!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.homeScore.toString(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
                Spacer(modifier = modifier.height(35.dp))
                Text(
                    modifier = modifier,
                    text = hockeyMatchRt176.awayScore.toString(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
            }
        }
    }
}