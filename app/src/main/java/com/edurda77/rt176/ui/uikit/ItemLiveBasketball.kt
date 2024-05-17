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


@Composable
fun ItemLiveBasketball(
    modifier: Modifier = Modifier,
    basketballMatchRt176: BasketballMatchRt176,
    event: (ApplicationEventRt176) -> Unit
) {
    val isToday = LocalDate.now().formattedDateRt176() == basketballMatchRt176.dateStamp
    val dsk = "${stringResource(R.string.lives)}, ${basketballMatchRt176.statusGame}, ${basketballMatchRt176.currentTimeMatch}`"
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {
                event(
                    ApplicationEventRt176.GetH2hData176(
                        idHome = basketballMatchRt176.homeId,
                        homeLogo = basketballMatchRt176.homeImage,
                        homeName = basketballMatchRt176.homeName,
                        homeScore = basketballMatchRt176.homeScore,
                        idAway = basketballMatchRt176.awayId,
                        awayLogo = basketballMatchRt176.awayImage,
                        awayName = basketballMatchRt176.awayName,
                        awayScore = basketballMatchRt176.awayScore,
                        title = dsk,
                        typeEventsRt176 = TypeEventsRt176.LiveGames(TypeGame.BasketballRt176())
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
                text = "${basketballMatchRt176.statusGame}, ${basketballMatchRt176.currentTimeMatch}`",
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
                    model = basketballMatchRt176.homeImage,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    modifier = modifier,
                    text = basketballMatchRt176.homeName,
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
                    model = basketballMatchRt176.awayImage,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    modifier = modifier,
                    text = basketballMatchRt176.awayName,
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
        if (basketballMatchRt176.homeQuarter1!=null&&basketballMatchRt176.awayQuarter1!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = basketballMatchRt176.homeQuarter1.toString(),
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
                    text = basketballMatchRt176.awayQuarter1.toString(),
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
        if (basketballMatchRt176.homeQuarter2!=null&&basketballMatchRt176.awayQuarter2!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = basketballMatchRt176.homeQuarter2.toString(),
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
                    text = basketballMatchRt176.awayQuarter2.toString(),
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
        if (basketballMatchRt176.homeQuarter3!=null&&basketballMatchRt176.awayQuarter3!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = basketballMatchRt176.homeQuarter3.toString(),
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
                    text = basketballMatchRt176.awayQuarter3.toString(),
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
        if (basketballMatchRt176.homeQuarter4!=null&&basketballMatchRt176.awayQuarter4!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = basketballMatchRt176.homeQuarter4.toString(),
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
                    text = basketballMatchRt176.awayQuarter4.toString(),
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
        if (basketballMatchRt176.homeScore!=null&&basketballMatchRt176.awayScore!=null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier,
                    text = basketballMatchRt176.homeScore.toString(),
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
                    text = basketballMatchRt176.awayScore.toString(),
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