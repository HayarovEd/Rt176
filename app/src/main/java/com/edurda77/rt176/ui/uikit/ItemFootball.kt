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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.edurda77.rt176.R
import com.edurda77.rt176.domain.model.FootballMatchRt176
import com.edurda77.rt176.domain.utils.formattedDateRt176
import com.edurda77.rt176.domain.utils.generateRandomColorRt175
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.TypeEventsRt176
import com.edurda77.rt176.ui.state.TypeGame
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.yellow
import java.time.LocalDate

@Preview
@Composable
private fun Sample() {
    ItemFootball(footballMatchRt176 = FootballMatchRt176(
        awayId = 449,
        awayName = "Banfield",
        awayImage = "https://media.api-sports.io/football/teams/449.png",
        awayScoreFirstTime = 0,
        awayScoreSecondTime = 0,
        awayScore = 0,
        homeId = 441,
        homeName = "Union Santa Fe cfvfvsv vdvdvdvdvdv  df",
        homeImage = "https://media.api-sports.io/football/teams/441.png",
        homeScoreFirstTime = 0,
        homeScoreSecondTime = 1,
        homeScore = 1,
        currentTimeMatch = 90,
        dateStamp = "2024-05-14",
        timeStamp = "00:00",
        isPlay = false,
        statusGame = "Окончен",
        awayColor = generateRandomColorRt175(),
        homeColor = generateRandomColorRt175()
    ),
        event = {})
}


@Composable
fun ItemFootball(
    modifier: Modifier = Modifier,
    footballMatchRt176: FootballMatchRt176,
    event: (ApplicationEventRt176) -> Unit
) {
    val isToday = LocalDate.now().formattedDateRt176() == footballMatchRt176.dateStamp
    val dsk = if (isToday) stringResource(R.string.today) else footballMatchRt176.dateStamp
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {
                event(ApplicationEventRt176.GetH2hData176(
                    idHome = footballMatchRt176.homeId,
                    homeLogo = footballMatchRt176.homeImage,
                    homeName = footballMatchRt176.homeName,
                    homeScore = footballMatchRt176.homeScore,
                    idAway = footballMatchRt176.awayId,
                    awayLogo = footballMatchRt176.awayImage,
                    awayName = footballMatchRt176.awayName,
                    awayScore = footballMatchRt176.awayScore,
                    title = "$dsk в ${footballMatchRt176.timeStamp}",
                    typeEventsRt176 = TypeEventsRt176.GamesOfDayRt176(TypeGame.FootballRt176()),
                    awayColor = footballMatchRt176.awayColor,
                    homeColor = footballMatchRt176.homeColor
                ))
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
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_football),
            contentDescription = "",
            tint = yellow
        )
        Spacer(modifier = modifier.width(20.dp))
        Column(
           modifier = modifier.width(200.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = modifier
                        .size(36.dp)
                        .background(color = Color(footballMatchRt176.homeColor)),
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
                        .background(color = Color(footballMatchRt176.awayColor)),
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
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier,
                text = dsk,
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
                text = footballMatchRt176.timeStamp,
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