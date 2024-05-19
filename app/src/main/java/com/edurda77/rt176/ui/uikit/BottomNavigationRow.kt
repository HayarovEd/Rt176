package com.edurda77.rt176.ui.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.edurda77.rt176.R
import com.edurda77.rt176.ui.state.ApplicationEventRt176
import com.edurda77.rt176.ui.state.ApplicationStRt176
import com.edurda77.rt176.ui.state.TypeEventsRt176
import com.edurda77.rt176.ui.state.TypeGame
import com.edurda77.rt176.ui.state.TypeProfileRt176
import com.edurda77.rt176.ui.theme.darkRed
import com.edurda77.rt176.ui.theme.grey
import com.edurda77.rt176.ui.theme.yellow

@Composable
fun BottomNavigationRow(
    modifier: Modifier = Modifier,
    applicationStRt176: ApplicationStRt176,
    nameRt176:String,
    phoneRt176:String,
    eventRt176: (ApplicationEventRt176) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(color = yellow)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ItemNavigation(
            iconRt176 = ImageVector.vectorResource(id = R.drawable.events),
            colorRt176 = if (applicationStRt176 is ApplicationStRt176.EventsRt176) darkRed else grey,
            onClickClRt176 = {
                eventRt176(
                    ApplicationEventRt176.OnSetApplicationStateRt176(
                        ApplicationStRt176.EventsRt176(
                            TypeEventsRt176.GamesOfDay(TypeGame.FootballRt176())
                        )
                    )
                )
            }
        )
        ItemNavigation(
            iconRt176 = ImageVector.vectorResource(id = R.drawable.game),
            colorRt176 = if (applicationStRt176 is ApplicationStRt176.GameRt176) darkRed else grey,
            onClickClRt176 = {
                eventRt176(
                    ApplicationEventRt176.OnSetApplicationStateRt176(
                        ApplicationStRt176.GameRt176()
                    )
                )
            }
        )
        ItemNavigation(
            iconRt176 = ImageVector.vectorResource(id = R.drawable.profile),
            colorRt176 = if (applicationStRt176 is ApplicationStRt176.Profile) darkRed else grey,
            onClickClRt176 = {
                if (nameRt176.isEmpty()||phoneRt176.isEmpty()) {
                    eventRt176(
                        ApplicationEventRt176.OnSetApplicationStateRt176(
                            ApplicationStRt176.Profile(TypeProfileRt176.EditDataRt176())
                        )
                    )
                } else {
                    eventRt176(
                        ApplicationEventRt176.OnSetApplicationStateRt176(
                            ApplicationStRt176.Profile(TypeProfileRt176.DataRt176())
                        )
                    )
                }
            }
        )
    }
}

@Composable
private fun ItemNavigation(
    modifier: Modifier = Modifier,
    iconRt176: ImageVector,
    colorRt176: Color,
    onClickClRt176: () -> Unit
) {
    IconButton(onClick = onClickClRt176) {
        Icon(
            imageVector = iconRt176,
            contentDescription = "",
            tint = colorRt176
        )
    }
}