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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.edurda77.rt176.R
import com.edurda77.rt176.domain.model.BasketballMatchRt176
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
    ItemBasketball(basketballMatchRt176 = BasketballMatchRt176(
        awayId = 449,
        awayName = "Banfield",
        awayImage = "https://media.api-sports.io/football/teams/449.png",
        awayQuarter1 = 23,
        awayQuarter2 = 22,
        awayQuarter3 = 45,
        awayQuarter4 = 45,
        awayScore = 0,
        homeId = 441,
        homeName = "Union Santa Fe",
        homeImage = "https://media.api-sports.io/football/teams/441.png",
        homeQuarter1 = 23,
        homeQuarter2 = 22,
        homeQuarter3 = 45,
        homeQuarter4 = 45,
        homeScore = 1,
        currentTimeMatch = null,
        dateStamp = "2024-05-14",
        timeStamp = "00:00",
        isPlay = false,
        statusGame = "Окончен",
        awayColor = 1,
        homeColor = 100,
    ),
        timeTexSize = 14.sp,
        eventRt176 = {})
}


@Composable
fun ItemBasketball(
    modifier: Modifier = Modifier,
    basketballMatchRt176: BasketballMatchRt176,
    timeTexSize: TextUnit,
    eventRt176: (ApplicationEventRt176) -> Unit
) {
    val isToday = LocalDate.now().formattedDateRt176() == basketballMatchRt176.dateStamp
    val dsk = if (isToday) stringResource(R.string.today) else basketballMatchRt176.dateStamp
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {
                eventRt176(ApplicationEventRt176.GetH2hData176(
                    idHome = basketballMatchRt176.homeId,
                    homeLogo = basketballMatchRt176.homeImage,
                    homeName = basketballMatchRt176.homeName,
                    homeScore = basketballMatchRt176.homeScore,
                    idAway = basketballMatchRt176.awayId,
                    awayLogo = basketballMatchRt176.awayImage,
                    awayName = basketballMatchRt176.awayName,
                    awayScore = basketballMatchRt176.awayScore,
                    title = "$dsk в ${basketballMatchRt176.timeStamp}",
                    typeEventsRt176 = TypeEventsRt176.GamesOfDayRt176(TypeGame.BasketballRt176()),
                    awayColor = basketballMatchRt176.awayColor,
                    homeColor = basketballMatchRt176.homeColor,
                    icon = R.drawable.ic_basketball
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
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_basketball),
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
                Icon(
                    modifier = modifier.size(36.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_basketball),
                    contentDescription = "",
                    tint = Color(basketballMatchRt176.homeColor)
                )
               /* AsyncImage(
                    modifier = modifier.size(36.dp),
                    model = basketballMatchRt176.homeImage,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )*/
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    modifier = modifier,
                    text = basketballMatchRt176.homeName,
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
                Icon(
                    modifier = modifier.size(36.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_basketball),
                    contentDescription = "",
                    tint = Color(basketballMatchRt176.awayColor)
                )
                /*AsyncImage(
                    modifier = modifier.size(36.dp),
                    model = basketballMatchRt176.awayImage,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )*/
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    modifier = modifier,
                    text = basketballMatchRt176.awayName,
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
                    fontSize = timeTexSize,
                    color = yellow,
                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                    fontWeight = FontWeight(700),
                )
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                modifier = modifier,
                text = basketballMatchRt176.timeStamp,
                style = TextStyle(
                    fontSize = timeTexSize,
                    color = yellow,
                    //fontFamily = FontFamily(Font(R.font.gilroy)),
                    fontWeight = FontWeight(700),
                )
            )
        }
    }
}