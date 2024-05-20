package com.edurda77.rt176.ui.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.edurda77.rt176.R
import com.edurda77.rt176.domain.model.FootballMatchRt176
import com.edurda77.rt176.domain.utils.formattedDateRt176
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.TypeEventsRt176
import com.edurda77.rt176.ui.state.TypeGame
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.yellow
import java.time.LocalDate

@Preview
@Composable
private fun Sample() {
    ItemLiveFootball(footballMatchRt176 = FootballMatchRt176(
        awayId = 449,
        awayName = "Banfield",
        awayImage = "https://media.api-sports.io/football/teams/449.png",
        awayScoreFirstTime = 0,
        awayScoreSecondTime = 0,
        awayScore = 0,
        homeId = 441,
        homeName = "Union Santa Fe",
        homeImage = "https://media.api-sports.io/football/teams/441.png",
        homeScoreFirstTime = 0,
        homeScoreSecondTime = 1,
        homeScore = 1,
        currentTimeMatch = 90,
        dateStamp = "2024-05-14",
        timeStamp = "00:00",
        isPlay = false,
        statusGame = "ОК"
    ),
        event = {})
}


@Composable
fun ItemLiveFootball(
    modifier: Modifier = Modifier,
    footballMatchRt176: FootballMatchRt176,
    event: (ApplicationEventRt176) -> Unit
) {
    val isToday = LocalDate.now().formattedDateRt176() == footballMatchRt176.dateStamp
    val dsk = "${stringResource(R.string.lives)}, ${footballMatchRt176.statusGame}, ${footballMatchRt176.currentTimeMatch}`"
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {
                event(
                    ApplicationEventRt176.GetH2hData176(
                        idHome = footballMatchRt176.homeId,
                        homeLogo = footballMatchRt176.homeImage,
                        homeName = footballMatchRt176.homeName,
                        homeScore = footballMatchRt176.homeScore,
                        idAway = footballMatchRt176.awayId,
                        awayLogo = footballMatchRt176.awayImage,
                        awayName = footballMatchRt176.awayName,
                        awayScore = footballMatchRt176.awayScore,
                        title = dsk,
                        typeEventsRt176 = TypeEventsRt176.LiveGamesRt176(TypeGame.FootballRt176())
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
                text = "${footballMatchRt176.statusGame}, ${footballMatchRt176.currentTimeMatch}`",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = yellow,
                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                    fontWeight = FontWeight(700),
                )
            )
        }
        Spacer(modifier = modifier.width(20.dp))
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = modifier.size(36.dp),
                    model = footballMatchRt176.homeImage,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    modifier = modifier,
                    text = footballMatchRt176.homeName,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
            }
            Spacer(modifier = modifier.height(14.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = modifier.size(36.dp),
                    model = footballMatchRt176.awayImage,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    modifier = modifier,
                    text = footballMatchRt176.awayName,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = yellow,
                        //fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(700),
                    )
                )
            }
        }
        Spacer(modifier = modifier.weight(1f))
        if (footballMatchRt176.homeScoreFirstTime!=null&&footballMatchRt176.awayScoreFirstTime!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = footballMatchRt176.homeScoreFirstTime.toString(),
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
                    text = footballMatchRt176.awayScoreFirstTime.toString(),
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
        if (footballMatchRt176.homeScoreSecondTime!=null&&footballMatchRt176.awayScoreSecondTime!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = footballMatchRt176.homeScoreSecondTime.toString(),
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
                    text = footballMatchRt176.awayScoreSecondTime.toString(),
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
        if (footballMatchRt176.homeScore!=null&&footballMatchRt176.awayScore!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = footballMatchRt176.homeScore.toString(),
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
                    text = footballMatchRt176.awayScore.toString(),
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